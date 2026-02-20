# Recycle Bin System Architecture

## High-Level Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────────┐
│                         FRONTEND (React)                            │
├─────────────────────────────────────────────────────────────────────┤
│                                                                     │
│  ┌──────────────────┐    ┌──────────────────┐                     │
│  │  Products Page   │    │  Recycle Bin     │                     │
│  │                  │    │  Page (NEW)      │                     │
│  │  - Active Only   │    │                  │                     │
│  │  - No Status Col │    │  - Deleted Items │                     │
│  │  - Edit/Delete   │    │  - Search        │                     │
│  │                  │    │  - Restore       │                     │
│  └────────┬─────────┘    └────────┬─────────┘                     │
│           │                       │                                │
│           │ GET /active          │ GET /deleted                   │
│           │ DELETE /{id}         │ POST /{id}/restore             │
└───────────┼───────────────────────┼────────────────────────────────┘
            │                       │
            ▼                       ▼
┌─────────────────────────────────────────────────────────────────────┐
│                      BACKEND API (Spring Boot)                      │
├─────────────────────────────────────────────────────────────────────┤
│                                                                     │
│  ┌──────────────────────────────────────────────────────────────┐  │
│  │              AdminController                                 │  │
│  │  ┌────────────────────────────────────────────────────────┐ │  │
│  │  │ GET  /api/admin/products        → Active Products      │ │  │
│  │  │ GET  /api/admin/products/active → Active Products      │ │  │
│  │  │ GET  /api/admin/products/deleted → Deleted Products    │ │  │
│  │  │ DELETE /api/admin/products/{id}  → Soft Delete         │ │  │
│  │  │ POST /api/admin/products/{id}/restore → Restore        │ │  │
│  │  └────────────────────────────────────────────────────────┘ │  │
│  └──────────────────────────┬───────────────────────────────────┘  │
│                             │                                       │
│  ┌──────────────────────────▼───────────────────────────────────┐  │
│  │              ProductServiceImpl                              │  │
│  │  ┌────────────────────────────────────────────────────────┐ │  │
│  │  │ getActiveProducts()    → findByIsDeleted(false)        │ │  │
│  │  │ getDeletedProducts()   → findByIsDeleted(true)         │ │  │
│  │  │ deleteProduct()        → Set isDeleted=true, deletedAt │ │  │
│  │  │ restoreProduct()       → Set isDeleted=false, null     │ │  │
│  │  └────────────────────────────────────────────────────────┘ │  │
│  └──────────────────────────┬───────────────────────────────────┘  │
│                             │                                       │
│  ┌──────────────────────────▼───────────────────────────────────┐  │
│  │           ProductRepository (JPA)                            │  │
│  │  ┌────────────────────────────────────────────────────────┐ │  │
│  │  │ findByIsDeleted(boolean)                               │ │  │
│  │  │ findByIsDeletedAndDeletedAtBefore(boolean, LocalDT)    │ │  │
│  │  └────────────────────────────────────────────────────────┘ │  │
│  └──────────────────────────┬───────────────────────────────────┘  │
│                             │                                       │
└─────────────────────────────┼───────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────────────┐
│                      DATABASE (MySQL)                               │
├─────────────────────────────────────────────────────────────────────┤
│                                                                     │
│  ┌──────────────────────────────────────────────────────────────┐  │
│  │                    Products Table                            │  │
│  │  ┌────────────────────────────────────────────────────────┐ │  │
│  │  │ id (PK)                                                 │ │  │
│  │  │ sku                                                     │ │  │
│  │  │ product_name                                            │ │  │
│  │  │ category                                                │ │  │
│  │  │ supplier                                                │ │  │
│  │  │ unit_price                                              │ │  │
│  │  │ quantity                                                │ │  │
│  │  │ is_deleted (BOOLEAN) ← Soft delete flag                │ │  │
│  │  │ deleted_at (TIMESTAMP) ← Deletion timestamp            │ │  │
│  │  │ created_at                                              │ │  │
│  │  │ updated_at                                              │ │  │
│  │  └────────────────────────────────────────────────────────┘ │  │
│  └──────────────────────────────────────────────────────────────┘  │
│                                                                     │
└─────────────────────────────────────────────────────────────────────┘

                              ▲
                              │
                              │ Runs daily at 2:00 AM
                              │
