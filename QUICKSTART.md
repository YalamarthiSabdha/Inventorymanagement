# Quick Start Guide

## Running the Application

### Option 1: Using the Run Script (Easiest)
1. Double-click `run.bat` in the project folder
2. The application will start on http://localhost:8080

### Option 2: Using Maven
```bash
mvn spring-boot:run
```

### Option 3: Using JAR file
```bash
java -jar target/inventory-management-1.0.0.jar
```

## First Time Setup

1. **Install MySQL** (if not already installed)
   - Download from: https://dev.mysql.com/downloads/installer/
   - Install and start MySQL service

2. **Create Database**
   ```sql
   CREATE DATABASE inventory_db;
   ```

3. **Update Database Credentials** (if needed)
   - Open `src/main/resources/application.properties`
   - Update username and password:
     ```properties
     spring.datasource.username=root
     spring.datasource.password=your_password
     ```

4. **Build and Run**
   ```bash
   mvn clean package
   java -jar target/inventory-management-1.0.0.jar
   ```

## Testing the Application

1. **Open your browser** and go to: http://localhost:8080

2. **Login with default credentials:**
   - Admin: username=`admin`, password=`admin123`
   - Employee: username=`employee`, password=`employee123`

3. **Test API endpoints** using Postman:
   - Import the `Inventory-API-Collection.postman_collection.json` file
   - Start with the Login endpoint to get a JWT token
   - Use the token in the Authorization header for other requests

## API Testing Examples

### 1. Login (POST /api/auth/login)
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d "{\"username\":\"admin\",\"password\":\"admin123\"}"
```

### 2. Get All Products (GET /api/products)
```bash
curl http://localhost:8080/api/products \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

### 3. Create Product (POST /api/products)
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"New Item\",\"sku\":\"SKU-999\",\"quantity\":50,\"minThreshold\":10,\"price\":99.99,\"category\":\"General\",\"unit\":\"pieces\"}"
```

### 4. Create Transaction (POST /api/transactions)
```bash
curl -X POST http://localhost:8080/api/transactions \
  -H "Authorization: Bearer YOUR_TOKEN_HERE" \
  -H "Content-Type: application/json" \
  -d "{\"productId\":1,\"type\":\"SALE\",\"quantity\":5,\"notes\":\"Test sale\"}"
```

## Project Structure Overview

```
src/main/java/com/inventory/
├── config/          - Application configuration
├── controller/      - REST API endpoints
├── dto/             - Data Transfer Objects
├── entity/          - Database entities
├── repository/      - Database access layer
├── security/        - JWT authentication
└── service/         - Business logic layer
```

## Troubleshooting

**Problem: Application won't start**
- Check if MySQL is running
- Verify database credentials in application.properties
- Check if port 8080 is available

**Problem: Cannot connect to database**
- Create the database: `CREATE DATABASE inventory_db;`
- Check MySQL service is running
- Verify username/password in application.properties

**Problem: JWT token errors**
- Token expires after 24 hours - login again
- Make sure to include "Bearer " prefix in Authorization header

## Default Sample Data

The application automatically creates:
- 2 users (admin and employee)
- 5 sample products
- Alerts for low/out-of-stock items

## Next Steps

1. Test all API endpoints using Postman collection
2. Check sample products created: GET /api/products
3. View active alerts: GET /api/alerts/active
4. Generate reports: GET /api/reports/inventory/pdf
5. Test transaction creation and stock updates

## Support

For questions or issues:
1. Check the main README.md for detailed documentation
2. Review API endpoints documentation
3. Check application logs in the console

---

**Happy Testing! 🚀**
