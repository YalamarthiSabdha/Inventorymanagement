# Inventory Management System
## Professional Web Application

---

## 📋 Project Overview

**Project Name:** Inventory Management System (IMS)  
**Type:** Full-Stack Web Application  
**Architecture:** Client-Server (React + Spring Boot)  
**Database:** MySQL 8.0  
**Design:** Professional Minimal Design (Navy, Slate, Emerald)

### Key Highlights
- ✅ Role-Based Access Control (3 Roles)
- ✅ Real-time Stock Management
- ✅ Low Stock Alert System
- ✅ Comprehensive Reporting
- ✅ Soft Delete with Recycle Bin
- ✅ Secure Authentication (JWT)
- ✅ Professional UI/UX

---

## 🎯 Project Objectives

1. **Streamline Inventory Operations**
   - Efficient product tracking
   - Real-time stock updates
   - Automated alerts

2. **Role-Based Management**
   - Master Admin: User management
   - Admin: Full inventory control
   - Employee: Stock operations

3. **Data Security & Integrity**
   - JWT-based authentication
   - Password reset via OTP
   - Secure API endpoints

4. **Professional User Experience**
   - Modern, clean interface
   - Responsive design
   - Intuitive navigation

---

## 👥 User Roles & Permissions

### 🔴 Master Admin
- User management (Create, Update, Delete)
- View all users
- User recycle bin management
- System-wide oversight

### 🔵 Admin
- Product management (CRUD)
- Stock IN/OUT operations
- Employee management
- Transaction history
- Reports & analytics
- Product recycle bin
- Low stock alerts

### 🟢 Employee
- View products
- Stock IN/OUT operations
- View transaction history
- Basic reports
- Low stock alerts

---

## 🛠️ Technology Stack

### **Frontend Technologies**

| Technology | Version | Purpose |
|------------|---------|---------|
| **React** | 18.2.0 | UI Framework |
| **Vite** | 5.0.8 | Build Tool & Dev Server |
| **React Router** | 6.20.0 | Client-side Routing |
| **Axios** | 1.6.2 | HTTP Client |
| **React Icons** | 4.12.0 | Icon Library |
| **React Toastify** | 9.1.3 | Notifications |
| **Recharts** | 2.10.3 | Data Visualization |
| **date-fns** | 3.0.6 | Date Utilities |

**Styling:** Custom CSS with Professional Design System  
**State Management:** React Hooks (useState, useEffect)

---

## 🛠️ Technology Stack (Backend)

### **Backend Technologies**

| Technology | Version | Purpose |
|------------|---------|---------|
| **Spring Boot** | 3.5.10 | Application Framework |
| **Spring Security** | 6.x | Authentication & Authorization |
| **Spring Data JPA** | 3.x | Data Access Layer |
| **MySQL** | 8.0.45 | Relational Database |
| **JWT** | 0.12.3 | Token-based Auth |
| **JavaMailSender** | - | Email Service |
| **Hibernate** | 6.6.41 | ORM Framework |
| **Maven** | 3.9.6 | Build Tool |

**Java Version:** 25  
**Server:** Apache Tomcat 10.1.50  
**Port:** 8080

---

## 🏗️ System Architecture

```
┌─────────────────────────────────────────────────────────┐
│                     CLIENT TIER                          │
│  ┌──────────────────────────────────────────────────┐  │
│  │   React Application (Port 3000)                   │  │
│  │   - Vite Dev Server                               │  │
│  │   - React Router                                  │  │
│  │   - Component-based UI                            │  │
│  └──────────────────────────────────────────────────┘  │
└───────────────────┬─────────────────────────────────────┘
                    │ HTTP/REST API
                    │ (Axios)
┌───────────────────▼─────────────────────────────────────┐
│                   APPLICATION TIER                       │
│  ┌──────────────────────────────────────────────────┐  │
│  │   Spring Boot Application (Port 8080)            │  │
│  │   ┌────────────────────────────────────────┐    │  │
│  │   │  Controllers (REST Endpoints)          │    │  │
│  │   │  - AuthController                      │    │  │
│  │   │  - AdminController                     │    │  │
│  │   │  - EmployeeController                  │    │  │
│  │   └────────────────────────────────────────┘    │  │
│  │   ┌────────────────────────────────────────┐    │  │
│  │   │  Security Layer (JWT Filter)           │    │  │
│  │   └────────────────────────────────────────┘    │  │
│  │   ┌────────────────────────────────────────┐    │  │
│  │   │  Services (Business Logic)             │    │  │
│  │   └────────────────────────────────────────┘    │  │
│  │   ┌────────────────────────────────────────┐    │  │
│  │   │  Repositories (Data Access)            │    │  │
│  │   └────────────────────────────────────────┘    │  │
│  └──────────────────────────────────────────────────┘  │
└───────────────────┬─────────────────────────────────────┘
                    │ JDBC
┌───────────────────▼─────────────────────────────────────┐
│                     DATA TIER                            │
│  ┌──────────────────────────────────────────────────┐  │
│  │   MySQL Database (Port 3306)                     │  │
│  │   - users, products, transactions                │  │
│  │   - low_stock_alerts, password_reset_tokens      │  │
│  └──────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────┘
```

