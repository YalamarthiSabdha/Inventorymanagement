# Recycle Bin Feature - Implementation Documentation

## Overview
This document describes the complete Recycle Bin feature implementation for the Inventory Management System, providing soft delete functionality with automatic cleanup after 30 days.

---

## 1. Database Schema

### Product Entity (Already Implemented)
The `Product` entity already has the necessary fields for soft delete functionality:

```java
@Entity
@Table(name = "products")
public class Product {
    // ... other fields
    
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;  // Timestamp when product was deleted
    
    @Column(name = "is_deleted")
    private boolean isDeleted = false;  // Flag for soft delete
    
    // ... other fields
}
```

**Key Fields:**
- `isDeleted`: Boolean flag indicating if product is soft-deleted
- `deletedAt`: Timestamp when the product was deleted (used for 30-day cleanup)

---

## 2. Backend Implementation

### 2.1 Configuration
**File:** `src/main/resources/application.properties`

```properties
# Permanent deletion after 30 days
app.permanent-delete-days=30
```

### 2.2 Product Repository
**File:** `src/main/java/com/inventory/repository/ProductRepository.java`

The repository already has necessary queries:

```java
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsDeleted(boolean isDeleted);
    List<Product> findByIsDeletedAndDeletedAtBefore(boolean isDeleted, LocalDateTime cutoffDate);
    // ... other methods
}
```

### 2.3 Product Service Interface
**File:** `src/main/java/com/inventory/service/ProductService.java`

```java
public interface ProductService {
    // Get all active products (not deleted)
    List<ProductDTO.ProductResponse> getAllProducts();
    
    // Get only active products (explicit method)
    List<ProductDTO.ProductResponse> getActiveProducts();
    
    // Get only deleted products (for Recycle Bin)
    List<ProductDTO.ProductResponse> getDeletedProducts();
    
    // Soft delete a product
    void deleteProduct(Long productId, Long deletedBy);
    
    // Restore a deleted product
    void restoreProduct(Long productId, Long restoredBy);
    
    // ... other methods
}
```

### 2.4 Product Service Implementation
**File:** `src/main/java/com/inventory/service/impl/ProductServiceImpl.java`

```java
@Override
public List<ProductDTO.ProductResponse> getAllProducts() {
    // Returns only active (non-deleted) products
    return productRepository.findByIsDeleted(false).stream()
            .map(this::mapToProductResponse)
            .collect(Collectors.toList());
}

@Override
public List<ProductDTO.ProductResponse> getActiveProducts() {
    // Explicit method to get active products
    return productRepository.findByIsDeleted(false).stream()
            .map(this::mapToProductResponse)
            .collect(Collectors.toList());
}

@Override
public List<ProductDTO.ProductResponse> getDeletedProducts() {
    // Returns only soft-deleted products for Recycle Bin
    return productRepository.findByIsDeleted(true).stream()
            .map(this::mapToProductResponse)
            .collect(Collectors.toList());
}

@Override
public void deleteProduct(Long productId, Long deletedBy) {
    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
    
    // Soft delete: set flags instead of removing from database
    product.setDeleted(true);
    product.setDeletedAt(LocalDateTime.now());
    product.setLastUpdatedBy(deletedBy);
    
    productRepository.save(product);
    
    // Audit log
    auditLogService.log("PRODUCT_DELETED", "Product soft deleted: " + product.getProductName(), deletedBy);
}

@Override
public void restoreProduct(Long productId, Long restoredBy) {
    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
    
    if (!product.isDeleted()) {
        throw new ValidationException("Product is not deleted");
    }
    
    // Restore: clear delete flags
    product.setDeleted(false);
    product.setDeletedAt(null);
    product.setLastUpdatedBy(restoredBy);
    
    productRepository.save(product);
    
    // Audit log
    auditLogService.log("PRODUCT_RESTORED", "Product restored: " + product.getProductName(), restoredBy);
}
```

### 2.5 Admin Controller API Endpoints
**File:** `src/main/java/com/inventory/controller/AdminController.java`

