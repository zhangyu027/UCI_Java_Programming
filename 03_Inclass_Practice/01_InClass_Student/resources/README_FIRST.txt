UCI JAVA IN-CLASS STUDENT PROJECT — START HERE
==============================================

Recommended IDE: Eclipse
Java: JavaSE-21

1. Import this folder with:
   File > Import > General > Existing Projects into Workspace

2. Do NOT create module-info.java.

3. The Java files are intentionally incomplete but compile-ready.
   Look for comments marked:
   TODO  = work you should complete
   HINT  = guidance or a code pattern
   ANSWER CHECKPOINT = expected concept/output, not a full submitted solution

4. Module 4 / MariaDB:
   - MariaDB runs on your LOCAL computer. Google Drive does not run MariaDB.
   - Install/start MariaDB before the database labs.
   - Download MariaDB Connector/J (mariadb-java-client-3.5.9.jar).
   - In Eclipse: Project > Properties > Java Build Path > Libraries > Classpath
     > Add External JARs... > select the Connector/J JAR.
   - Do this separately for every Eclipse project that uses MariaDB.
   - Configure database credentials with Eclipse Run Configurations > Environment.

5. Suggested Module 4 environment variables:
   UCI_DB_URL=jdbc:mariadb://127.0.0.1:3306/University
   UCI_DB_USER=javauser
   UCI_DB_PASSWORD=<your local MariaDB password>

6. Run in this order for database work:
   a. Confirm MariaDB login in Terminal.
   b. Run inclass.m4.db.DatabasePractice.
   c. Do not begin a larger Swing/JDBC program until the connection test succeeds.

7. Keep your active Eclipse workspace on the local computer.
   Google Drive is fine for backup/submission, but is not recommended as the active
   Eclipse workspace and cannot host the local MariaDB server.
