# Inventory Management System - Complete Setup Guide

## Backend Setup (Spring Boot)

Your backend is already set up at: `c:\Users\yalam\Downloads\Inventory-mile-3-main`

### Running the Backend

1. Make sure MySQL is running with database `mile-3`
2. Update database credentials in `src/main/resources/application.properties` if needed
3. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```
   Or run `InventorySystemApplication.java` from your IDE

The backend will start on: `http://localhost:8080`

## Frontend Setup (React)

### Installation

1. Open a new terminal and navigate to the frontend directory:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm run dev
   ```

The frontend will start on: `http://localhost:3000`

## Default Login Credentials

The system has three roles with different access levels:

### Master Admin
- Can manage all users (create, delete, restore)
- Full system access

### Admin
- Can manage products (create, update, delete, restore)
- Can manage stock (in/out operations)
- Can view reports and analytics
- Can view employees

### Employee
- Can view products
- Can perform stock in/out operations
- Can view transactions
- Can view basic reports

**Note:** Check your database for actual user credentials or create users via Master Admin.

## Features Overview

### 🎨 User Interface
- Modern, gradient-based design
- Responsive layout for all devices
- Smooth animations and transitions
- Intuitive navigation

### 🔐 Security Features
- JWT token authentication
- Role-based access control
- Protected routes
- Auto-logout on session expiry

### 📊 Master Admin Dashboard
- User management
- User statistics
- Role-based filtering
- Soft delete with restore

### 📦 Admin Dashboard
- Product CRUD operations
- Stock In/Out management
- Inventory reports
- Category-wise analytics
- Low stock alerts
- Charts and visualizations
- Employee management

### 👷 Employee Dashboard
- View all products
- Stock In/Out operations
- Transaction history with filters
- Inventory summary
- Low stock alerts

## Tech Stack

### Backend
- Spring Boot 3.x
- Spring Security with JWT
- MySQL Database
- JPA/Hibernate
- Email Service

### Frontend
- React 18
- Vite
- React Router v6
- Axios
- Recharts (for visualizations)
- React Toastify (notifications)
- React Icons

## API Proxy Configuration

The frontend is configured to proxy API requests to the backend:
- Frontend: `http://localhost:3000`
- Backend API: `http://localhost:8080`
- Proxy: `/api` → `http://localhost:8080/api`

## Project Structure

```
Inventory-mile-3-main/
├── src/                          # Backend source code
│   └── main/
│       ├── java/com/inventory/   # Java packages
│       └── resources/            # Configuration files
├── frontend/                     # Frontend application
│   ├── src/
│   │   ├── pages/               # Page components
│   │   │   ├── MasterAdmin/    # Master Admin features
│   │   │   ├── Admin/          # Admin features
│   │   │   ├── Employee/       # Employee features
│   │   │   └── Login.jsx       # Login page
│   │   ├── components/         # Reusable components
│   │   ├── services/           # API services
│   │   └── utils/              # Helper functions
│   ├── package.json
│   └── vite.config.js
└── pom.xml                      # Maven configuration
```

## Common Issues & Solutions

### Backend Issues

1. **Database Connection Error**
   - Ensure MySQL is running
   - Verify database credentials in `application.properties`
   - Check if database `mile-3` exists

2. **Port Already in Use**
   - Change port in `application.properties`: `server.port=8081`

### Frontend Issues

1. **npm install fails**
   - Clear npm cache: `npm cache clean --force`
   - Delete `node_modules` and try again

2. **CORS Errors**
   - Backend has CORS configured for `http://localhost:3000`
   - Check `WebConfig.java` if accessing from different URL

3. **API Calls Fail**
   - Ensure backend is running on port 8080
   - Check network tab in browser DevTools
   - Verify API endpoints in `src/services/api.js`

## Development Workflow

1. Start backend server (runs on 8080)
2. Start frontend development server (runs on 3000)
3. Access application at `http://localhost:3000`
4. Login with your credentials
5. Explore role-specific features

## Building for Production

### Backend
```bash
mvn clean package
java -jar target/inventory-system.jar
```

### Frontend
```bash
cd frontend
npm run build
```

Deploy the `dist` folder to your web server.

## Browser Support

- Chrome (recommended)
- Firefox
- Safari
- Edge

## Mobile Responsiveness

The application is fully responsive and works on:
- Desktop (1024px+)
- Tablet (768px - 1023px)
- Mobile (< 768px)

## Support

For issues or questions:
1. Check the console for errors
2. Review network requests in DevTools
3. Check backend logs
4. Verify database state

Enjoy your Inventory Management System! 🎉
