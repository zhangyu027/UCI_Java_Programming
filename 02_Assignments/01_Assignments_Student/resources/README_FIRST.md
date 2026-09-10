# Module 4 — Student Database Setup and Starter

## Goal
Build a Swing application that connects to MariaDB and supports:
- Add student
- Update student
- Delete student
- Display students

## Use Eclipse
Import this folder with:
File > Import > General > Existing Projects into Workspace

Use JavaSE-21. Do not create module-info.java.

## 1. Install/start MariaDB
macOS Homebrew example:
    brew services start mariadb

## 2. Create the database
Run sql/university_setup.sql using an administrative MariaDB account.

## 3. Create or configure a local database user
Your instructor may give you a username. Example:
    javauser

Do NOT place your real password inside Java source code.

## 4. Add MariaDB Connector/J to Eclipse
Project > Properties > Java Build Path > Libraries > Classpath
> Add External JARs...

Select:
    mariadb-java-client-3.5.9.jar

## 5. Configure Eclipse Environment Variables
Run > Run Configurations... > Java Application > Environment

Add:
    UCI_DB_URL=jdbc:mariadb://127.0.0.1:3306/University
    UCI_DB_USER=javauser
    UCI_DB_PASSWORD=YOUR_LOCAL_PASSWORD

## 6. First checkpoint
Run:
    DatabaseConnectionTest.java

Do not begin the CRUD assignment until the console prints:
    SUCCESS: Connected to MariaDB!

## 7. Complete StudentDatabaseApp.java
Work through TODO 1 through TODO 5 in order.

The comments include HINT and ANSWER CHECKPOINT guidance,
but the full instructor solution is not included.

## Common Problems
ERROR 1045:
- Wrong username/password or authentication setup.

ERROR 1044:
- Your database user does not have permission to the database.

No suitable driver:
- Connector/J is not on this Eclipse project's Classpath.

SELECT: command not found:
- SQL was typed into Terminal instead of the MariaDB prompt.

## Google Drive
Google Drive can store the ZIP and your submission.
It cannot run MariaDB.
For fewer problems, keep your active Eclipse project in a local folder
such as Documents/JavaProjects.
