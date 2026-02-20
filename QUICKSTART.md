# Quick Start Guide

## Minimum Requirements
- Java 21
- Maven 3.9+
- Node.js 18+
- MySQL 8.0+

## Quick Setup (5 Steps)

### 1. Database Setup
```sql
-- In MySQL Command Line or Workbench:
CREATE DATABASE mile3;
```

### 2. Configure Database
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

### 3. Start Backend
```bash
# Windows PowerShell:
cd Inventory-mile-3-main
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"
mvn spring-boot:run

# Linux/Mac:
cd Inventory-mile-3-main
export JAVA_HOME=/path/to/jdk-21
mvn spring-boot:run
```
Wait for: "Started InventorySystemApplication"

### 4. Start Frontend
```bash
# Open new terminal:
cd Inventory-mile-3-main/frontend
npm install
npm run dev
```

### 5. Access Application
Open browser: **http://localhost:3000**

## Login Credentials

**Master Admin:**
- Email: masteradmin@company.com
- Password: MasterAdmin@123

**Admin:**
- Email: admin@company.com
- Password: Admin@123

**Employee:**
- Email: employee@company.com
- Password: Employee@123

## Troubleshooting

### Backend won't start?
1. Check Java version: `java -version` (must be 21)
2. Check MySQL is running
3. Verify database exists: `SHOW DATABASES;`
4. Check credentials in application.properties

### Frontend won't start?
1. Delete `node_modules` folder
2. Run `npm install` again
3. Try `npm cache clean --force`

### Can't login?
1. Wait for backend to fully start (check console)
2. Clear browser cache
3. Check backend console for errors

## Ports Used
- Backend: 8080
- Frontend: 3000
- MySQL: 3306

## Need Help?
See full README.md for detailed instructions and troubleshooting.