┌─────────────────────────────┴───────────────────────────────────────┐
│                  SCHEDULER (Background Job)                         │
├─────────────────────────────────────────────────────────────────────┤
│                                                                     │
│  ┌──────────────────────────────────────────────────────────────┐  │
│  │        PermanentDeletionScheduler                            │  │
│  │                                                              │  │
│  │  @Scheduled(cron = "0 0 2 * * ?") // Daily at 2 AM          │  │
│  │                                                              │  │
│  │  permanentlyDeleteSoftDeletedRecords() {                    │  │
│  │    cutoffDate = now() - 30 days                             │  │
│  │    productsToDelete = findByIsDeletedAndDeletedAtBefore()   │  │
│  │    permanentlyDelete(productsToDelete)                      │  │
│  │  }                                                           │  │
│  │                                                              │  │
│  │  Configuration: app.permanent-delete-days=30                │  │
│  └──────────────────────────────────────────────────────────────┘  │
│                                                                     │
└─────────────────────────────────────────────────────────────────────┘
```

---

## Data Flow Diagrams

### 1. Delete Product Flow

```
User Action: Click Delete on Product
           │
           ▼
┌─────────────────────────┐
│  Frontend               │
│  ProductManagement.jsx  │
│                         │
│  handleDelete(id)       │
└──────────┬──────────────┘
           │
           │ HTTP DELETE /api/admin/products/{id}
           │
           ▼
┌─────────────────────────┐
│  Backend Controller     │
│  AdminController.java   │
│                         │
│  deleteProduct(id)      │
└──────────┬──────────────┘
           │
           │ Call service method
           │
           ▼
┌─────────────────────────┐
│  Service Layer          │
│  ProductServiceImpl     │
│                         │
│  deleteProduct(id)      │
│  - Set isDeleted=true   │
│  - Set deletedAt=NOW    │
└──────────┬──────────────┘
           │
           │ Save to database
           │
           ▼
┌─────────────────────────┐
│  Database               │
│  Products Table         │
│                         │
│  UPDATE products        │
│  SET is_deleted=1,      │
│      deleted_at=NOW     │
│  WHERE id=?             │
└─────────────────────────┘
           │
           │ Success
           │
           ▼
     Product moved to Recycle Bin
     (Frontend shows success toast)
```

### 2. Restore Product Flow

```
User Action: Click Restore in Recycle Bin
           │
           ▼
┌─────────────────────────┐
│  Frontend               │
│  RecycleBin.jsx         │
│                         │
│  handleRestore(id)      │
└──────────┬──────────────┘
           │
           │ HTTP POST /api/admin/products/{id}/restore
           │
           ▼
┌─────────────────────────┐
│  Backend Controller     │
│  AdminController.java   │
│                         │
│  restoreProduct(id)     │
└──────────┬──────────────┘
           │
           │ Call service method
           │
           ▼
┌─────────────────────────┐
│  Service Layer          │
│  ProductServiceImpl     │
│                         │
│  restoreProduct(id)     │
│  - Set isDeleted=false  │
│  - Set deletedAt=NULL   │
└──────────┬──────────────┘
           │
           │ Save to database
           │
           ▼
┌─────────────────────────┐
│  Database               │
│  Products Table         │
│                         │
│  UPDATE products        │
│  SET is_deleted=0,      │
│      deleted_at=NULL    │
│  WHERE id=?             │
└─────────────────────────┘
           │
           │ Success
           │
           ▼
     Product restored to active list
     (Frontend shows success toast)
```

### 3. Automatic Cleanup Flow (30-Day Deletion)

```
Scheduler Trigger: Daily at 2:00 AM
           │
           ▼
┌─────────────────────────────────────┐
│  Spring Scheduler                   │
│  PermanentDeletionScheduler         │
│                                     │
│  @Scheduled(cron = "0 0 2 * * ?")   │
└──────────┬──────────────────────────┘
           │
           │ Calculate cutoff date
           │ cutoffDate = now() - 30 days
           │
           ▼
┌─────────────────────────────────────┐
│  Query Database                     │
│                                     │
│  SELECT * FROM products             │
│  WHERE is_deleted=1                 │
│  AND deleted_at < cutoffDate        │
└──────────┬──────────────────────────┘
           │
           │ Returns list of products
           │
           ▼
┌─────────────────────────────────────┐
│  Permanent Deletion                 │
│                                     │
│  DELETE FROM products               │
│  WHERE id IN (...)                  │
│                                     │
│  (Physical removal from database)   │
└─────────────────────────────────────┘
           │
           │ Log results
           │
           ▼
     "Permanently deleted X products"
     (Logged in application logs)
