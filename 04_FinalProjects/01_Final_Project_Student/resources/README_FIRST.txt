UCI JAVA FINAL PROJECT — STUDENT ECLIPSE STARTER
================================================

PROJECT
-------
Library Management System using Java + MariaDB.
Required functions include add, remove, search, checkout, return, and persistent
book data.

RECOMMENDED TOOLS
-----------------
- Eclipse
- JavaSE-21
- MariaDB Community Server
- MariaDB Connector/J 3.5.9

IMPORT
------
File > Import > General > Existing Projects into Workspace
Select UCI_Java_Final_Project_Student.
Do NOT create module-info.java.

WORK IN THIS ORDER
------------------
1. Run student.finalproject.library.SetupCheck.
2. Create library_db and books table using sql/library_setup.sql.
3. Download mariadb-java-client-3.5.9.jar.
4. Add it to THIS project:
   Project > Properties > Java Build Path > Libraries > Classpath
   > Add External JARs...
5. Run DatabaseConnectionTest.
6. Do not begin the full menu until DatabaseConnectionTest prints SUCCESS.
7. Complete DatabaseManager.initialize().
8. Complete LibraryService methods.
9. Complete Main.run() menu workflow.
10. Test persistence: add a book, exit, restart, and confirm the book remains.

ECLIPSE ENVIRONMENT VARIABLES
-----------------------------
Run > Run Configurations > Java Application > Environment

UCI_LIBRARY_DB_URL=jdbc:mariadb://127.0.0.1:3306/library_db
UCI_DB_USER=javauser
UCI_DB_PASSWORD=<your local MariaDB password>

HOW THE COMMENTS WORK
---------------------
TODO = required work for you to implement.
HINT = partial guidance/code pattern.
ANSWER CHECKPOINT = expected behavior or concept for self-checking.

Do not simply copy a commented pattern without understanding it. Be prepared to
explain your design and code during the team presentation.

GOOGLE DRIVE
------------
Google Drive can store the ZIP, SQL files, presentation, and submission. It does
NOT run MariaDB. Run MariaDB locally (or use an instructor-approved hosted DB).
For fewer Eclipse problems, keep the active workspace on the local computer.

See docs/STUDENT_DATABASE_SETUP.md and docs/STUDENT_REQUIREMENTS_CHECKLIST.md.