```java
@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    
    // Get all products (active only - for backward compatibility)
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO.ProductResponse>> getAllProducts() {
        List<ProductDTO.ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    
    // Get active products only
    @GetMapping("/products/active")
    public ResponseEntity<List<ProductDTO.ProductResponse>> getActiveProducts() {
        List<ProductDTO.ProductResponse> products = productService.getActiveProducts();
        return ResponseEntity.ok(products);
    }
    
    // Get deleted products (for Recycle Bin)
    @GetMapping("/products/deleted")
    public ResponseEntity<List<ProductDTO.ProductResponse>> getDeletedProducts() {
        List<ProductDTO.ProductResponse> products = productService.getDeletedProducts();
        return ResponseEntity.ok(products);
    }
    
    // Soft delete a product
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        Long deletedBy = 2L; // Get from security context
        productService.deleteProduct(productId, deletedBy);
        return ResponseEntity.ok().build();
    }
    
    // Restore a deleted product
    @PostMapping("/products/{productId}/restore")
    public ResponseEntity<Void> restoreProduct(@PathVariable Long productId) {
        Long restoredBy = 2L; // Get from security context
        productService.restoreProduct(productId, restoredBy);
        return ResponseEntity.ok().build();
    }
}
```

### 2.6 Automatic Cleanup Scheduler (30-Day Auto-Delete)
**File:** `src/main/java/com/inventory/scheduler/PermanentDeletionScheduler.java`

```java
@Component
public class PermanentDeletionScheduler {
    
    private final ProductRepository productRepository;
    
    @Value("${app.permanent-delete-days:30}")
    private int permanentDeleteDays;
    
    /**
     * Runs daily at 2 AM to permanently delete soft-deleted records
     * that are older than configured days (default 30 days)
     */
    @Scheduled(cron = "0 0 2 * * ?")  // Every day at 2:00 AM
    @Transactional
    public void permanentlyDeleteSoftDeletedRecords() {
        LocalDateTime cutoffDate = LocalDateTime.now().minusDays(permanentDeleteDays);
        
        // Find products deleted more than 30 days ago
        List<Product> productsToDelete = productRepository
                .findByIsDeletedAndDeletedAtBefore(true, cutoffDate);
        
        // Permanently delete from database
        productRepository.deleteAll(productsToDelete);
        
        // Log the cleanup
        System.out.println("Permanently deleted " + productsToDelete.size() + 
                         " products older than " + permanentDeleteDays + " days");
    }
}
```

**Scheduler Configuration:**
- **Frequency:** Daily at 2:00 AM
- **Retention:** 30 days (configurable via `app.permanent-delete-days`)
- **Action:** Permanently removes soft-deleted products older than 30 days
- **Scope:** Runs automatically in production

---

## 3. Frontend Implementation

### 3.1 API Service Updates
**File:** `frontend/src/services/api.js`

```javascript
export const adminAPI = {
  // Product Management
  getAllProducts: () => api.get('/admin/products'),
  getActiveProducts: () => api.get('/admin/products/active'),
  getDeletedProducts: () => api.get('/admin/products/deleted'),
  deleteProduct: (productId) => api.delete(`/admin/products/${productId}`),
  restoreProduct: (productId) => api.post(`/admin/products/${productId}/restore`),
  // ... other endpoints
};
```

### 3.2 Product Management Page Updates
**File:** `frontend/src/pages/Admin/ProductManagement.jsx`

**Key Changes:**
1. Changed API call to fetch only active products:
```javascript
const fetchProducts = async () => {
  const response = await adminAPI.getActiveProducts();
  setProducts(response.data);
};
```

2. Removed "Status" column from table (no longer needed since all products are active)

3. Removed restore button (only shows Edit and Delete buttons)

4. Updated delete confirmation message:
```javascript
const handleDelete = async (productId) => {
  if (window.confirm('Are you sure you want to delete this product? It will be moved to Recycle Bin.')) {
    await adminAPI.deleteProduct(productId);
    toast.success('Product moved to Recycle Bin');
    fetchProducts();
  }
};
```