---

## 💾 Database Schema

### **Core Tables**

#### **users**
- User credentials and profile
- Role-based access control
- Soft delete support
- Last login tracking

#### **products**
- Product information (name, SKU, category)
- Pricing and stock quantity
- Soft delete support
- Created/Updated timestamps

#### **transactions**
- Stock IN/OUT records
- Transaction type tracking
- User and product references
- Quantity and notes

#### **low_stock_alerts**
- Automated alert system
- Threshold monitoring
- Email recipient management
- Resolution tracking

#### **password_reset_tokens**
- OTP-based verification
- Token expiration
- Change/Reset password flow
- Security tracking

---

## 🔐 Security Implementation

### **Authentication Flow**
1. User submits credentials
2. Backend validates and generates JWT token
3. Token stored in LocalStorage
4. Token included in all API requests (Authorization header)
5. Backend validates token on each request

### **Security Features**
- ✅ Password encryption (BCrypt)
- ✅ JWT token-based authentication
- ✅ Role-based authorization
- ✅ OTP verification for password operations
- ✅ Token expiration handling
- ✅ CORS configuration
- ✅ Secure HTTP-only practices

### **Password Reset Flow**
1. User requests password reset
2. System generates 6-digit OTP
3. OTP sent via email
4. User verifies OTP
5. User sets new password
6. Token invalidated

---

## 📊 Key Features - Dashboard

### **Master Admin Dashboard**
- **User Management**
  - Create/Edit/Delete users
  - Assign roles (Admin, Employee)
  - User status management
  
- **User Recycle Bin**
  - View soft-deleted users
  - Restore or permanently delete
  - 30-day retention policy

- **System Overview**
  - Total users by role
  - Active/Inactive statistics

### **Admin Dashboard**
- **Product Management**
  - Add/Edit/Delete products
  - SKU auto-generation
  - Category management
  - Price tracking

- **Stock Management**
  - Stock IN operations
  - Stock OUT operations
  - Real-time quantity updates
  - Transaction logging

---

## 📊 Key Features - Operations

### **Inventory Features**
- **Low Stock Alerts**
  - Automatic threshold monitoring
  - Email notifications
  - Alert resolution tracking
  - Configurable thresholds

- **Transaction History**
  - Complete audit trail
  - Filter by type, date, user
  - Export capabilities
  - Detailed transaction records

- **Reports & Analytics**
  - Stock level reports
  - Transaction summaries
  - User activity reports
  - Visual charts (Recharts)

### **Recycle Bin System**
- Soft delete implementation
- 30-day retention period
- Restore functionality
- Permanent deletion option
- Separate bins for products/users

---

## 🎨 UI/UX Design

### **Design System - Professional Minimal**

