# Module 4 In-Class Practice — Student

## Use this order
1. Exceptions practice (no database required).
2. Swing GUI-only starters.
3. MariaDB/JDBC connection test.
4. DatabasePractice SELECT exercise.
5. StudentCrudDemo console CRUD.
6. Database-backed Swing starters.

## Eclipse
Import this folder as an Existing Project into Workspace.
Use JavaSE-21. Do not create module-info.java.

## MariaDB setup
Run sql/m4_all_databases_setup.sql as an administrative MariaDB account.
The script prepares:
- University
- company_db
- hamburger_db
- student_grade_db
- warehouse_db

## Connector/J
Add mariadb-java-client-3.5.9.jar to:
Project > Properties > Java Build Path > Libraries > Classpath

## Environment variables
Run > Run Configurations > Environment:

UCI_DB_SERVER_URL=jdbc:mariadb://127.0.0.1:3306
UCI_DB_URL=jdbc:mariadb://127.0.0.1:3306/University
UCI_DB_USER=javauser
UCI_DB_PASSWORD=YOUR_LOCAL_PASSWORD

## Required first database checkpoint
Run DatabaseConnectionTest.java.
Do not continue until it prints:
SUCCESS: Connected to MariaDB!

## Student code design
Student files compile before you begin. TODO / HINT / ANSWER CHECKPOINT comments guide the work without including the full instructor answer.

## Google Drive
Google Drive can store the ZIP/submission but cannot run MariaDB. Keep the active Eclipse project locally when possible.