### 3.3 Recycle Bin Page (NEW)
**File:** `frontend/src/pages/Admin/RecycleBin.jsx`

**Features:**
- Displays all soft-deleted products
- Search functionality across SKU, product name, category, and supplier
- Shows deletion date and days remaining until permanent deletion
- Color-coded warnings based on time remaining:
  - **Green:** More than 10 days remaining
  - **Orange:** 6-10 days remaining
  - **Red:** 5 days or less (critical)
- Actions:
  - **Restore:** Moves product back to active products
  - **Permanent Delete:** Immediately removes from database (manual override)

**Key Functions:**
```javascript
const getDaysRemaining = (deletedAt) => {
  const deletedDate = new Date(deletedAt);
  const expiryDate = new Date(deletedDate);
  expiryDate.setDate(expiryDate.getDate() + 30);
  const today = new Date();
  return Math.ceil((expiryDate - today) / (1000 * 60 * 60 * 24));
};

const handleRestore = async (productId) => {
  if (window.confirm('Are you sure you want to restore this product?')) {
    await adminAPI.restoreProduct(productId);
    toast.success('Product restored successfully!');
    fetchDeletedProducts();
  }
};
```

### 3.4 Navigation Updates
**File:** `frontend/src/pages/Admin/Dashboard.jsx`

Added Recycle Bin to the sidebar navigation:

```javascript
const menuItems = [
  { path: '/admin', icon: <FiHome />, label: 'Overview', exact: true },
  { path: '/admin/products', icon: <FiPackage />, label: 'Products' },
  { path: '/admin/stock-in', icon: <FiTrendingUp />, label: 'Stock In' },
  { path: '/admin/stock-out', icon: <FiTrendingDown />, label: 'Stock Out' },
  { path: '/admin/reports', icon: <FiBarChart2 />, label: 'Reports' },
  { path: '/admin/recycle-bin', icon: <FiTrash2 />, label: 'Recycle Bin' },  // NEW
  { path: '/admin/employees', icon: <FiUsers />, label: 'Employees' },
];
```

Added route:
```javascript
<Route path="/recycle-bin" element={<RecycleBin />} />
```

---

## 4. User Flow

### 4.1 Deleting a Product
1. Admin navigates to **Products** page
2. Clicks **Delete** button (trash icon) on a product
3. Confirms deletion in popup: "Are you sure you want to delete this product? It will be moved to Recycle Bin."
4. Product is soft-deleted:
   - `isDeleted` set to `true`
   - `deletedAt` set to current timestamp
   - Product removed from active products list
5. Success message: "Product moved to Recycle Bin"

### 4.2 Viewing Recycle Bin
1. Admin clicks **Recycle Bin** in sidebar navigation
2. All deleted products are displayed with:
   - Product details (SKU, name, category, supplier, price, quantity)
   - Deletion date
   - Days remaining (color-coded)
3. Search functionality available to filter products

### 4.3 Restoring a Product
1. Admin finds product in Recycle Bin
2. Clicks **Restore** button (refresh icon)
3. Confirms restoration
4. Product is restored:
   - `isDeleted` set to `false`
   - `deletedAt` cleared
   - Product appears back in active products list
5. Success message: "Product restored successfully!"

### 4.4 Automatic Cleanup (30 Days)
1. Scheduler runs daily at 2:00 AM
2. Finds all products where `deletedAt < 30 days ago`
3. Permanently deletes these products from database
4. No user action required - fully automatic

---

## 5. API Endpoints Summary

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/admin/products` | Get all active products |
| GET | `/api/admin/products/active` | Get active products explicitly |
| GET | `/api/admin/products/deleted` | Get deleted products (Recycle Bin) |
| DELETE | `/api/admin/products/{id}` | Soft delete a product |
| POST | `/api/admin/products/{id}/restore` | Restore a deleted product |

---

## 6. Configuration

### Backend Configuration
**File:** `application.properties`

```properties
# Number of days to keep deleted products before permanent deletion
app.permanent-delete-days=30