**Color Palette:**
- **Navy** (#0f172a, #1e293b) - Primary, Sidebar
- **Slate** (#64748b, #475569) - Text, Secondary
- **Emerald** (#10b981, #059669) - Actions, Success
- **White/Gray** (#ffffff, #f8fafc) - Backgrounds

**Typography:**
- Font Family: 'Inter', Segoe UI, sans-serif
- Professional letter spacing
- Clear hierarchy

**Components:**
- Cards with subtle shadows
- Professional buttons with gradients
- Clean tables with hover effects
- Modern badges and status indicators
- Smooth animations and transitions

---

## 🎨 UI Components

### **Layout Components**
- **Sidebar Navigation**
  - Collapsible design
  - Active route highlighting
  - Role-specific menu items
  - User profile display

- **Dashboard Cards**
  - Stat cards with icons
  - Hover animations
  - Color-coded by type
  - Real-time data display

### **Form Components**
- Professional input fields
- Emerald focus states
- Error validation
- Loading states
- Search with autocomplete

### **Data Display**
- Responsive tables
- Sortable columns
- Action buttons
- Status badges
- Pagination support

---

## 🔄 API Endpoints

### **Authentication APIs**
```
POST /api/auth/login
POST /api/auth/forgot-password
POST /api/auth/reset-password
POST /api/auth/change-password/request
POST /api/auth/change-password/verify
```

### **Admin APIs**
```
GET    /api/admin/products
POST   /api/admin/products
PUT    /api/admin/products/{id}
DELETE /api/admin/products/{id}
POST   /api/admin/stock/in
POST   /api/admin/stock/out
GET    /api/admin/transactions
GET    /api/admin/inventory-summary
GET    /api/admin/low-stock-alerts
```

### **Master Admin APIs**
```
GET    /api/master-admin/users
POST   /api/master-admin/users
PUT    /api/master-admin/users/{id}
DELETE /api/master-admin/users/{id}
GET    /api/master-admin/recycle-bin
POST   /api/master-admin/restore/{id}
```

---

## 📦 Project Structure

### **Frontend Structure**
```
frontend/
├── src/
│   ├── components/
│   │   ├── ChangePasswordModal.jsx
│   │   ├── LowStockAlerts.jsx
│   │   └── PrivateRoute.jsx
│   ├── pages/
│   │   ├── Admin/
│   │   ├── Employee/
│   │   ├── MasterAdmin/
│   │   └── Login.jsx
│   ├── services/
│   │   └── api.js
│   ├── utils/
│   │   └── helpers.js
│   ├── App.jsx
│   └── main.jsx
├── package.json
└── vite.config.js
```

### **Backend Structure**
```
src/main/java/com/inventory/
├── config/
│   ├── SecurityConfig.java
│   ├── WebConfig.java
│   └── DatabaseInitializer.java
├── controller/
│   ├── AuthController.java
│   ├── AdminController.java
│   └── EmployeeController.java
├── service/
│   ├── UserService.java
│   ├── ProductService.java
│   └── StockService.java
├── repository/
├── entity/
├── dto/
└── security/
    └── JwtAuthenticationFilter.java
```

---

## 🚀 Installation & Setup

### **Prerequisites**
- Node.js 18+
- Java 25
- MySQL 8.0
- Maven 3.9+

### **Backend Setup**
```bash
# Navigate to project directory
cd Inventory-mile-3-main

# Update application.properties
- Database URL: jdbc:mysql://localhost:3306/mile3
- Username: root
- Password: [your-password]

# Run Spring Boot application
./mvnw spring-boot:run
```

### **Frontend Setup**
```bash
# Navigate to frontend directory
cd frontend

# Install dependencies
npm install

# Start development server
npm run dev
```

### **Database Setup**
```sql
CREATE DATABASE mile3;
-- Tables auto-created by Hibernate
```

---

## 🔧 Configuration

### **Application Properties**
```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/mile3
spring.datasource.username=root
spring.datasource.password=WJ28@krhps

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Configuration
app.jwt.secret=InventorySystemSecretKey
app.jwt.expiration=86400000

# Email Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=[email]
spring.mail.password=[app-password]
```

### **Vite Configuration**
```javascript
server: {
  port: 3000,
  proxy: {
    '/api': 'http://localhost:8080'
  }
}
```

---

## 📈 Performance Features

### **Frontend Optimization**
- ✅ Vite for fast builds
- ✅ Code splitting
- ✅ Lazy loading components
- ✅ Optimized bundle size
- ✅ Fast refresh (HMR)

### **Backend Optimization**
- ✅ JPA query optimization
- ✅ Connection pooling (HikariCP)
- ✅ Indexed database columns
- ✅ Efficient pagination
- ✅ Caching strategies

### **Database Optimization**
- ✅ Primary keys and indexes
- ✅ Foreign key constraints
- ✅ Optimized queries
- ✅ Transaction management

---

## 🧪 Testing Considerations

### **Potential Test Cases**

**Authentication:**
- Login with valid credentials
- Login with invalid credentials
- Password reset flow
- JWT token validation

**Product Management:**
- Create product with valid data
- Update product information
- Delete product (soft delete)
- Restore from recycle bin

**Stock Operations:**
- Stock IN operation
- Stock OUT operation
- Low stock alert triggering
- Transaction recording

**Authorization:**
- Role-based access control
- Unauthorized access attempts
- Token expiration handling

---

## 🔍 Key Functionalities Demo

### **1. Login & Authentication**
- Email/password authentication
- Role-based dashboard redirect
- JWT token management
- Remember session

### **2. Product Management**
- Add new products
- Edit existing products
- Delete products (recycle bin)
- View product list with search

### **3. Stock Operations**
- Record stock IN transactions
- Record stock OUT transactions
- Update quantities automatically
- View transaction history

### **4. Alert System**
- Automatic low stock detection
- Email notifications
- Alert dashboard display
- Mark alerts as resolved

---

## 📊 Business Logic

### **Stock Management Logic**
```
Stock IN:
- Select product
- Enter quantity
- Add notes
- Transaction recorded
- Quantity increased

Stock OUT:
- Select product
- Verify available quantity
- Enter quantity to remove
- Add notes
- Transaction recorded
- Quantity decreased
```

### **Alert Generation Logic**
```
If (product.quantity < threshold):
  - Create alert record
  - Send email notification
  - Display in dashboard
  - Track resolution status
```

### **Soft Delete Logic**
```
Delete Request:
- Set is_deleted = true
- Set deleted_at = current_timestamp
- Keep in database
- Hide from normal queries

After 30 Days:
- Scheduler checks deleted_at
- Permanently delete if expired
```

---

## 🎯 Achieved Goals

### **✅ Functionality**
- Complete CRUD operations
- Role-based access control
- Real-time stock tracking
- Automated alerting system
- Comprehensive reporting

### **✅ Security**
- Secure authentication
- Password encryption
- OTP verification
- Token-based sessions
- CORS protection

### **✅ User Experience**
- Professional design
- Intuitive navigation
- Responsive layout
- Toast notifications
- Loading states

### **✅ Code Quality**
- Component-based architecture
- Separation of concerns
- Reusable components
- Clean code principles
- Proper error handling

---

## 🚧 Future Enhancements

### **Potential Improvements**

**Features:**
- 📱 Mobile application
- 📊 Advanced analytics dashboard
- 📄 PDF report generation
- 🔔 Push notifications
- 📧 Bulk email operations
- 🏷️ Barcode scanning
- 📦 Supplier management
- 💳 Billing integration

**Technical:**
- 🧪 Unit & integration tests
- 🐳 Docker containerization
- ☁️ Cloud deployment (AWS/Azure)
- 🔄 CI/CD pipeline
- 📱 Progressive Web App (PWA)
- 🌐 Multi-language support
- 🎨 Theme customization
- 📊 Advanced data export

---

## 🛡️ Security Best Practices Implemented

### **Frontend Security**
- Token storage in localStorage
- XSS prevention
- Input validation
- HTTPS enforcement (production)
- Secure headers

### **Backend Security**
- Password hashing (BCrypt)
- JWT token validation
- CORS configuration
- SQL injection prevention (JPA)
- Rate limiting considerations
- Email validation
- Role verification on every request

### **Database Security**
- Parameterized queries
- Access control
- Regular backups
- Connection encryption

---

## 📱 Responsive Design

### **Breakpoints**
- **Desktop:** > 1024px
- **Tablet:** 768px - 1024px
- **Mobile:** < 768px

### **Responsive Features**
- Fluid layouts
- Flexible sidebar
- Stackable cards
- Mobile-friendly tables
- Touch-optimized buttons
- Adaptive navigation

### **Mobile Optimizations**
- Hamburger menu
- Swipe gestures
- Touch targets (44px min)
- Readable font sizes
- Optimized images

---

## 📚 Documentation

### **Available Documentation**
- ✅ README.md - Project overview
- ✅ INSTALLATION.md - Setup guide
- ✅ SETUP_GUIDE.md - Configuration
- ✅ DATABASE_SCHEMA.md - Schema details
- ✅ ARCHITECTURE_DIAGRAM.md - System design
- ✅ TESTING_GUIDE.md - Testing instructions
- ✅ PASSWORD_FEATURE_SUMMARY.md - Auth details
- ✅ RECYCLE_BIN_IMPLEMENTATION.md - Soft delete
- ✅ IMPLEMENTATION_SUMMARY.md - Feature list

### **Code Documentation**
- Inline comments
- JavaDoc comments
- Component documentation
- API endpoint descriptions

---

## 🎓 Learning Outcomes

### **Technical Skills Gained**

**Frontend:**
- React 18 with Hooks
- Modern JavaScript (ES6+)
- REST API integration
- State management
- Component design
- CSS styling techniques

**Backend:**
- Spring Boot framework
- Spring Security
- JPA/Hibernate ORM
- JWT authentication
- Email integration
- RESTful API design

**Database:**
- MySQL database design
- Query optimization
- Relationships & constraints
- Soft delete patterns

---

## 💡 Problem-Solving Approach

### **Challenges Faced & Solutions**

**Challenge 1: JWT Token Management**
- Problem: Token storage and renewal
- Solution: LocalStorage + Axios interceptors

**Challenge 2: Role-Based Access**
- Problem: Securing routes by role
- Solution: PrivateRoute component + backend validation

**Challenge 3: Real-time Stock Updates**
- Problem: Synchronizing stock across operations
- Solution: Transaction-based updates with JPA

**Challenge 4: Low Stock Detection**
- Problem: Automatic alert generation
- Solution: Database triggers + scheduled tasks

**Challenge 5: Soft Delete Implementation**
- Problem: Maintaining data integrity
- Solution: Deleted flag + timestamp + recycle bin

---

## 🎨 Design Decisions

### **Why These Technologies?**

**React**
- Component reusability
- Large ecosystem
- Fast virtual DOM
- Easy to learn

**Spring Boot**
- Production-ready
- Extensive features
- Great documentation
- Community support

**MySQL**
- ACID compliance
- Proven reliability
- Good performance
- Wide adoption

**JWT**
- Stateless authentication
- Scalable solution
- Cross-platform support
- Industry standard

---

## 📊 Project Statistics

### **Code Metrics**
- **Frontend Files:** 30+ components
- **Backend Files:** 40+ classes
- **Database Tables:** 5 core tables
- **API Endpoints:** 25+ routes
- **Lines of Code:** ~5000+ LOC
- **Dependencies:** 20+ libraries

### **Feature Metrics**
- **User Roles:** 3 roles
- **CRUD Operations:** 4 entities
- **Authentication Methods:** 3 types
- **Alert Types:** Real-time monitoring
- **Report Types:** Multiple formats

### **Development Time**
- Planning & Design: 20%
- Backend Development: 35%
- Frontend Development: 35%
- Testing & Debugging: 10%

---

## 🌟 Project Highlights

### **What Makes This Project Special?**

1. **Professional Design**
   - Clean, modern interface
   - Corporate-friendly aesthetics
   - Consistent design system

2. **Complete Feature Set**
   - Authentication & authorization
   - CRUD operations
   - Real-time alerts
   - Comprehensive reporting

3. **Best Practices**
   - Separation of concerns
   - Reusable components
   - Error handling
   - Security implementation

4. **Scalable Architecture**
   - Modular design
   - RESTful APIs
   - Database normalization
   - Component-based UI

---

## 🔗 System Integration

### **Integration Points**

**Frontend ↔ Backend**
- REST API communication
- JSON data format
- Axios HTTP client
- CORS enabled

**Backend ↔ Database**
- JPA/Hibernate ORM
- HikariCP connection pool
- Transaction management
- Query optimization

**Backend ↔ Email Service**
- JavaMailSender integration
- SMTP configuration
- HTML email templates
- Async email sending

---

## 🎯 Target Audience

### **Who Can Use This System?**

**Small Businesses**
- Retail stores
- Warehouses
- Small manufacturers
- Distributors

**Medium Enterprises**
- Multi-location businesses
- Growing companies
- E-commerce businesses

**Educational Institutions**
- Learning purposes
- Project demonstrations
- Teaching material

**Developers**
- Portfolio project
- Code reference
- Learning resource

---

## 📝 Conclusion

### **Project Summary**

The **Inventory Management System** is a comprehensive, professional-grade web application that successfully demonstrates:

✅ **Full-stack development skills**
✅ **Modern web technologies**
✅ **Security best practices**
✅ **Professional UI/UX design**
✅ **Database design & optimization**
✅ **RESTful API implementation**
✅ **Authentication & authorization**
✅ **Real-world business logic**

### **Key Takeaways**
- Built with modern, industry-standard technologies
- Implements complete CRUD operations
- Features role-based access control
- Professional minimal design
- Scalable and maintainable architecture
- Ready for deployment

---

## 🙏 Thank You!

### **Contact Information**

**Project:** Inventory Management System  
**Technologies:** React + Spring Boot + MySQL  
**Design:** Professional Minimal Design  

### **Demo Access**
- **URL:** http://localhost:3000
- **Backend:** http://localhost:8080
- **Database:** MySQL (mile3)

### **Roles & Credentials**
Configured during setup via DatabaseInitializer

---

## 📎 Appendix

### **Useful Resources**

**Documentation:**
- All MD files in project root
- Code comments throughout
- API endpoint documentation

**Technologies:**
- React: https://react.dev
- Spring Boot: https://spring.io/projects/spring-boot
- Vite: https://vitejs.dev

**Tools:**
- Postman (API testing)
- MySQL Workbench (Database)
- VS Code (Development)

### **Project Files**
- Source code: /src
- Configuration: application.properties
- Dependencies: pom.xml, package.json
- Documentation: *.md files

---

# Questions?

**Thank you for your attention!**

🚀 **Inventory Management System**  
*Professional Stock Management Solution*
