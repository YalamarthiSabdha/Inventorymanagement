# Installation Guide

## Install Prerequisites

### 1. Install Java 21

#### Windows
1. Download JDK 21 from: https://www.oracle.com/java/technologies/downloads/#jdk21-windows
2. Run the installer (.exe file)
3. Set JAVA_HOME:
   - Right-click "This PC" → Properties → Advanced system settings
   - Click "Environment Variables"
   - Under "System variables", click "New"
   - Variable name: `JAVA_HOME`
   - Variable value: `C:\Program Files\Java\jdk-21`
   - Click OK
4. Add to PATH:
   - Edit "Path" variable under "System variables"
   - Click "New"
   - Add: `%JAVA_HOME%\bin`
   - Click OK

#### Linux (Ubuntu/Debian)
```bash
sudo apt update
sudo apt install openjdk-21-jdk
java -version
```

#### Mac
```bash
brew install openjdk@21
echo 'export PATH="/usr/local/opt/openjdk@21/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
java -version
```

### 2. Install Maven

#### Windows
1. Download Maven from: https://maven.apache.org/download.cgi
2. Extract to `C:\Maven\apache-maven-3.9.6`
3. Set M2_HOME:
   - Add System variable: `M2_HOME` = `C:\Maven\apache-maven-3.9.6`
4. Add to PATH:
   - Add to Path: `%M2_HOME%\bin`
5. Verify: `mvn -version`

#### Linux (Ubuntu/Debian)
```bash
sudo apt install maven
mvn -version
```

#### Mac
```bash
brew install maven
mvn -version
```

### 3. Install Node.js and npm

#### Windows
1. Download from: https://nodejs.org/ (LTS version)
2. Run installer
3. Verify:
   ```powershell
   node -v
   npm -v
   ```

#### Linux (Ubuntu/Debian)
```bash
curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash -
sudo apt install -y nodejs
node -v
npm -v
```

#### Mac
```bash
brew install node
node -v
npm -v
```

### 4. Install MySQL

#### Windows
1. Download MySQL Installer from: https://dev.mysql.com/downloads/installer/
2. Run installer, choose "Developer Default"
3. Set root password during installation
4. Complete installation
5. Start MySQL service from Services panel

#### Linux (Ubuntu/Debian)
```bash
sudo apt update
sudo apt install mysql-server
sudo systemctl start mysql
sudo mysql_secure_installation
```

#### Mac
```bash
brew install mysql
brew services start mysql
mysql_secure_installation
```

## Verify Installation

Run these commands to verify everything is installed:

```bash
# Check Java
java -version
# Should show: java version "21.x.x"

# Check Maven
mvn -version
# Should show: Apache Maven 3.9.x

# Check Node.js
node -v
# Should show: v18.x.x or higher

# Check npm
npm -v
# Should show: 9.x.x or higher

# Check MySQL
mysql --version
# Should show: mysql  Ver 8.0.x
```

## Configure MySQL

### Windows
```powershell
# Connect to MySQL
mysql -u root -p
# Enter your password

# Create database
CREATE DATABASE mile3;
SHOW DATABASES;
EXIT;
```

### Linux/Mac
```bash
# Connect to MySQL
sudo mysql -u root -p
# Or: mysql -u root -p

# Create database
CREATE DATABASE mile3;
SHOW DATABASES;
EXIT;
```

## Clone and Setup Project

### Using Git
```bash
git clone <repository-url>
cd Inventory-mile-3-main
```

### Or Download ZIP
1. Download project ZIP file
2. Extract to desired location
3. Open terminal/command prompt in project folder

## Update Configuration

Edit `src/main/resources/application.properties`:

```properties
# Update these with your MySQL credentials
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

## Run the Application

### Windows PowerShell
```powershell
# Terminal 1 - Backend
cd path\to\Inventory-mile-3-main
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"
mvn spring-boot:run

# Terminal 2 - Frontend (open new terminal)
cd path\to\Inventory-mile-3-main\frontend
npm install
npm run dev
```

### Linux/Mac Bash
```bash
# Terminal 1 - Backend
cd path/to/Inventory-mile-3-main
export JAVA_HOME=/path/to/jdk-21
mvn spring-boot:run

# Terminal 2 - Frontend (open new terminal)
cd path/to/Inventory-mile-3-main/frontend
npm install
npm run dev
```

## Access Application

Open browser and go to: **http://localhost:3000**

## Common Issues

### Issue: "JAVA_HOME not set"
**Solution:** Set JAVA_HOME as shown in Java installation steps above

### Issue: "mvn: command not found"
**Solution:** Maven not in PATH. Add Maven bin directory to PATH

### Issue: "npm: command not found"
**Solution:** Node.js not installed or not in PATH

### Issue: "Access denied for user 'root'@'localhost'"
**Solution:** 
- Check MySQL password in application.properties
- Verify MySQL is running
- Reset MySQL root password if needed

### Issue: "Port 8080 already in use"
**Solution (Windows):**
```powershell
netstat -ano | findstr :8080
taskkill /F /PID <PID>
```

**Solution (Linux/Mac):**
```bash
lsof -ti:8080 | xargs kill -9
```

### Issue: "Port 3000 already in use"
**Solution:** Kill process using port 3000 or change port in `frontend/vite.config.js`

## Next Steps

After successful installation:
1. Access application at http://localhost:3000
2. Login with default credentials (see QUICKSTART.md)
3. Change default passwords
4. Start using the application!

## Getting Updates

If project is updated:
```bash
# Pull latest changes
git pull origin main

# Update backend dependencies
mvn clean install

# Update frontend dependencies
cd frontend
npm install
```

## Need More Help?

- See README.md for detailed documentation
- See QUICKSTART.md for quick setup guide
- Check application logs for error messages
