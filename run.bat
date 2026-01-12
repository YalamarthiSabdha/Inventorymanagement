@echo off
echo ================================================
echo Smart Inventory Management System
echo Starting Application...
echo ================================================
echo.

REM Set JAVA_HOME
set JAVA_HOME=C:\Program Files\Java\jdk-21

REM Check if MySQL is running
echo Checking MySQL connection...
echo NOTE: Make sure MySQL is running and the database 'inventory_db' exists
echo.

REM Run the application
cd /d "%~dp0"
"%JAVA_HOME%\bin\java" -jar target\inventory-management-1.0.0.jar

pause
