# MariaDB Setup Guide — Library Management System

## 1. Install MariaDB and Connector/J
Install MariaDB Server locally (or use an instructor-provided server). Download MariaDB Connector/J and add its JAR to the Eclipse project's **Classpath**.

## 2. Create the database
Run `library_setup.sql` in MariaDB. It creates `library_db` and a `books` table with the required fields.

## 3. Configure credentials safely
Recommended environment variables:

```text
UCI_LIBRARY_DB_URL=jdbc:mariadb://localhost:3306/library_db
UCI_DB_USER=your_user
UCI_DB_PASSWORD=your_password
```

The Java starter reads these variables. Do not submit real passwords to Canvas or GitHub.

## 4. JDBC pattern students should understand
`DriverManager.getConnection(...)` establishes the connection. Use `PreparedStatement` for SQL containing user data and use try-with-resources to close `Connection`, `PreparedStatement`, and `ResultSet`.

## 5. Test order
1. Run SQL setup.
2. Add Connector/J to Eclipse.
3. Test connection.
4. Create table automatically or verify it exists.
5. Test add/search.
6. Test remove.
7. Test checkout/return.
8. Test restart persistence.
