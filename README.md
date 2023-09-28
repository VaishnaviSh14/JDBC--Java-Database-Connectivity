# JDBC--Java-Database-Connectivity

## JDBC Prepared Statement and CRUD Operations with MySQL
This repository demonstrates how to perform CRUD (Create, Read, Update, Delete) operations using JDBC (Java Database Connectivity) prepared statements with a MySQL database. JDBC prepared statements are a secure and efficient way to interact with a database in Java applications.

Prerequisites
Before you begin, make sure you have the following installed and configured:

Java Development Kit (JDK) - Java 8 or higher

MySQL Database Server - Install and configure MySQL on your system.

MySQL JDBC Driver - Download and include the MySQL JDBC driver JAR in your project.

## Steps given by SUNMS to interact with Database
++++++++++++++++++++++++++++++++++++++++++++++
1. Load and register the driver
2. Establish the Connection
3. Create Statement/PreparedStatement/CallableStatement to transfer the query.
4. Execute the query
5. Process the result
6. close the resources
7. Handle SQLExceptions if it occurs.
   
# Setting up the Database
Create a MySQL database for this project (if not already created):

CREATE DATABASE your_database_name;
Create a table in the database for our CRUD operations example:

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

## Properties
db.url=jdbc:mysql://localhost:3306/your_database_name
db.username=your_mysql_username
db.password=your_mysql_password

## PreparedStatement
=> These statements are used to transfer the query during the compilation only.
=> These statements are also called as Pre-Compiled Query.
=> Performance of these object are high compared to Statement object.
=> In case of PreparedStatement the query will be incomplete and the values will
be injected to the query at the runtime.
=> Values to the PreparedStatement object will be injected using setXXXXX(int
pos,xxxxx value) throws SQLException method.
