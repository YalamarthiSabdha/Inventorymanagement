# Inventory Management System (IMS)

A comprehensive full-stack Inventory Management System built with Spring Boot and React.

## Features

### Master Admin
- User management (Create/Delete/Restore users)
- User Recycle Bin with 30-day retention
- Automatic cleanup scheduler
- Role-based access control

### Admin
- Product management (CRUD operations)
- Stock In/Out operations
- Product Recycle Bin
- Transaction history
- Reports and analytics
- Employee management

### Employee
- View products
- Stock In/Out operations
- Transaction history
- Reports

## Technology Stack

### Backend
- Java 21
- Spring Boot 3.5.10
- Spring Security with JWT
- Spring Data JPA
- MySQL 8.0
- Hibernate 6.6.41
- Maven 3.9+

### Frontend
- React 18
- Vite 5.4.21
- React Router v6
- Axios
- React Toastify
- React Icons

## Prerequisites

Before running this application, ensure you have the following installed:

1. **Java Development Kit (JDK) 21**
   - Download from: https://www.oracle.com/java/technologies/downloads/
   - Verify installation: `java -version`

2. **Maven 3.9+**
   - Download from: https://maven.apache.org/download.cgi
   - Add to PATH
   - Verify installation: `mvn -version`

3. **Node.js 18+ and npm**
   - Download from: https://nodejs.org/
   - Verify installation: `node -v` and `npm -v`

4. **MySQL 8.0+**
   - Download from: https://dev.mysql.com/downloads/mysql/
   - Verify installation: `mysql -V`

## Database Setup

1. **Start MySQL Server**

2. **Create Database**
   ```sql
   CREATE DATABASE mile3;
   ```

3. **Create MySQL User (Optional)**
   ```sql
   CREATE USER 'inventory_user'@'localhost' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON mile3.* TO 'inventory_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

4. **Update Database Configuration**
   
   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/mile3
   spring.datasource.username=root
   spring.datasource.password=your_mysql_password
   ```

## Backend Setup

1. **Navigate to project root directory**
   ```bash
   cd Inventory-mile-3-main
   ```

2. **Set JAVA_HOME environment variable**
   
   **Windows:**
   ```powershell
   $env:JAVA_HOME = "C:\Program Files\Java\jdk-21"
   ```
   
   **Linux/Mac:**
   ```bash
   export JAVA_HOME=/path/to/jdk-21
   ```

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the backend**
   ```bash
   mvn spring-boot:run
   ```
   
   The backend will start on: **http://localhost:8080**

## Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Run the development server**
   ```bash
   npm run dev
   ```
   
   The frontend will start on: **http://localhost:3000**

## Default Login Credentials

After the database initializes, you can use these default credentials:

### Master Admin
- **Email:** masteradmin@company.com
- **Password:** MasterAdmin@123

### Admin
- **Email:** admin@company.com
- **Password:** Admin@123

### Employee
- **Email:** employee@company.com
- **Password:** Employee@123

## Project Structure

```
Inventory-mile-3-main/
├── src/
│   ├── main/
│   │   ├── java/com/inventory/
│   │   │   ├── config/          # Security & database configuration
│   │   │   ├── controller/      # REST API endpoints
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── entity/          # JPA Entities
│   │   │   ├── repository/      # Database repositories
│   │   │   ├── scheduler/       # Scheduled tasks
│   │   │   ├── security/        # JWT authentication
│   │   │   ├── service/         # Business logic
│   │   │   └── util/            # Utility classes
│   │   └── resources/
│   │       └── application.properties
├── frontend/
│   ├── src/
│   │   ├── pages/              # React components
│   │   │   ├── Admin/
│   │   │   ├── Employee/
│   │   │   └── MasterAdmin/
│   │   ├── services/           # API service layer
│   │   └── utils/              # Helper functions
│   ├── package.json
│   └── vite.config.js
├── pom.xml
└── README.md
```

## API Endpoints

### Authentication
- `POST /api/auth/login` - User login

### Master Admin
- `GET /api/master-admin/users` - Get all users
- `GET /api/master-admin/users/active` - Get active users
- `GET /api/master-admin/users/deleted` - Get deleted users
- `POST /api/master-admin/users` - Create user
- `DELETE /api/master-admin/users/{id}` - Soft delete user
- `POST /api/master-admin/users/{id}/restore` - Restore user
- `DELETE /api/master-admin/users/{id}/permanent` - Permanently delete user

### Admin
- `GET /api/admin/products` - Get all products
- `POST /api/admin/products` - Create product
- `PUT /api/admin/products/{id}` - Update product
- `DELETE /api/admin/products/{id}` - Delete product
- `POST /api/admin/stock/in` - Stock in
- `POST /api/admin/stock/out` - Stock out
- `GET /api/admin/transactions` - Get transactions
- `GET /api/admin/reports/*` - Various reports

### Employee
- `GET /api/employee/products` - Get all products
- `POST /api/employee/stock/in` - Stock in
- `POST /api/employee/stock/out` - Stock out
- `GET /api/employee/transactions` - Get transactions

## Features in Detail

### User Recycle Bin
- Soft delete users instead of permanent deletion
- 30-day retention period
- Automatic cleanup via scheduled task (runs daily at 2:00 AM)
- Restore functionality within retention period
- Visual countdown indicator

### Product Recycle Bin
- Similar functionality for products
- Separate recycle bin for products
- Restore within retention period

### Transaction History
- Complete audit trail of all stock movements
- Filter by SKU, product name, type, and date range
- Before/after quantity tracking

### Automated Cleanup
- Scheduled tasks for automatic deletion
- Runs at 2:00 AM daily
- Protects Master Admin from deletion

## Troubleshooting

### Backend Issues

**Problem: Port 8080 already in use**
```bash
# Windows: Find and kill process
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Linux/Mac: Find and kill process
lsof -ti:8080 | xargs kill -9
```

**Problem: Database connection failed**
- Verify MySQL is running
- Check credentials in `application.properties`
- Ensure database `mile3` exists

**Problem: Java version mismatch**
```bash
# Check Java version
java -version

# Set JAVA_HOME to JDK 21
```

### Frontend Issues

**Problem: Port 3000 already in use**
- Change port in `frontend/vite.config.js`
- Or kill the process using port 3000

**Problem: API calls failing**
- Ensure backend is running on port 8080
- Check browser console for CORS errors
- Verify API base URL in `frontend/src/services/api.js`

**Problem: npm install fails**
```bash
# Clear npm cache
npm cache clean --force

# Delete node_modules and package-lock.json
rm -rf node_modules package-lock.json

# Reinstall
npm install
```

## Building for Production

### Backend
```bash
mvn clean package
java -jar target/inventory-system-1.0.0.jar
```

### Frontend
```bash
cd frontend
npm run build
```
The build output will be in `frontend/dist/`

## Environment Variables

### Backend
Create `application-prod.properties` for production:
```properties
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
jwt.secret=${JWT_SECRET}
jwt.expiration=${JWT_EXPIRATION}
```

### Frontend
Create `.env.production`:
```
VITE_API_BASE_URL=https://your-api-domain.com/api
```

## Security Notes

1. **Change Default Passwords** - Update all default user passwords immediately
2. **JWT Secret** - Use a strong secret key in production
3. **Database Credentials** - Use environment variables for sensitive data
4. **HTTPS** - Enable HTTPS in production
5. **CORS** - Configure proper CORS settings for production

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License.

## Support

For issues and questions, please create an issue in the repository.

## Acknowledgments

- Spring Boot Documentation
- React Documentation
- MySQL Documentation
