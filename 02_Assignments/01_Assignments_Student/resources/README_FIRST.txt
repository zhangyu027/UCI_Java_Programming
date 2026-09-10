UCI JAVA ASSIGNMENTS — STUDENT ECLIPSE PROJECT
==============================================

Recommended IDE: Eclipse
Java: JavaSE-21

IMPORT
------
File > Import > General > Existing Projects into Workspace

HOW TO USE THE STARTER CODE
---------------------------
Every Java file is formatted as normal multi-line Java code.
Look for:
- TODO: work you must implement.
- HINT: guidance or a partial code pattern.
- ANSWER CHECKPOINT: an expected concept/output to help you self-check.

The comments are there to help you proceed, but you should still write and explain
 your own final implementation.

IMPORTANT
---------
- Do NOT create module-info.java.
- Do NOT hard-code your real MariaDB password in submitted source code.
- Google Drive can store/submit the project ZIP, but does not run MariaDB.
- Keep your active Eclipse workspace on your local computer when possible.

MODULE 4 DATABASE SETUP
-----------------------
1. Install/start MariaDB locally.
2. Create University and the required Students/Courses tables using the provided SQL.
3. Download mariadb-java-client-3.5.9.jar.
4. Right-click this project > Properties > Java Build Path > Libraries > Classpath
   > Add External JARs... and select the Connector/J JAR.
5. Run DatabaseConnectionTest BEFORE StudentDatabaseApp.
6. In Run Configurations > Environment, add:
   UCI_DB_URL=jdbc:mariadb://127.0.0.1:3306/University
   UCI_DB_USER=javauser
   UCI_DB_PASSWORD=<your local password>

See docs/STUDENT_SETUP_GUIDE.md for detailed setup and troubleshooting.