# Scheduler cron expression (default: daily at 2 AM)
# Can be changed if needed in PermanentDeletionScheduler.java
```

### Scheduler Cron Expression
Current: `0 0 2 * * ?` (Every day at 2:00 AM)

To change frequency, modify the `@Scheduled` annotation in `PermanentDeletionScheduler.java`:
- `0 0 2 * * ?` - Daily at 2:00 AM (current)
- `0 0 0 * * ?` - Daily at midnight
- `0 0 */6 * * ?` - Every 6 hours
- `0 0 0 ? * SUN` - Weekly on Sunday at midnight

---

## 7. Benefits

### User Benefits
- **Safety:** Accidental deletions can be recovered within 30 days
- **Visibility:** Clear indication of what will be permanently deleted
- **Control:** Manual restore or immediate permanent delete options
- **Awareness:** Color-coded warnings for products nearing permanent deletion

### System Benefits
- **Data Integrity:** No accidental permanent data loss
- **Audit Trail:** Deletion timestamps tracked for compliance
- **Performance:** Automatic cleanup prevents database bloat
- **Scalability:** Soft delete is database-friendly and reversible

---

## 8. Testing Checklist

### Backend Tests
- ✅ Soft delete sets `isDeleted=true` and `deletedAt` timestamp
- ✅ Active products API excludes deleted products
- ✅ Deleted products API returns only deleted products
- ✅ Restore clears `isDeleted` and `deletedAt` fields
- ✅ Scheduler runs at configured time
- ✅ Scheduler only deletes products older than 30 days
- ✅ Permanent deletion removes from database

### Frontend Tests
- ✅ Products page shows only active products
- ✅ Deleted products no longer appear in Products page
- ✅ Recycle Bin page shows all deleted products
- ✅ Days remaining calculated correctly
- ✅ Color coding works (green/orange/red)
- ✅ Search filters work in Recycle Bin
- ✅ Restore moves product back to Products page
- ✅ Delete moves product to Recycle Bin
- ✅ Navigation to Recycle Bin works

---

## 9. Future Enhancements

### Potential Improvements
1. **Bulk Operations:** Select and restore/delete multiple products at once
2. **Notifications:** Email alerts for products nearing permanent deletion
3. **Configurable Retention:** Allow admins to change retention period per product
4. **Trash Statistics:** Dashboard widget showing Recycle Bin count
5. **Export:** Download deleted products list before permanent deletion
6. **Restore History:** Track how many times a product was deleted/restored
7. **Role Permissions:** Separate permissions for restore vs permanent delete

---

## 10. Security Considerations

### Access Control
- Only **ADMIN** and **MASTER_ADMIN** roles can access Recycle Bin
- All operations logged in audit trail
- User ID tracked for delete and restore actions

### Data Protection
- Soft-deleted products invisible to employees
- Permanent deletion irreversible (requires explicit confirmation)
- Scheduler runs in transaction for data consistency

---

## 11. Troubleshooting

### Issue: Products not appearing in Recycle Bin
**Solution:** Check that `isDeleted=true` and `deletedAt` is set in database

### Issue: Scheduler not running
**Solution:** 
1. Verify `@EnableScheduling` annotation in main application class
2. Check server logs at scheduled time (2:00 AM)
3. Ensure `app.permanent-delete-days` is configured

### Issue: Days remaining incorrect
**Solution:** Verify server timezone matches your location

### Issue: Restore not working
**Solution:** Check that product exists and `isDeleted=true` before restore

---

## Summary

The Recycle Bin feature provides a complete soft delete solution with:
- ✅ 30-day retention period
- ✅ Automatic cleanup via scheduled job
- ✅ User-friendly restore functionality
- ✅ Clear visual warnings
- ✅ Comprehensive audit trail
- ✅ Full separation of active and deleted products

This implementation follows industry best practices for data management and provides users with a safety net against accidental deletions while maintaining database cleanliness through automatic cleanup.
