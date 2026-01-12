# Smart Inventory Management System

A comprehensive inventory management system built with Spring Boot for small businesses to track inventory, manage restocking, handle sales reporting, and generate transaction reports.

## 🎯 Project Overview

This system enables business owners and staff to:
- Manage inventory levels with real-time tracking
- Receive low-stock alerts and notifications
- Handle sales reporting efficiently
- Generate transaction reports in PDF/CSV formats
- Role-based access control for admins and employees

## 📋 Features Implemented

### ✅ Milestone 1: Authentication and Role Management (Weeks 1-2)
- JWT-based authentication for secure login
- User registration with role assignment (ADMIN/EMPLOYEE)
- Role-based access control
- Secure password encryption using BCrypt

### ✅ Milestone 2: Product Management (Weeks 3-4)
- Complete CRUD operations for products
- Product fields: SKU, name, category, supplier, unit price, quantity
- Stock level tracking and updates
- Product search functionality
- Unique SKU validation

### ✅ Milestone 3: Low-Stock Alerts (Week 5)
- Customizable minimum stock thresholds per product
- Automatic alert generation when stock falls below threshold
- Alert types: LOW_STOCK, OUT_OF_STOCK, REORDER_NEEDED
- Visual alerts on dashboard
- Alert resolution tracking

### ✅ Milestone 4: Transaction History (Weeks 6-7)
- Transaction logging for purchases, sales, and adjustments
- Automatic stock updates based on transactions
- Transaction history with filtering
- Full audit trail with user tracking
- Transaction details: product, quantity, type, price, timestamp

### ✅ Milestone 5: Reports and Export Tools (Week 8)
- Inventory summary reports with current stock status
- Transaction history reports with date range filtering
- Low-stock reports
- Export to PDF format
- Export to CSV format
- Detailed report filtering options

## 🛠️ Technology Stack

- **Backend Framework**: Spring Boot 3.2.1
- **Java Version**: 21
- **Database**: MySQL (with H2 for testing)
- **Security**: Spring Security + JWT
- **ORM**: Spring Data JPA / Hibernate
- **PDF Generation**: iText PDF
- **CSV Export**: OpenCSV
- **Build Tool**: Maven
- **Additional**: Lombok for boilerplate reduction

## 📁 Project Structure

```
src/main/java/com/inventory/
├── config/
│   └── DataInitializer.java          # Sample data initialization
├── controller/
│   ├── AuthController.java           # Authentication endpoints
│   ├── ProductController.java        # Product management
│   ├── TransactionController.java    # Transaction operations
│   ├── AlertController.java          # Alert management
│   └── ReportController.java         # Report generation
├── dto/
│   ├── LoginRequest.java
│   ├── RegisterRequest.java
│   ├── AuthResponse.java
│   ├── ProductRequest.java
│   └── TransactionRequest.java
├── entity/
│   ├── User.java                     # User entity
│   ├── Product.java                  # Product entity
│   ├── Transaction.java              # Transaction entity
│   └── Alert.java                    # Alert entity
├── repository/
│   ├── UserRepository.java
│   ├── ProductRepository.java
│   ├── TransactionRepository.java
│   └── AlertRepository.java
├── security/
│   ├── JwtUtil.java                  # JWT token utility
│   ├── JwtAuthenticationFilter.java  # JWT filter
│   └── SecurityConfig.java           # Security configuration
├── service/
│   ├── AuthService.java              # Authentication logic
│   ├── ProductService.java           # Product business logic
│   ├── TransactionService.java       # Transaction logic
│   ├── AlertService.java             # Alert management
│   ├── ReportService.java            # Report generation
│   └── CustomUserDetailsService.java # User details for auth
└── InventoryManagementApplication.java
```

## 🚀 Getting Started

### Prerequisites

1. **Java 21** - Already installed ✓
2. **Maven** - Already installed ✓
3. **MySQL** - Install and configure

### Database Setup

1. Install MySQL if not already installed
2. Create a database:
```sql
CREATE DATABASE inventory_db;
```

3. Update `src/main/resources/application.properties` with your MySQL credentials:
```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

### Running the Application

1. Navigate to the project directory:
```bash
cd "c:\Users\yalam\OneDrive\Desktop\infosysspring"
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 👥 Default Users

The system creates two default users on first startup:

**Admin User:**
- Username: `admin`
- Password: `admin123`
- Role: ADMIN
- Full access to all features

**Employee User:**
- Username: `employee`
- Password: `employee123`
- Role: EMPLOYEE
- Limited access (view and basic operations)

## 📡 API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - Login and get JWT token
- `GET /api/auth/test` - Test endpoint

