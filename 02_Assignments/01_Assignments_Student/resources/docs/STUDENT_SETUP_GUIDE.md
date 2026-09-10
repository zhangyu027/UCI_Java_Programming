# Student Setup Guide — Java Assignments

## Standard tools
- Eclipse
- JavaSE-21
- MariaDB Community Server for Module 4
- MariaDB Connector/J 3.5.9 for JDBC

## Module 4 order of work
1. Start MariaDB.
2. Verify you can log in with your own local MariaDB account.
3. Verify the `University` database and `Students` table exist.
4. Add Connector/J to this Eclipse project's **Classpath**.
5. Configure `UCI_DB_URL`, `UCI_DB_USER`, and `UCI_DB_PASSWORD` under **Run Configurations > Environment**.
6. Run `assignment.m4.studentdb.DatabaseConnectionTest`.
7. Continue to `StudentDatabaseApp` only after the console prints `SUCCESS: Connected to MariaDB!`.

## Suggested database SQL
```sql
CREATE DATABASE IF NOT EXISTS University;
USE University;

CREATE TABLE IF NOT EXISTS Students (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    major VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    credits INT
);
```

## Common problems
- **No suitable driver found**: Connector/J is missing from this project's Classpath.
- **Access denied (1045)**: username/password or authentication problem.
- **Access denied to database (1044)**: your account was not granted access to that database.
- **SQL command says command not found**: you typed SQL at the macOS/Windows shell instead of inside MariaDB.
- **Google Drive**: use it for backup/submission only; it is not a MariaDB server.