```

---

## Component Interaction Matrix

| Component | Interacts With | Purpose |
|-----------|----------------|---------|
| **ProductManagement.jsx** | adminAPI.getActiveProducts() | Fetch only active products |
| **ProductManagement.jsx** | adminAPI.deleteProduct(id) | Soft delete (move to bin) |
| **RecycleBin.jsx** | adminAPI.getDeletedProducts() | Fetch deleted products |
| **RecycleBin.jsx** | adminAPI.restoreProduct(id) | Restore product |
| **AdminController** | ProductService | Delegate business logic |
| **ProductServiceImpl** | ProductRepository | Database operations |
| **ProductRepository** | MySQL Database | JPA queries |
| **PermanentDeletionScheduler** | ProductRepository | Cleanup old records |

---

## State Transitions

```
┌─────────────┐
│   ACTIVE    │ ← Product created or restored
│ (isDeleted= │
│   false)    │
└──────┬──────┘
       │
       │ User clicks Delete
       │
       ▼
┌─────────────┐
│   DELETED   │ ← Soft deleted, in Recycle Bin
│ (isDeleted= │
│   true)     │
│ deletedAt   │
│   set       │
└──────┬──────┘
       │
       ├──────────────────────┐
       │                      │
       │ User clicks Restore  │ 30 days pass
       │                      │ Scheduler runs
       ▼                      ▼
┌─────────────┐        ┌─────────────┐
│   ACTIVE    │        │ PERMANENTLY │
│ (restored)  │        │  DELETED    │
└─────────────┘        │ (removed    │
                       │  from DB)   │
                       └─────────────┘
```

---

## Security & Authorization

```
┌──────────────────────────────────────────────────────┐
│              Role-Based Access Control               │
├──────────────────────────────────────────────────────┤
│                                                      │
│  MASTER_ADMIN                                        │
│    ✅ View all products                              │
│    ✅ Delete products                                │
│    ✅ Access Recycle Bin                             │
│    ✅ Restore products                               │
│                                                      │
│  ADMIN                                               │
│    ✅ View all products                              │
│    ✅ Delete products                                │
│    ✅ Access Recycle Bin                             │
│    ✅ Restore products                               │
│                                                      │
│  EMPLOYEE                                            │
│    ✅ View products                                  │
│    ❌ Delete products                                │
│    ❌ Access Recycle Bin                             │
│    ❌ Restore products                               │
│                                                      │
└──────────────────────────────────────────────────────┘

API Endpoints Security:
  @PreAuthorize("hasRole('ADMIN')")
  - /api/admin/products/*
  - /api/admin/products/deleted
  - DELETE /api/admin/products/{id}
  - POST /api/admin/products/{id}/restore
```

---

## Performance Considerations

### Database Indexes (Recommended)

```sql
-- Index on is_deleted for fast filtering
CREATE INDEX idx_products_is_deleted 
ON products(is_deleted);

-- Composite index for scheduler query
CREATE INDEX idx_products_deleted_at 
ON products(is_deleted, deleted_at);

-- Ensure faster lookups
CREATE INDEX idx_products_sku 
ON products(sku);
```

### Query Optimization

```java
// Efficient query - uses index
findByIsDeleted(false)  // ✅ Indexed

// Scheduler query - uses composite index
findByIsDeletedAndDeletedAtBefore(true, cutoffDate)  // ✅ Optimized
```

---

## Monitoring & Logging

### Application Logs

```
[SCHEDULER] Permanent deletion job started at 2:00 AM
[SCHEDULER] Cutoff date: 2026-01-05 02:00:00
[SCHEDULER] Found 15 products to permanently delete
[DATABASE] Executing: DELETE FROM products WHERE id IN (...)
[SCHEDULER] Permanently deleted 15 products
[SCHEDULER] Job completed in 234ms
```

### Audit Trail

```java
auditLogService.log("PRODUCT_DELETED", "Product soft deleted: iPhone 11", userId);
auditLogService.log("PRODUCT_RESTORED", "Product restored: iPhone 11", userId);
```

---

## Disaster Recovery

### Backup Strategy

```
┌─────────────────────────────────────┐
│  Before Scheduler Runs (2 AM)       │
│  - Create database backup           │
│  - Verify backup integrity          │
│  - Store backup securely            │
└─────────────────────────────────────┘
         │
         ▼
┌─────────────────────────────────────┐
│  Run Permanent Deletion             │
│  - Delete records older than 30d    │
│  - Log all deletions                │
└─────────────────────────────────────┘
         │
         ▼
┌─────────────────────────────────────┐
│  Post-Deletion Verification         │
│  - Confirm expected count deleted   │
│  - Alert if anomalies detected      │
└─────────────────────────────────────┘
```

### Recovery Options

1. **Within 30 days:** Use Restore button in Recycle Bin
2. **After permanent deletion:** Restore from nightly database backup
3. **Emergency:** Contact DBA with backup timestamp

---

This architecture ensures:
- ✅ Data safety with 30-day recovery window
- ✅ Performance optimization with proper indexing
- ✅ Security with role-based access control
- ✅ Auditability with comprehensive logging
- ✅ Automation with scheduled cleanup
- ✅ Scalability with efficient queries
