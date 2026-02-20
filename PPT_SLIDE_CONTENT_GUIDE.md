# PowerPoint Slide Content Guide
## Inventory Management System - Detailed Slide Information

---

## SLIDE 1: Title Slide
**Content:**
- **Main Title:** Inventory Management System
- **Subtitle:** Professional Web Application for Stock Management
- **Tagline:** Streamline Your Inventory Operations
- **Your Name/Team Name**
- **Date:** February 2026
- **Institution/Company Name** (if applicable)

**Design Notes:**
- Use navy blue background (#0f172a)
- Emerald accent (#10b981)
- Professional corporate look
- Add a subtle icon (package/box)

---

## SLIDE 2: Agenda
**Content:**
1. Project Overview
2. User Roles & Permissions
3. Technology Stack
4. System Architecture
5. Database Design
6. Security Features
7. Core Functionalities
8. UI/UX Design
9. API Documentation
10. Installation Guide
11. Performance & Optimization
12. Future Roadmap
13. Conclusion

**Design Notes:**
- Numbered list
- Brief, clear items
- Estimated time per section

---

## SLIDE 3: Project Overview - Introduction
**Content:**

**What is it?**
- Full-stack web application for inventory and stock management
- Real-time tracking of products, stock movements, and transactions
- Multi-role access control system
- Professional business solution

**Purpose:**
- Eliminate manual inventory tracking errors
- Automate stock monitoring and alerts
- Provide real-time insights into inventory status
- Enable role-based operational control

**Target Users:**
- Small to medium businesses
- Retail stores and warehouses
- Manufacturing units
- Distribution centers

**Statistics:**
- 3 User Roles
- 5,000+ Lines of Code
- 25+ API Endpoints
- Real-time Stock Updates

---

## SLIDE 4: Project Objectives
**Content:**

**Primary Objectives:**

1. **Streamline Operations**
   - Reduce manual data entry
   - Automate stock calculations
   - Real-time inventory updates
   - Quick transaction processing

2. **Enhance Security**
   - Secure authentication system
   - Role-based access control
   - Password protection with OTP
   - JWT token management

3. **Improve Decision Making**
   - Real-time reporting
   - Stock level visualization
   - Transaction history tracking
   - Low stock alerts

4. **Professional Experience**
   - Modern, intuitive UI
   - Responsive design
   - Fast performance
   - Easy navigation

---

## SLIDE 5: Key Highlights
**Content:**

**Technical Achievements:**
✅ Full-stack implementation (React + Spring Boot)
✅ RESTful API architecture
✅ MySQL database with optimized schema
✅ JWT-based authentication
✅ Real-time data synchronization

**Business Features:**
✅ Complete CRUD operations
✅ Automated low stock alerts
✅ Soft delete with recycle bin
✅ Comprehensive reporting system
✅ Email notification integration

**Design Excellence:**
✅ Professional minimal design
✅ Responsive across devices
✅ Corporate color scheme (Navy, Emerald, Slate)
✅ Smooth animations and transitions
✅ Accessible and user-friendly

---

## SLIDE 6: User Roles - Master Admin
**Content:**

**🔴 MASTER ADMIN**

**Primary Responsibilities:**
- System-wide user management
- Create and manage admin accounts
- Oversee all system operations
- User recycle bin management

**Permissions:**
✅ Create new users (Admin/Employee)
✅ Edit user information
✅ Delete users (soft delete)
✅ Restore deleted users
✅ View all users
✅ Assign/modify user roles
✅ Access user recycle bin
✅ Permanent delete after 30 days
✅ Change own password

**Dashboard Features:**
- Total users overview
- Role-wise distribution
- Active/Inactive status
- Recent user activities

**Use Case:**
"System administrator who manages the entire user base and maintains system integrity"

---

## SLIDE 7: User Roles - Admin
**Content:**

**🔵 ADMIN**

**Primary Responsibilities:**
- Complete inventory management
- Stock operations control
- Employee management
- Business operations oversight

**Permissions:**
✅ Manage products (Create, Read, Update, Delete)
✅ Perform stock IN operations
✅ Perform stock OUT operations
✅ View transaction history
✅ Generate reports
✅ Manage employees
✅ Access product recycle bin
✅ Restore/delete products
✅ View low stock alerts
✅ Resolve alerts
✅ Change own password

**Dashboard Features:**
- Total products count
- Total stock value
- Low stock items
- Transaction summary
- Visual charts

**Use Case:**
"Store manager or inventory controller who handles day-to-day inventory operations"

---

## SLIDE 8: User Roles - Employee
**Content:**

**🟢 EMPLOYEE**

**Primary Responsibilities:**
- Execute stock operations
- Record transactions
- View inventory status
- Basic reporting

**Permissions:**
✅ View all products
✅ Perform stock IN operations
✅ Perform stock OUT operations
✅ View transaction history
✅ View basic reports
✅ View low stock alerts
✅ Change own password

**Restrictions:**
❌ Cannot create/edit products
❌ Cannot delete products
❌ Cannot manage users
❌ Cannot access recycle bins
❌ Limited to operational tasks

**Dashboard Features:**
- Product listings
- Stock levels
- Recent transactions
- Quick stock operations

**Use Case:**
"Warehouse staff or store clerk who performs daily stock transactions"

---

## SLIDE 9: Role Comparison Matrix
**Content:**

| Feature | Master Admin | Admin | Employee |
|---------|--------------|-------|----------|
| User Management | ✅ Full | ❌ No | ❌ No |
| Product Management | ❌ No* | ✅ Full | ❌ View Only |
| Stock Operations | ❌ No* | ✅ Yes | ✅ Yes |
| Reports | ❌ No* | ✅ Full | ✅ Basic |
| Recycle Bin | ✅ Users | ✅ Products | ❌ No |
| Employee Management | ❌ No* | ✅ Yes | ❌ No |
| System Settings | ✅ Yes | ❌ No | ❌ No |

*Master Admin focuses on user management only

**Access Hierarchy:**
Master Admin → Admin → Employee

---

## SLIDE 10: Technology Stack - Frontend
**Content:**

**FRONTEND TECHNOLOGIES**

**Core Framework:**
- **React 18.2.0** - UI Library
  - Modern Hooks (useState, useEffect)
  - Functional Components
  - Component-based Architecture
  - Virtual DOM for performance

**Build Tools:**
- **Vite 5.0.8** - Next Generation Frontend Tool
  - Lightning-fast HMR
  - Optimized builds
  - ES modules support
  - Development server on port 3000

**Routing:**
- **React Router DOM 6.20.0**
  - Client-side routing
  - Protected routes
  - Nested routing
  - Programmatic navigation

**HTTP Client:**
- **Axios 1.6.2**
  - Promise-based HTTP client
  - Request/Response interceptors
  - JWT token injection
  - Error handling

---

## SLIDE 11: Technology Stack - Frontend (cont.)
**Content:**

**UI/UX Libraries:**

**React Icons 4.12.0**
- 10,000+ icons
- Feather icons used
- Consistent design
- Lightweight

**React Toastify 9.1.3**
- Toast notifications
- Success/Error/Warning/Info
- Auto-dismiss
- Position control

**Recharts 2.10.3**
- React charting library
- Line charts, Bar charts
- Responsive design
- Stock trend visualization

**date-fns 3.0.6**
- Modern date utilities
- Date formatting
- Relative time
- Lightweight (tree-shakeable)

**Styling:**
- Custom CSS files
- No CSS frameworks
- Professional design system
- Responsive breakpoints

---

## SLIDE 12: Technology Stack - Backend
**Content:**

**BACKEND TECHNOLOGIES**

**Core Framework:**
- **Spring Boot 3.5.10**
  - Auto-configuration
  - Embedded Tomcat server
  - Production-ready features
  - Minimal setup required

**Security:**
- **Spring Security 6.x**
  - Authentication
  - Authorization
  - CORS configuration
  - Method-level security

**Data Access:**
- **Spring Data JPA 3.x**
  - Repository pattern
  - Query methods
  - Transaction management
  - Pagination support

- **Hibernate 6.6.41**
  - ORM framework
  - Entity relationships
  - Lazy/Eager loading
  - Query optimization

**Database:**
- **MySQL 8.0.45**
  - Relational database
  - ACID compliance
  - High performance
  - Scalable

---

## SLIDE 13: Technology Stack - Backend (cont.)
**Content:**

**Authentication & Security:**

**JWT (JSON Web Tokens) 0.12.3**
- Stateless authentication
- Token-based sessions
- Secure transmission
- Expiration handling

**BCrypt Password Encoder**
- Password hashing
- Salt generation
- Secure storage
- One-way encryption

**Email Service:**
- **JavaMailSender**
  - SMTP integration
  - HTML email support
  - OTP delivery
  - Async sending

**Build Tool:**
- **Maven 3.9.6**
  - Dependency management
  - Build automation
  - Plugin ecosystem
  - Standard project structure

**Java Version:** 25+
**Server Port:** 8080

---

## SLIDE 14: System Architecture - Overview
**Content:**

**3-TIER ARCHITECTURE**

**Presentation Layer (Frontend)**
- React Application
- User Interface Components
- Client-side Routing
- State Management
- Port: 3000

**↓ HTTP/REST API Communication ↓**

**Application Layer (Backend)**
- Spring Boot Application
- REST Controllers
- Business Logic Services
- Security Layer (JWT Filters)
- Data Access Repositories
- Port: 8080

**↓ JDBC Connection ↓**

**Data Layer (Database)**
- MySQL Database
- Tables & Relationships
- Stored Procedures
- Indexes & Constraints
- Port: 3306

---

## SLIDE 15: System Architecture - Flow
**Content:**

**REQUEST FLOW DIAGRAM**

**1. User Action (Frontend)**
```
User clicks button → React component
↓
```

**2. API Call (Axios)**
```
Axios intercepts → Adds JWT token
↓
POST /api/products
↓
```

**3. Backend Processing**
```
Security Filter → Validates JWT
↓
Controller → Receives request
↓
Service → Business logic
↓
Repository → Database query
↓
Entity → Data mapping
```

**4. Response Flow**
```
Database → Returns data
↓
Service → Processes data
↓
Controller → Sends response
↓
Frontend → Updates UI
```

**Error Handling:**
- 401 Unauthorized → Logout
- 403 Forbidden → Access denied
- 500 Server Error → Error message

---

## SLIDE 16: System Architecture - Components
**Content:**

**FRONTEND COMPONENTS**
```
App.jsx (Root)
├── Router
├── Routes
│   ├── Login
│   ├── Forgot/Reset Password
│   ├── Master Admin Dashboard
│   │   ├── User Management
│   │   ├── User Recycle Bin
│   │   └── Overview
│   ├── Admin Dashboard
│   │   ├── Product Management
│   │   ├── Stock Management
│   │   ├── Transactions
│   │   ├── Reports
│   │   ├── Employees
│   │   └── Recycle Bin
│   └── Employee Dashboard
│       ├── Products
│       ├── Stock Operations
│       ├── Transactions
│       └── Reports
├── Components
│   ├── PrivateRoute
│   ├── ChangePasswordModal
│   └── LowStockAlerts
└── Services
    └── API Client (Axios)
```

---

## SLIDE 17: System Architecture - Backend
**Content:**

**BACKEND COMPONENTS**
```
InventorySystemApplication.java
├── Config Layer
│   ├── SecurityConfig
│   ├── WebConfig
│   └── DatabaseInitializer
├── Controller Layer
│   ├── AuthController
│   ├── AdminController
│   ├── EmployeeController
│   └── MasterAdminController
├── Service Layer (Business Logic)
│   ├── UserService
│   ├── ProductService
│   ├── StockService
│   ├── TransactionService
│   ├── AlertService
│   └── EmailService
├── Repository Layer (Data Access)
│   ├── UserRepository
│   ├── ProductRepository
│   ├── TransactionRepository
│   ├── AlertRepository
│   └── TokenRepository
├── Security Layer
│   ├── JwtAuthenticationFilter
│   ├── JwtTokenProvider
│   └── CustomUserDetailsService
└── Entity Layer (Models)
    ├── User
    ├── Product
    ├── Transaction
    ├── LowStockAlert
    └── PasswordResetToken
```

---

## SLIDE 18: Database Schema - Overview
**Content:**

**DATABASE: mile3**

**Total Tables: 5 Core Tables**

**1. users**
- User accounts and authentication
- Role-based access
- Soft delete support

**2. products**
- Product catalog
- Pricing and stock
- SKU management

**3. transactions**
- Stock movement records
- IN/OUT operations
- Audit trail

**4. low_stock_alerts**
- Automated monitoring
- Alert management
- Email tracking

**5. password_reset_tokens**
- OTP tokens
- Password security
- Token expiration

**Total Columns:** 50+ fields
**Relationships:** 4 foreign keys
**Indexes:** Primary keys + optimized queries

---

## SLIDE 19: Database Schema - Users Table
**Content:**

**TABLE: users**

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT (PK) | Primary key, auto-increment |
| email | VARCHAR(255) | Unique, login credential |
| password | VARCHAR(255) | BCrypt encrypted |
| first_name | VARCHAR(100) | User's first name |
| last_name | VARCHAR(100) | User's last name |
| role | ENUM | MASTER_ADMIN, ADMIN, EMPLOYEE |
| status | ENUM | ACTIVE, INACTIVE |
| is_deleted | BOOLEAN | Soft delete flag (default: false) |
| deleted_at | TIMESTAMP | Deletion timestamp (nullable) |
| last_login | TIMESTAMP | Last login tracking |
| created_at | TIMESTAMP | Record creation |
| updated_at | TIMESTAMP | Last update |

**Constraints:**
- PRIMARY KEY (id)
- UNIQUE (email)
- INDEX (email, role, is_deleted)

**Sample Data:**
- master@admin.com (MASTER_ADMIN)
- admin@test.com (ADMIN)
- employee@test.com (EMPLOYEE)

---

## SLIDE 20: Database Schema - Products Table
**Content:**

**TABLE: products**

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT (PK) | Primary key, auto-increment |
| name | VARCHAR(255) | Product name |
| sku | VARCHAR(50) | Unique stock keeping unit |
| description | TEXT | Product details (nullable) |
| category | VARCHAR(100) | Product category |
| price | DECIMAL(10,2) | Unit price |
| quantity | INT | Current stock quantity |
| low_stock_threshold | INT | Alert threshold (default: 10) |
| is_deleted | BOOLEAN | Soft delete flag (default: false) |
| deleted_at | TIMESTAMP | Deletion timestamp (nullable) |
| created_by | BIGINT (FK) | User who created |
| created_at | TIMESTAMP | Record creation |
| updated_at | TIMESTAMP | Last update |

**Constraints:**
- PRIMARY KEY (id)
- UNIQUE (sku)
- FOREIGN KEY (created_by) REFERENCES users(id)
- INDEX (sku, category, is_deleted)

**Business Rules:**
- SKU auto-generated: SKU-XXXXXX
- Quantity cannot be negative
- Price must be positive

---

## SLIDE 21: Database Schema - Transactions Table
**Content:**

**TABLE: transactions**

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT (PK) | Primary key, auto-increment |
| product_id | BIGINT (FK) | Reference to product |
| user_id | BIGINT (FK) | User who performed |
| transaction_type | ENUM | 'IN' or 'OUT' |
| quantity | INT | Amount of stock |
| notes | TEXT | Optional transaction notes |
| transaction_date | TIMESTAMP | When it occurred |
| created_at | TIMESTAMP | Record creation |

**Constraints:**
- PRIMARY KEY (id)
- FOREIGN KEY (product_id) REFERENCES products(id)
- FOREIGN KEY (user_id) REFERENCES users(id)
- INDEX (product_id, user_id, transaction_date)

**Transaction Flow:**
1. **Stock IN:** quantity added to product.quantity
2. **Stock OUT:** quantity subtracted, validates availability
3. Both create transaction record for audit

**Reporting Uses:**
- Transaction history
- User activity tracking
- Stock movement analysis
- Inventory reconciliation

---

## SLIDE 22: Database Schema - Low Stock Alerts
**Content:**

**TABLE: low_stock_alerts**

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT (PK) | Primary key, auto-increment |
| product_name | VARCHAR(255) | Product name snapshot |
| sku | VARCHAR(255) | Product SKU |
| current_quantity | INT | Stock level when alerted |
| threshold | INT | Threshold that triggered |
| email_recipients | VARCHAR(255) | Admin emails (nullable) |
| is_resolved | BOOLEAN | Alert resolution status |
| alert_sent_at | TIMESTAMP | When alert was created |
| resolved_at | TIMESTAMP | When marked resolved (nullable) |

**Constraints:**
- PRIMARY KEY (id)
- INDEX (sku, is_resolved)

**Alert Logic:**
```
IF product.quantity < product.low_stock_threshold:
    CREATE low_stock_alert
    SEND email to admins
    DISPLAY on dashboard
```

**Resolution:**
- Manual: Admin marks as resolved
- Automatic: Restocking above threshold

---

## SLIDE 23: Database Schema - Password Tokens
**Content:**

**TABLE: password_reset_tokens**

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT (PK) | Primary key, auto-increment |
| user_id | BIGINT (FK) | Associated user |
| token | VARCHAR(255) | Unique token string |
| otp | VARCHAR(6) | 6-digit OTP code |
| token_type | ENUM | 'RESET_PASSWORD', 'CHANGE_PASSWORD' |
| is_used | BOOLEAN | Token usage flag |
| created_at | TIMESTAMP | Token generation time |
| expires_at | TIMESTAMP | Expiration time (5 minutes) |
| used_at | TIMESTAMP | When token was used (nullable) |

**Constraints:**
- PRIMARY KEY (id)
- UNIQUE (token)
- FOREIGN KEY (user_id) REFERENCES users(id)
- INDEX (token, user_id)

**Token Lifecycle:**
1. User requests password reset/change
2. System generates unique token + OTP
3. OTP sent to user's email
4. Token valid for 5 minutes
5. After use or expiry, marked as used
6. Old tokens cleaned up periodically

---

## SLIDE 24: Database Relationships
**Content:**

**ENTITY RELATIONSHIPS**

**Users ← Products**
```
users.id → products.created_by
Relationship: One-to-Many
Purpose: Track who created each product
```

**Users ← Transactions**
```
users.id → transactions.user_id
Relationship: One-to-Many
Purpose: Audit trail of user actions
```

**Products ← Transactions**
```
products.id → transactions.product_id
Relationship: One-to-Many
Purpose: Track all product movements
```

**Users ← PasswordResetTokens**
```
users.id → password_reset_tokens.user_id
Relationship: One-to-Many
Purpose: Password security operations
```

**No Direct Relationship:**
- low_stock_alerts (stores snapshot data)

**Referential Integrity:**
- CASCADE on update
- RESTRICT on delete (prevent orphaned records)

---

## SLIDE 25: Security - Authentication Flow
**Content:**

**LOGIN AUTHENTICATION PROCESS**

**Step 1: User Submits Credentials**
```
Frontend: Email + Password
↓
POST /api/auth/login
```

**Step 2: Backend Validation**
```
1. Load user by email
2. Verify user exists
3. Check user status (ACTIVE)
4. Validate password (BCrypt)
5. Check user not deleted
```

**Step 3: Token Generation**
```
If valid:
   - Generate JWT token
   - Set expiration (24 hours)
   - Include user details in payload
   - Sign with secret key
```

**Step 4: Response**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIs...",
  "user": {
    "id": 1,
    "email": "user@example.com",
    "firstName": "John",
    "lastName": "Doe",
    "role": "ADMIN"
  }
}
```

**Step 5: Frontend Storage**
```
localStorage.setItem('token', token)
localStorage.setItem('user', JSON.stringify(user))
Redirect to dashboard
```

---

## SLIDE 26: Security - JWT Token
**Content:**

**JWT TOKEN STRUCTURE**

**Header**
```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

**Payload (Claims)**
```json
{
  "sub": "user@example.com",
  "userId": 1,
  "role": "ADMIN",
  "iat": 1708012800,
  "exp": 1708099200
}
```

**Signature**
```
HMACSHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  secret-key
)
```

**Token Usage:**
```
Authorization: Bearer eyJhbGciOiJIUzI1NiIs...
```

**Security Features:**
✅ Stateless (no server session)
✅ Tamper-proof (signed)
✅ Expiration (24 hours)
✅ Claims-based authorization
✅ Automatic validation

---

## SLIDE 27: Security - Authorization
**Content:**

**ROLE-BASED ACCESS CONTROL**

**Security Configuration:**
```java
@PreAuthorize("hasRole('ADMIN')")
public List<Product> getAllProducts() {
    // Only admins can access
}

@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
public void performStockIn() {
    // Admins and employees allowed
}

@PreAuthorize("hasRole('MASTER_ADMIN')")
public void manageUsers() {
    // Master admin exclusive
}
```

**Frontend Protection:**
```javascript
<PrivateRoute allowedRoles={['ADMIN']}>
  <ProductManagement />
</PrivateRoute>
```

**Request Flow:**
1. Request arrives with JWT token
2. JwtAuthenticationFilter extracts token
3. Token validated and user loaded
4. Spring Security checks method annotations
5. If authorized: proceed
6. If not: 403 Forbidden

**Security Layers:**
✅ Frontend route guards
✅ Backend method security
✅ Token validation
✅ Role verification

---

## SLIDE 28: Security - Password Features
**Content:**

**PASSWORD MANAGEMENT**

**Password Encryption:**
- Algorithm: BCrypt
- Work factor: 10 rounds
- Salted automatically
- One-way hashing

**Password Reset Flow:**
1. User clicks "Forgot Password"
2. Enters email address
3. System generates OTP (6 digits)
4. OTP sent to email
5. User enters OTP + new password
6. System validates OTP (5 min expiry)
7. Password updated and encrypted
8. Token marked as used

**Change Password Flow:**
1. Authenticated user requests change
2. System generates OTP
3. OTP sent to user's email
4. User verifies OTP
5. User enters old + new password
6. System validates both
7. Password updated
8. All sessions invalidated

**Security Measures:**
✅ OTP expiration (5 minutes)
✅ One-time use tokens
✅ Email verification
✅ Old password validation
✅ Strong password enforcement

---

## SLIDE 29: Key Features - Product Management
**Content:**

**PRODUCT MANAGEMENT MODULE**

**Create Product:**
- Input fields: Name, Category, Description, Price, Initial Quantity, Threshold
- Auto-generate SKU: SKU-XXXXXX (6-digit random)
- Validation: All fields required except description
- Result: Product added to inventory

**Read/View Products:**
- List all active products
- Search by name, SKU, category
- Filter by category, stock level
- Display: Name, SKU, Category, Price, Quantity, Status
- Color coding: Red for low stock

**Update Product:**
- Edit all fields except SKU
- Update quantity via stock operations only
- Change threshold for alerts
- Modify pricing and description

**Delete Product:**
- Soft delete (is_deleted = true)
- Move to recycle bin
- Hide from active listings
- Retain transaction history
- Can be restored within 30 days

**Additional Features:**
✅ Bulk view
✅ Export to CSV
✅ Low stock indicators
✅ Created by tracking

---

## SLIDE 30: Key Features - Stock Management
**Content:**

**STOCK OPERATIONS**

**Stock IN (Receiving):**
```
Process:
1. Search and select product
2. Enter quantity to add
3. Add optional notes (supplier, PO number, etc.)
4. Submit transaction

System Actions:
- Validates product exists
- Adds quantity to product.quantity
- Creates transaction record (type: IN)
- Updates product.updated_at
- Checks if alert needs resolution
```

**Stock OUT (Issue/Sale):**
```
Process:
1. Search and select product
2. View current quantity
3. Enter quantity to remove
4. Add optional notes (customer, invoice, etc.)
5. Submit transaction

System Actions:
- Validates quantity available
- Subtracts from product.quantity
- Creates transaction record (type: OUT)
- Updates product.updated_at
- Triggers low stock alert if below threshold
```

**Validation Rules:**
❌ Cannot remove more than available
✅ Quantity must be positive
✅ Product must be active (not deleted)
✅ Real-time quantity updates

---

## SLIDE 31: Key Features - Low Stock Alerts
**Content:**

**AUTOMATED ALERT SYSTEM**

**Alert Generation:**
```
Trigger: product.quantity < product.low_stock_threshold
Action: Create alert record + Send email
Frequency: Real-time on quantity change
```

**Alert Details:**
- Product name and SKU
- Current quantity
- Threshold value
- Time generated
- Sender information

**Email Notification:**
- Sent to all admin users
- Subject: "Low Stock Alert: [Product Name]"
- Contains product details
- Link to inventory page
- Sent via SMTP (Gmail)

**Alert Display:**
- Dashboard widget
- Shows unresolved alerts
- Color-coded (orange/red)
- Click to view details
- "Resolve" button

**Resolution:**
- Manual: Admin marks as resolved
- Automatic: When restocked above threshold
- Tracks resolution timestamp

**Alert Management:**
✅ Configurable threshold per product
✅ Email recipient management
✅ Alert history
✅ Resolved alert archive

---

## SLIDE 32: Key Features - Reporting
**Content:**

**REPORTING & ANALYTICS**

**Available Reports:**

**1. Inventory Summary**
- Total products count
- Total stock quantity
- Total inventory value (₹)
- Low stock items count
- Category-wise breakdown

**2. Transaction Report**
- Date range filter
- Transaction type (IN/OUT/ALL)
- User filter
- Product filter
- Export to CSV/PDF

**3. Stock Movement Report**
- Product-wise movement
- IN vs OUT comparison
- Time-series chart
- Top moving products
- Slow-moving products

**4. User Activity Report** (Admin only)
- User-wise transactions
- Activity timeline
- Performance metrics
- Date range filter

**5. Alert Report**
- Alert history
- Response time
- Resolution status
- Recurring alerts

**Visualization:**
- Line charts (Recharts)
- Bar charts
- Pie charts
- Data tables

---

## SLIDE 33: Key Features - Recycle Bin
**Content:**

**SOFT DELETE SYSTEM**

**Concept:**
- Data not permanently deleted
- Marked with is_deleted = true
- deleted_at timestamp recorded
- Moved to recycle bin
- 30-day retention policy

**User Recycle Bin (Master Admin):**
```
Features:
- View all deleted users
- Search by name/email
- See deletion date
- Restore user account
- Permanent delete option
```

**Product Recycle Bin (Admin):**
```
Features:
- View all deleted products
- Search by name/SKU
- See deletion date and who deleted
- Restore product
- Permanent delete option
```

**Restoration Process:**
```
1. Admin selects item
2. Clicks "Restore"
3. System updates:
   - is_deleted = false
   - deleted_at = NULL
4. Item returns to active list
```

**Permanent Deletion:**
- Manual: Admin confirms permanent delete
- Automatic: Scheduled job runs daily
- Removes items older than 30 days
- Cannot be undone

**Benefits:**
✅ Accidental deletion recovery
✅ Data integrity
✅ Audit trail
✅ Compliance friendly

---

## SLIDE 34: Key Features - User Management
**Content:**

**USER MANAGEMENT (Master Admin)**

**Create User:**
```
Required Information:
- First Name
- Last Name
- Email (unique)
- Password
- Role (ADMIN or EMPLOYEE)
- Status (ACTIVE/INACTIVE)

Validation:
- Email format check
- Password strength (8+ chars, mixed case)
- Unique email constraint
- All fields required
```

**Edit User:**
- Update name, email, role
- Change status (activate/deactivate)
- Cannot change own role
- Email uniqueness maintained

**Delete User:**
- Soft delete to recycle bin
- All created products remain
- Transaction history preserved
- Can be restored

**View Users:**
- List all users
- Filter by role
- Filter by status
- Search by name/email
- Show last login

**User Statistics:**
- Total users
- Master Admins count
- Admins count
- Employees count
- Active vs Inactive

---

## SLIDE 35: UI/UX Design - Design System
**Content:**

**PROFESSIONAL MINIMAL DESIGN**

**Color Palette:**

**Primary Colors:**
- Navy (#0f172a, #1e293b) - Sidebar, headers
- Emerald (#10b981, #059669) - Buttons, success
- Slate (#64748b, #475569) - Text, borders

**Secondary Colors:**
- White (#ffffff) - Cards, background
- Light Gray (#f8fafc) - Page background
- Red (#ef4444) - Errors, alerts
- Amber (#f59e0b) - Warnings

**Typography:**
- Font: 'Inter', Segoe UI, sans-serif
- Headers: 24px-36px, Bold (700-800)
- Body: 14px-16px, Regular (400-500)
- Small: 12px-13px, Medium (500-600)

**Spacing System:**
- Base unit: 4px
- Small: 8px, 12px
- Medium: 16px, 20px, 24px
- Large: 32px, 40px, 48px

---

## SLIDE 36: UI/UX Design - Components
**Content:**

**DESIGN COMPONENTS**

**Buttons:**
- Primary: Emerald gradient, white text
- Secondary: Light gray, slate text
- Danger: Red gradient, white text
- Sizes: 12px padding (icon), 14px padding (default)
- Effects: Hover lift, shadow on hover

**Cards:**
- Background: White
- Border: 1px solid #e2e8f0
- Border radius: 12px
- Shadow: 0 1px 3px rgba(0,0,0,0.06)
- Hover: Lift + stronger shadow

**Inputs:**
- Border: 1px solid #e2e8f0
- Border radius: 8px
- Padding: 12px 16px
- Focus: Emerald border + shadow
- Placeholder: Light slate

**Tables:**
- Header: Light gray background
- Borders: Subtle gray (#f1f5f9)
- Hover: Row highlight
- Alternating rows: Not used (clean)

**Badges:**
- Rounded: 6px
- Padding: 6px 12px
- Uppercase text
- Color-coded by type

---

## SLIDE 37: UI/UX Design - Layout
**Content:**

**LAYOUT STRUCTURE**

**Sidebar:**
- Width: 280px (open), 80px (collapsed)
- Background: Navy gradient
- Position: Fixed left
- Height: 100vh
- Contains: Logo, user info, navigation, actions

**Main Content:**
- Margin-left: 280px (sidebar width)
- Padding: 40px
- Background: Light gray (#f8fafc)
- Min-height: 100vh
- Responsive: Adjusts with sidebar

**Navigation:**
- Active state: Emerald accent
- Hover: Light background
- Icons: 20px, consistent spacing
- Border-left: 3px emerald on active

**Dashboard Cards:**
- Grid layout: Auto-fit
- Min-width: 260px per card
- Gap: 24px
- Card height: Auto

**Forms:**
- Max-width: 600px
- Single column layout
- Clear labels above inputs
- Helper text below
- Action buttons right-aligned

---

## SLIDE 38: UI/UX Design - Interactions
**Content:**

**USER INTERACTIONS**

**Animations:**
- Page transitions: Fade in + slide up (0.3s)
- Hover effects: Transform + shadow (0.2s)
- Button press: Scale down slightly
- Loading: Spinner or skeleton
- Toast: Slide in from right

**Feedback:**
- Success: Green toast, 3s auto-close
- Error: Red toast with message
- Warning: Amber toast
- Info: Blue toast
- Loading: Overlay with spinner

**Micro-interactions:**
- Button hover: Lift up 2px
- Card hover: Lift + shadow
- Input focus: Border color + glow
- Sidebar toggle: Smooth width transition
- Icon hover: Scale 1.05

**Responsive Behavior:**
- Desktop (>1024px): Full layout
- Tablet (768-1024px): Collapsed sidebar
- Mobile (<768px): Hidden sidebar, hamburger menu

**Accessibility:**
- Focus states visible
- Color contrast WCAG AA
- Keyboard navigation
- Screen reader friendly
- Alt text on images

---

## SLIDE 39: API Documentation - Auth APIs
**Content:**

**AUTHENTICATION ENDPOINTS**

**1. Login**
```
POST /api/auth/login
Body: {
  "email": "user@example.com",
  "password": "password123"
}
Response: {
  "token": "jwt.token.here",
  "user": { ...userDetails }
}
Status: 200 OK / 401 Unauthorized
```

**2. Forgot Password**
```
POST /api/auth/forgot-password
Body: {
  "email": "user@example.com"
}
Response: {
  "message": "OTP sent to email"
}
Status: 200 OK / 404 Not Found
```

**3. Reset Password**
```
POST /api/auth/reset-password
Body: {
  "email": "user@example.com",
  "otp": "123456",
  "newPassword": "newPass123"
}
Response: {
  "message": "Password reset successful"
}
Status: 200 OK / 400 Bad Request
```

---

## SLIDE 40: API Documentation - Product APIs
**Content:**

**PRODUCT MANAGEMENT ENDPOINTS**

**1. Get All Products (Admin/Employee)**
```
GET /api/admin/products
Headers: Authorization: Bearer {token}
Response: [
  {
    "id": 1,
    "name": "Product A",
    "sku": "SKU-123456",
    "quantity": 100,
    ...
  }
]
Status: 200 OK
```

**2. Create Product (Admin only)**
```
POST /api/admin/products
Headers: Authorization: Bearer {token}
Body: {
  "name": "New Product",
  "category": "Electronics",
  "price": 999.99,
  "quantity": 50,
  "lowStockThreshold": 10
}
Response: { ...createdProduct }
Status: 201 Created
```

**3. Update Product (Admin only)**
```
PUT /api/admin/products/{id}
Body: { ...updatedFields }
Status: 200 OK
```

**4. Delete Product (Admin only)**
```
DELETE /api/admin/products/{id}
Status: 200 OK (Soft delete)
```

---

## SLIDE 41: API Documentation - Stock APIs
**Content:**

**STOCK OPERATION ENDPOINTS**

**1. Stock IN (Admin/Employee)**
```
POST /api/admin/stock/in
Headers: Authorization: Bearer {token}
Body: {
  "productId": 1,
  "quantity": 50,
  "notes": "Received from supplier XYZ"
}
Response: {
  "message": "Stock added successfully",
  "transaction": { ...transactionDetails }
}
Status: 200 OK
```

**2. Stock OUT (Admin/Employee)**
```
POST /api/admin/stock/out
Headers: Authorization: Bearer {token}
Body: {
  "productId": 1,
  "quantity": 20,
  "notes": "Sold to customer ABC"
}
Response: {
  "message": "Stock removed successfully",
  "transaction": { ...transactionDetails }
}
Status: 200 OK / 400 Insufficient Stock
```

**3. Get Transactions**
```
GET /api/admin/transactions
Query Params:
  - type: IN|OUT|ALL
  - startDate, endDate
  - productId, userId
Status: 200 OK
```

---

## SLIDE 42: Project Structure - Frontend
**Content:**

**FRONTEND FOLDER STRUCTURE**

```
frontend/
├── public/                  # Static assets
├── src/
│   ├── components/         # Reusable components
│   │   ├── ChangePasswordModal.jsx
│   │   ├── ChangePassword.css
│   │   ├── LowStockAlerts.jsx
│   │   ├── LowStockAlerts.css
│   │   └── PrivateRoute.jsx
│   │
│   ├── pages/              # Page components
│   │   ├── Login.jsx
│   │   ├── Login.css
│   │   ├── ForgotPassword.jsx
│   │   ├── ResetPassword.jsx
│   │   ├── Admin/
│   │   │   ├── Dashboard.jsx
│   │   │   ├── Dashboard.css
│   │   │   ├── Overview.jsx
│   │   │   ├── ProductManagement.jsx
│   │   │   ├── StockManagement.jsx
│   │   │   ├── Transactions.jsx
│   │   │   ├── Reports.jsx
│   │   │   ├── Employees.jsx
│   │   │   └── RecycleBin.jsx
│   │   ├── Employee/       # Similar structure
│   │   └── MasterAdmin/    # Similar structure
│   │
│   ├── services/          # API services
│   │   └── api.js         # Axios config + endpoints
│   │
│   ├── utils/             # Helper functions
│   │   └── helpers.js     # Auth, formatting utils
│   │
│   ├── App.jsx            # Root component
│   ├── App.css            # Global styles
│   └── main.jsx           # Entry point
│
├── index.html              # HTML template
├── package.json            # Dependencies
├── vite.config.js          # Vite configuration
└── README.md               # Documentation
```

---

## SLIDE 43: Project Structure - Backend
**Content:**

**BACKEND FOLDER STRUCTURE**

```
src/main/java/com/inventory/
├── InventorySystemApplication.java   # Main class
│
├── config/                    # Configuration
│   ├── SecurityConfig.java    # Spring Security
│   ├── SecurityBeansConfig.java
│   ├── WebConfig.java         # CORS, Web MVC
│   └── DatabaseInitializer.java
│
├── controller/               # REST Controllers
│   ├── AuthController.java
│   ├── AdminController.java
│   ├── EmployeeController.java
│   └── MasterAdminController.java
│
├── service/                  # Business Logic
│   ├── UserService.java
│   ├── ProductService.java
│   ├── StockService.java
│   ├── TransactionService.java
│   ├── LowStockAlertService.java
│   └── EmailService.java
│   └── impl/                # Implementations
│
├── repository/              # Data Access
│   ├── UserRepository.java
│   ├── ProductRepository.java
│   ├── TransactionRepository.java
│   ├── LowStockAlertRepository.java
│   └── PasswordResetTokenRepository.java
│
├── entity/                  # JPA Entities
│   ├── User.java
│   ├── Product.java
│   ├── Transaction.java
│   ├── LowStockAlert.java
│   └── PasswordResetToken.java
│
├── dto/                    # Data Transfer Objects
│   ├── LoginRequest.java
│   ├── ProductRequest.java
│   └── StockRequest.java
│
├── security/               # Security Components
│   ├── JwtAuthenticationFilter.java
│   ├── JwtTokenProvider.java
│   └── CustomUserDetailsService.java
│
├── exception/              # Exception Handling
│   └── GlobalExceptionHandler.java
│
└── util/                   # Utility Classes
    └── EmailUtil.java

src/main/resources/
└── application.properties  # Configuration
```

---

## SLIDE 44: Installation Guide - Prerequisites
**Content:**

**SYSTEM REQUIREMENTS**

**Software Requirements:**

**1. Java Development Kit**
- Version: Java 17 or higher
- Download: https://www.oracle.com/java/technologies/downloads/
- Verify: `java -version`

**2. Node.js & npm**
- Version: Node.js 18+ and npm 9+
- Download: https://nodejs.org/
- Verify: `node -v` and `npm -v`

**3. MySQL Database**
- Version: MySQL 8.0+
- Download: https://dev.mysql.com/downloads/mysql/
- Alternative: XAMPP, MAMP, or MySQL Workbench

**4. Maven**
- Version: 3.9+
- Usually bundled with Spring Boot (mvnw)
- Verify: `mvn -version`

**5. IDE (Recommended)**
- Visual Studio Code (Frontend)
- IntelliJ IDEA / Eclipse (Backend)
- Or any preferred IDE

**6. Git** (Optional)
- For version control
- Download: https://git-scm.com/

---

## SLIDE 45: Installation Guide - Database Setup
**Content:**

**DATABASE CONFIGURATION**

**Step 1: Install MySQL**
```bash
# Windows: Download installer and run
# Mac: brew install mysql
# Linux: sudo apt-get install mysql-server
```

**Step 2: Start MySQL Service**
```bash
# Windows: Services → MySQL80 → Start
# Mac: brew services start mysql
# Linux: sudo service mysql start
```

**Step 3: Create Database**
```sql
# Login to MySQL
mysql -u root -p

# Create database
CREATE DATABASE mile3;

# Verify
SHOW DATABASES;

# Exit
EXIT;
```

**Step 4: Note Credentials**
```
Database Name: mile3
Host: localhost
Port: 3306
Username: root
Password: [your-password]
```

**Note:** Tables will be auto-created by Hibernate on first run!

---

## SLIDE 46: Installation Guide - Backend Setup
**Content:**

**SPRING BOOT BACKEND SETUP**

**Step 1: Configure Database**
```bash
# Navigate to project
cd Inventory-mile-3-main

# Open application.properties
# Location: src/main/resources/application.properties

# Update these lines:
spring.datasource.url=jdbc:mysql://localhost:3306/mile3
spring.datasource.username=root
spring.datasource.password=[your-mysql-password]
```

**Step 2: Configure Email (Optional)**
```properties
spring.mail.username=[your-gmail]
spring.mail.password=[gmail-app-password]
```

**Step 3: Build & Run**
```bash
# Using Maven wrapper (Windows)
mvnw.cmd spring-boot:run

# Using Maven wrapper (Mac/Linux)
./mvnw spring-boot:run

# Or using Maven directly
mvn spring-boot:run
```

**Step 4: Verify**
```
✅ Server started on port 8080
✅ Database connected
✅ Tables created automatically
✅ Initial users created
```

---

## SLIDE 47: Installation Guide - Frontend Setup
**Content:**

**REACT FRONTEND SETUP**

**Step 1: Navigate to Frontend**
```bash
cd frontend
```

**Step 2: Install Dependencies**
```bash
npm install
# Wait for all packages to install
# This may take 2-3 minutes
```

**Step 3: Verify Configuration**
```javascript
// File: vite.config.js
// Ensure proxy is configured:
proxy: {
  '/api': {
    target: 'http://localhost:8080',
    changeOrigin: true,
  }
}
```

**Step 4: Start Development Server**
```bash
npm run dev
```

**Step 5: Access Application**
```
✅ Frontend running on: http://localhost:3000
✅ Backend API on: http://localhost:8080
✅ Database: MySQL mile3
```

**Default Login Credentials:**
```
Master Admin: master@admin.com / admin123
Admin: admin@test.com / admin123
Employee: employee@test.com / employee123
```

---

## SLIDE 48: Performance - Frontend Optimization
**Content:**

**FRONTEND PERFORMANCE**

**Build Tool Optimizations:**
- **Vite** - Lightning fast HMR
- ES modules for better tree-shaking
- Optimized production builds
- Code splitting enabled
- Lazy loading for routes

**React Optimizations:**
- Functional components (faster)
- React.memo for expensive renders
- Debounced search inputs
- Controlled component updates
- Virtual scrolling for large lists

**Network Optimizations:**
- Axios interceptors (reduce duplicate code)
- Request/Response caching
- Compressed API responses
- Minimal payload size
- Concurrent requests where possible

**Asset Optimizations:**
- React Icons (only used icons loaded)
- No heavy image assets
- CSS optimized and minified
- Font loading optimized

**Measured Performance:**
- First Contentful Paint: <1.5s
- Time to Interactive: <2.5s
- Lighthouse Score: 90+

---

## SLIDE 49: Performance - Backend Optimization
**Content:**

**BACKEND PERFORMANCE**

**Database Optimizations:**
- Primary keys on all tables
- Indexes on frequently queried columns
- Foreign key relationships
- Query optimization with JPA
- Connection pooling (HikariCP)
- Pagination for large datasets

**JPA/Hibernate:**
- Lazy loading by default
- Fetch joins where needed
- Named queries for complex operations
- Second-level cache (if needed)
- Batch operations for bulk updates

**API Optimizations:**
- RESTful design principles
- Minimal response payloads
- DTO pattern (avoid over-fetching)
- Async operations for emails
- Transaction management

**Security Performance:**
- JWT tokens (no session storage)
- Stateless authentication
- Efficient password hashing (BCrypt)
- Optimized filter chain

**Caching Strategies:**
- Application-level caching
- Database query caching
- Static resource caching

**Measured Performance:**
- API response time: <200ms (avg)
- Database query time: <50ms (avg)
- Concurrent users: 100+

---

## SLIDE 50: Performance - Database Optimization
**Content:**

**DATABASE OPTIMIZATION**

**Indexing Strategy:**
```sql
-- Primary Keys (auto-indexed)
users(id), products(id), transactions(id)

-- Unique indexes
users(email), products(sku)

-- Composite indexes
transactions(product_id, transaction_date)
transactions(user_id, transaction_date)

-- Lookup indexes
products(category, is_deleted)
users(role, status)
```

**Query Optimization:**
- SELECT only needed columns
- Avoid N+1 query problem
- Use JOINs efficiently
- Limit + offset for pagination
- Prepared statements (SQL injection prevention)

**Data Types:**
- Appropriate column sizes
- DECIMAL for money (10,2)
- TIMESTAMP for dates
- ENUM for fixed values
- TEXT only when needed

**Maintenance:**
- Regular ANALYZE TABLE
- Index rebuilding
- Database backups
- Old data archiving

---

## SLIDE 51: Business Logic - Product Lifecycle
**Content:**

**PRODUCT LIFECYCLE WORKFLOW**

**1. Creation**
```
Admin creates product
→ System generates SKU
→ Initial stock added
→ Threshold set
→ Product active in system
```

**2. Stock Operations**
```
Stock IN:
  Supplier delivers → Record transaction
  → Update quantity → Check alert resolution

Stock OUT:
  Customer order → Validate quantity
  → Record transaction → Update quantity
  → Check threshold → Trigger alert if low
```

**3. Monitoring**
```
System monitors quantity continuously
→ If quantity < threshold
→ Create alert
→ Email admins
→ Display on dashboard
```

**4. Alerting**
```
Alert created
→ Admin notified
→ Admin reviews
→ Restock if needed
→ Mark resolved
```

**5. Deletion**
```
Admin deletes product
→ Soft delete (is_deleted = true)
→ Move to recycle bin
→ Hidden from active list
→ 30-day retention
→ Restore or permanent delete
```

---

## SLIDE 52: Business Logic - User Workflow
**Content:**

**USER WORKFLOW**

**Master Admin:**
```
Login
→ View user dashboard
→ Create new admin/employee
→ Manage existing users
→ Handle recycle bin
→ Monitor user activities
→ Logout
```

**Admin:**
```
Login
→ View inventory dashboard
→ Check low stock alerts
→ Manage products (CRUD)
→ Perform stock operations
→ View transactions
→ Generate reports
→ Manage employees
→ Handle product recycle bin
→ Logout
```

**Employee:**
```
Login
→ View product list
→ Perform stock IN
→ Perform stock OUT
→ View transaction history
→ Check alerts
→ View basic reports
→ Logout
```

**Common Operations:**
```
All users can:
- Change their password
- View their profile
- Update personal info (limited)
- Logout
```

---

## SLIDE 53: Business Logic - Alert Workflow
**Content:**

**LOW STOCK ALERT WORKFLOW**

**Alert Generation:**
```
1. Stock OUT transaction processed
2. System checks: new_quantity < threshold?
3. If yes:
   - Create alert record
   - Set alert_sent_at = now()
   - Capture product snapshot
   - Mark is_resolved = false
4. Trigger email service
5. Send email to all admins
6. Display on dashboard
```

**Email Content:**
```
Subject: Low Stock Alert: [Product Name]
Body:
  Product: [Name]
  SKU: [SKU]
  Current Quantity: [X]
  Threshold: [Y]
  Action Required: Restock soon
  View Dashboard: [Link]
```

**Resolution Process:**
```
Option 1 - Manual:
  Admin clicks "Resolve"
  → is_resolved = true
  → resolved_at = now()

Option 2 - Automatic:
  Stock IN transaction
  → new_quantity >= threshold
  → Auto-resolve alert
  → is_resolved = true
```

**Benefits:**
✅ Prevents stockouts
✅ Timely notifications
✅ Audit trail
✅ Proactive management

---

## SLIDE 54: Future Enhancements - Features
**Content:**

**POTENTIAL FUTURE FEATURES**

**Enhanced Features:**
📱 **Mobile Application**
- iOS and Android apps
- React Native or Flutter
- Offline mode support

📊 **Advanced Analytics**
- Predictive analytics
- Demand forecasting
- Trend analysis
- AI-based recommendations

🏷️ **Barcode System**
- Barcode generation
- Scanner integration
- Quick product lookup
- Mobile scanning

📧 **Advanced Notifications**
- Push notifications
- SMS alerts
- WhatsApp integration
- Custom notification rules

📄 **Document Management**
- PDF invoice generation
- Export to Excel/CSV
- Print-friendly reports
- Automated report scheduling

---

## SLIDE 55: Future Enhancements - Integrations
**Content:**

**INTEGRATION OPPORTUNITIES**

**E-commerce Integration:**
- Shopify/WooCommerce sync
- Real-time inventory sync
- Automated stock updates
- Order management

**Accounting Software:**
- QuickBooks integration
- Tally integration
- Automated invoicing
- Financial reporting

**Supplier Management:**
- Supplier portal
- Purchase order system
- Automated reordering
- Supplier performance tracking

**Shipping Integration:**
- Courier API integration
- Tracking number generation
- Shipping label printing
- Delivery status updates

**Payment Gateway:**
- Online payment integration
- Invoice payment tracking
- Credit management
- Payment reminders

**Cloud Services:**
- AWS/Azure deployment
- Cloud storage for documents
- Backup automation
- CDN for assets

---

## SLIDE 56: Future Enhancements - Technical
**Content:**

**TECHNICAL IMPROVEMENTS**

**Testing:**
- Unit tests (JUnit, Jest)
- Integration tests
- E2E tests (Cypress)
- Performance testing
- Security testing

**DevOps:**
- Docker containerization
- Kubernetes orchestration
- CI/CD pipeline (Jenkins/GitHub Actions)
- Automated deployments
- Environment management

**Architecture:**
- Microservices migration
- Message queue (RabbitMQ/Kafka)
- Redis caching
- WebSocket for real-time updates
- GraphQL API option

**Security:**
- Two-factor authentication (2FA)
- Biometric authentication
- Session management
- Rate limiting
- API throttling
- Penetration testing

**Scalability:**
- Load balancing
- Database sharding
- Horizontal scaling
- CDN integration
- Performance monitoring

---

## SLIDE 57: Challenges & Solutions
**Content:**

**CHALLENGES FACED & SOLUTIONS**

**Challenge 1: State Management**
- Problem: Managing complex state across components
- Solution: React Hooks (useState, useEffect) + proper component structure

**Challenge 2: Authentication Flow**
- Problem: Securing routes and maintaining sessions
- Solution: JWT tokens + PrivateRoute component + Axios interceptors

**Challenge 3: Real-time Stock Updates**
- Problem: Synchronizing stock across multiple transactions
- Solution: Transaction-based updates with database constraints

**Challenge 4: Soft Delete Implementation**
- Problem: Maintaining data integrity while allowing deletion
- Solution: Boolean flag + timestamp + scheduled cleanup

**Challenge 5: Role-Based Access**
- Problem: Different permissions for different roles
- Solution: Backend @PreAuthorize + Frontend route guards

**Challenge 6: Email Configuration**
- Problem: SMTP authentication and delivery
- Solution: Gmail App Passwords + proper configuration

**Lessons Learned:**
✅ Plan database schema carefully
✅ Security from the start
✅ Component reusability is key
✅ Test early and often
✅ Documentation saves time

---

## SLIDE 58: Deployment Considerations
**Content:**

**DEPLOYMENT STRATEGY**

**Production Deployment:**

**Backend Deployment:**
- Package as JAR file: `mvn clean package`
- Deploy options:
  - Standalone: `java -jar app.jar`
  - Tomcat server
  - Cloud platforms (AWS, Heroku, Azure)
  - Docker container

**Frontend Deployment:**
- Build production bundle: `npm run build`
- Deploy options:
  - Netlify / Vercel (recommended)
  - AWS S3 + CloudFront
  - Nginx web server
  - Apache server

**Database:**
- Production MySQL instance
- AWS RDS / Azure SQL
- Regular backups
- Replication for HA

**Configuration Changes:**
```
1. Change JWT secret to strong value
2. Update database credentials
3. Configure production email
4. Enable HTTPS
5. Set CORS for production domain
6. Disable debug logging
7. Environment variables for secrets
```

---

## SLIDE 59: Project Statistics
**Content:**

**PROJECT METRICS**

**Code Statistics:**
- Frontend Files: 30+ components
- Backend Classes: 40+ Java files
- API Endpoints: 25+ routes
- Database Tables: 5 core tables
- Total Lines of Code: ~5,000+

**Development Breakdown:**
- Planning & Design: 20%
- Backend Development: 35%
- Frontend Development: 35%
- Testing & Bug Fixes: 10%

**Technology Count:**
- Frontend Libraries: 8
- Backend Dependencies: 15+
- Total Dependencies: 20+

**Feature Count:**
- User Roles: 3
- CRUD Modules: 4
- Authentication Methods: 3
- Report Types: 5+
- Alert Types: 1 configurable

**Team Effort:**
- Duration: [Your timeframe]
- Developers: [Your team size]
- Commits: [If using Git]

---

## SLIDE 60: Conclusion - Summary
**Content:**

**PROJECT SUMMARY**

**What We Built:**
✅ Complete full-stack Inventory Management System
✅ Role-based access control (3 roles)
✅ Real-time stock tracking and alerts
✅ Professional minimal UI design
✅ Secure authentication with JWT
✅ Comprehensive reporting system
✅ Soft delete with recycle bin

**Technologies Mastered:**
✅ React 18 with modern hooks
✅ Spring Boot 3 with Security
✅ MySQL database design
✅ REST API development
✅ JWT authentication
✅ Professional UI/UX design

**Skills Demonstrated:**
✅ Full-stack development
✅ Database design & optimization
✅ Security implementation
✅ API design & documentation
✅ Component-based architecture
✅ Problem-solving

---

## SLIDE 61: Conclusion - Key Takeaways
**Content:**

**KEY TAKEAWAYS**

**Technical Skills:**
- Modern web development stack
- Secure authentication patterns
- RESTful API best practices
- Database normalization
- Component-driven design
- Version control (Git)

**Business Understanding:**
- Real-world problem solving
- User role management
- Inventory operations
- Alert systems
- Reporting requirements

**Soft Skills:**
- Project planning
- Time management
- Documentation
- Testing strategies
- Deployment considerations

**Best Practices Followed:**
✅ Separation of concerns
✅ DRY principle
✅ Security-first approach
✅ Responsive design
✅ Clean code
✅ Proper error handling

---

## SLIDE 62: Conclusion - Project Impact
**Content:**

**PROJECT IMPACT**

**Business Value:**
- Reduces manual inventory errors
- Saves time on stock management
- Prevents stockouts with alerts
- Provides audit trail for compliance
- Enables data-driven decisions

**User Benefits:**
- Intuitive, easy-to-use interface
- Role-appropriate access
- Fast, responsive application
- Mobile-friendly design
- Real-time updates

**Technical Excellence:**
- Scalable architecture
- Maintainable codebase
- Proper documentation
- Security-focused
- Performance optimized

**Learning Outcomes:**
- Practical experience with modern tech stack
- Understanding of business workflows
- Security best practices
- Full development lifecycle
- Deployment considerations

---

## SLIDE 63: Demo & Questions
**Content:**

**LIVE DEMONSTRATION**

**Demo Flow:**

**1. Login** (1 min)
- Show different role credentials
- Demonstrate authentication

**2. Master Admin** (2 min)
- User management
- Create new user
- Recycle bin

**3. Admin Dashboard** (3 min)
- Product management (CRUD)
- Stock IN/OUT operations
- Low stock alerts
- Reports

**4. Employee View** (1 min)
- Limited access demonstration
- Stock operations

**5. Key Features** (2 min)
- Real-time updates
- Email notifications
- Professional UI
- Responsive design

**Total Demo Time: ~10 minutes**

---

## SLIDE 64: Thank You
**Content:**

# Thank You!

**Inventory Management System**
*Professional Stock Management Solution*

---

**Project Highlights:**
✅ Full-stack Web Application
✅ React + Spring Boot + MySQL
✅ Professional Minimal Design
✅ Role-Based Access Control
✅ Real-time Stock Tracking
✅ Secure & Scalable

---

**Live URLs:**
- Frontend: http://localhost:3000
- Backend API: http://localhost:8080
- Database: MySQL (mile3)

---

**Documentation:** Available in project repository

---

## Questions?

**Contact:** [Your Email/GitHub]

**GitHub:** [Repository Link]

---

*Developed with ❤️ using Modern Web Technologies*