### Products
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/sku/{sku}` - Get product by SKU
- `GET /api/products/search?name={name}` - Search products
- `GET /api/products/low-stock` - Get low-stock products
- `GET /api/products/out-of-stock` - Get out-of-stock products
- `POST /api/products` - Create product (ADMIN only)
- `PUT /api/products/{id}` - Update product (ADMIN only)
- `DELETE /api/products/{id}` - Delete product (ADMIN only)
- `PATCH /api/products/{id}/stock?quantity={qty}` - Update stock (ADMIN only)

### Transactions
- `GET /api/transactions` - Get all transactions
- `GET /api/transactions/{id}` - Get transaction by ID
- `GET /api/transactions/product/{productId}` - Get transactions by product
- `GET /api/transactions/history` - Get transaction history with filters
- `POST /api/transactions` - Create transaction

### Alerts
- `GET /api/alerts` - Get all alerts
- `GET /api/alerts/active` - Get active alerts
- `GET /api/alerts/product/{productId}` - Get alerts by product
- `PUT /api/alerts/{id}/resolve` - Resolve an alert

### Reports
- `GET /api/reports/inventory/pdf` - Download inventory report (PDF) - ADMIN
- `GET /api/reports/inventory/csv` - Download inventory report (CSV)
- `GET /api/reports/transactions/pdf?startDate={date}&endDate={date}` - Transaction report (PDF) - ADMIN
- `GET /api/reports/low-stock/csv` - Low-stock report (CSV)

## 🔐 Authentication

All protected endpoints require JWT token in the Authorization header:

```
Authorization: Bearer <your_jwt_token>
```

### Example API Usage

**1. Login:**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin123"}'
```

**2. Create Product:**
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "New Product",
    "sku": "SKU-12345",
    "supplier": "Supplier Name",
    "quantity": 100,
    "minThreshold": 20,
    "price": 29.99,
    "category": "Electronics",
    "unit": "pieces"
  }'
```

**3. Create Transaction:**
```bash
curl -X POST http://localhost:8080/api/transactions \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "productId": 1,
    "type": "SALE",
    "quantity": 5,
    "notes": "Customer purchase"
  }'
```

## 📊 Database Schema

### Users Table
- id (Primary Key)
- username (Unique)
- password (Encrypted)
- email (Unique)
- role (ADMIN/EMPLOYEE)
- created_at

### Products Table
- id (Primary Key)
- name
- sku (Unique)
- supplier
- quantity
- min_threshold
- price
- category
- unit
- created_at
- updated_at

### Transactions Table
- id (Primary Key)
- product_id (Foreign Key)
- user_id (Foreign Key)
- type (PURCHASE/SALE/ADJUSTMENT)
- quantity
- price
- notes
- timestamp

### Alerts Table
- id (Primary Key)
- product_id (Foreign Key)
- triggered (Boolean)
- alert_type (LOW_STOCK/OUT_OF_STOCK/REORDER_NEEDED)
- message
- timestamp
- resolved_at

## 🎨 Architecture

The application follows a layered architecture:

1. **Controller Layer**: REST endpoints and request handling
2. **Service Layer**: Business logic and transaction management
3. **Repository Layer**: Database operations using Spring Data JPA
4. **Entity Layer**: JPA entities mapping to database tables
5. **Security Layer**: JWT authentication and authorization
6. **DTO Layer**: Data transfer objects for API requests/responses

## 🔧 Configuration

Key configuration in `application.properties`:

```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=root
spring.datasource.password=root

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Configuration
jwt.secret=your-secret-key
jwt.expiration=86400000 (24 hours)
```

## 📝 Testing

You can test the application using:
1. **Postman** - Import the API collection
2. **cURL** - Use command-line examples above
3. **Swagger UI** - (Can be added as enhancement)

## 🐛 Troubleshooting

**Issue: Cannot connect to MySQL**
- Ensure MySQL is running
- Check credentials in application.properties
- Verify database exists

**Issue: JWT token expired**
- Login again to get a new token
- Token expires after 24 hours by default

**Issue: Port 8080 already in use**
- Change port in application.properties: `server.port=8081`

## 📚 Future Enhancements

- Frontend UI (React/Angular)
- Email notifications for low-stock alerts
- SMS integration
- Barcode scanning support
- Multi-warehouse support
- Advanced analytics dashboard
- Supplier management module
- Purchase order generation

## 👨‍💻 Development Notes

- All passwords are encrypted using BCrypt
- JWT tokens are stateless and contain user information
- Database schema is auto-created by Hibernate
- Sample data is loaded on first startup
- Transaction support ensures data consistency
- Scheduled tasks check for low-stock items

## 📄 License

This project is created for educational purposes as part of the Infosys Spring training program.

## 🤝 Support

For issues or questions, please contact the development team or create an issue in the repository.

---

**Project Completed Successfully! ✨**

All 5 milestones have been implemented:
- ✅ Milestone 1: Authentication & Role Management
- ✅ Milestone 2: Product Management
- ✅ Milestone 3: Low-Stock Alerts
- ✅ Milestone 4: Transaction History
- ✅ Milestone 5: Reports & Export Tools
"# Inventorymanagement" 
