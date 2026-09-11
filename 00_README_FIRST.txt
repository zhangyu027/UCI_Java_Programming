UCI I&C SCI X460.17 Java Programming — REORGANIZED COURSE PACKAGE
================================================================

This package is designed to replace the mixed Eclipse/Google Drive structure.

IMPORTANT
---------
The COURSE folder may live in Google Drive.
The ECLIPSE WORKSPACE metadata should stay local, for example:

<your local Eclipse workspace>/UCI_X460.17_JavaProgramming

Do not use this entire course folder itself as the Eclipse workspace.

IMPORT ONLY THE ECLIPSE PROJECT FOLDERS
---------------------------------------
02_Assignments/01_Assignments_Student
02_Assignments/02_Assignments_Instructor_Private
03_Inclass_Practice/01_InClass_Student
03_Inclass_Practice/02_InClass_Instructor_Private
04_FinalProjects/01_Final_Project_Student
04_FinalProjects/02_Final_Project_Instructor_Private
05_MidTerms/01_Midterm_Student_Study
05_MidTerms/02_Midterm_Instructor_Private

Each imported project has its own .project, .classpath, src/, and JavaSE-21 settings.

MODULE 4 DATABASE STANDARD
--------------------------
Assignment M4:
  Db.java
    -> getConnection()
    -> open() compatibility alias
  DatabaseConnectionTest.java
  StudentDatabaseApp.java
    -> addStudent()
    -> updateStudent()
    -> deleteStudent()
    -> displayStudents()

In-class M4 database examples:
  -> shared Db.java
  -> use the shared Db connection helper
  -> SQL setup in sql/m4_all_databases_setup.sql

Database environment variables:
  UCI_DB_URL
  UCI_DB_SERVER_URL
  UCI_DB_USER
  UCI_DB_PASSWORD

Connector/J:
Keep mariadb-java-client-3.5.9.jar in a stable LOCAL folder and add it to the
Classpath of the projects that you RUN against MariaDB.

GLOBAL DATABASE CONFIGURATION — macOS AND WINDOWS
=================================================

The course database code reads connection information from environment variables.
This lets students configure credentials once instead of hard-coding passwords in
Java source files or entering them separately for every Eclipse Run Configuration.

Variables used by the course:

   UCI_DB_USER
   UCI_DB_PASSWORD
   UCI_DB_URL
   UCI_LIBRARY_DB_URL

Use your OWN local MariaDB username and password. Do not place real passwords in
student-distributed Java files or README files.


macOS — GLOBAL SETUP
--------------------

Recommended approach: define the variables in the macOS launch environment so
Eclipse can inherit them.

1. Quit Eclipse completely:
      Eclipse -> Quit Eclipse
   or press:
      Command-Q

2. Open Terminal and run:

      launchctl setenv UCI_DB_USER "javauser"
      launchctl setenv UCI_DB_PASSWORD "<your local MariaDB password>"
      launchctl setenv UCI_DB_URL "jdbc:mariadb://127.0.0.1:3306/University"
      launchctl setenv UCI_LIBRARY_DB_URL "jdbc:mariadb://127.0.0.1:3306/library_db"

3. Verify the values:

      launchctl getenv UCI_DB_USER
      launchctl getenv UCI_DB_PASSWORD
      launchctl getenv UCI_DB_URL
      launchctl getenv UCI_LIBRARY_DB_URL

4. Reopen Eclipse AFTER the variables have been configured.

5. Run DatabaseConnectionTest.java:

      Right-click DatabaseConnectionTest.java
      -> Run As
      -> Java Application

If Eclipse was already open when launchctl setenv was executed, quit Eclipse
completely and reopen it before testing.


Windows — RECOMMENDED GUI SETUP
-------------------------------

For most students, Windows Environment Variables is the easiest persistent setup.

1. Close Eclipse completely.

2. Open the Windows Start menu and search for:

      Edit environment variables for your account

3. Open it.

4. Under "User variables", click New and create these four variables:

      Variable name:  UCI_DB_USER
      Variable value: javauser

      Variable name:  UCI_DB_PASSWORD
      Variable value: <your local MariaDB password>

      Variable name:  UCI_DB_URL
      Variable value: jdbc:mariadb://127.0.0.1:3306/University

      Variable name:  UCI_LIBRARY_DB_URL
      Variable value: jdbc:mariadb://127.0.0.1:3306/library_db

5. Click OK to save the variables and close the Environment Variables windows.

6. Reopen Eclipse.

7. Run DatabaseConnectionTest.java:

      Right-click DatabaseConnectionTest.java
      -> Run As
      -> Java Application


Windows — COMMAND PROMPT ALTERNATIVE
------------------------------------

Students may alternatively create persistent user environment variables with
Command Prompt:

      setx UCI_DB_USER "javauser"
      setx UCI_DB_PASSWORD "<your local MariaDB password>"
      setx UCI_DB_URL "jdbc:mariadb://127.0.0.1:3306/University"
      setx UCI_LIBRARY_DB_URL "jdbc:mariadb://127.0.0.1:3306/library_db"

IMPORTANT:
setx affects NEW processes. Close Eclipse before running these commands and
reopen Eclipse afterward.

To verify in a NEW Command Prompt window:

      echo %UCI_DB_USER%
      echo %UCI_DB_PASSWORD%
      echo %UCI_DB_URL%
      echo %UCI_LIBRARY_DB_URL%


ECLIPSE RUN CONFIGURATION NOTE
------------------------------

Eclipse may create separate Java launch configurations for different projects
or main classes. This is normal.

You do NOT need to copy UCI_DB_USER and UCI_DB_PASSWORD into every Java Run
Configuration when Eclipse has inherited the operating-system environment
variables.

The Java code can read them with:

      System.getenv("UCI_DB_USER")
      System.getenv("UCI_DB_PASSWORD")
      System.getenv("UCI_DB_URL")
      System.getenv("UCI_LIBRARY_DB_URL")

Therefore, the intended workflow is:

      macOS/Windows environment variables
                  |
                  v
               Eclipse
                  |
                  v
           Java application
                  |
                  v
        Db.getConnection()
                  |
                  v
               MariaDB

IMPORTANT — JDBC DRIVER IS SEPARATE
-----------------------------------

Global environment variables provide the database connection SETTINGS only.
They do not install the MariaDB JDBC driver.

Any Eclipse project that runs MariaDB/JDBC code must still have:

      mariadb-java-client-3.5.9.jar

on that project's:

      Build Path -> Classpath / Referenced Libraries

Typical JDBC projects include:

      02A Assignments Student
      02B Assignments Instructor Private
      03A In-Class Student
      03B In-Class Instructor Private
      04A Final Project Student
      04B Final Project Instructor Private


DATABASE CONNECTION TEST
------------------------

After completing the setup for your operating system:

1. Make sure MariaDB is running.
2. Make sure the required course database has been created.
3. Make sure Connector/J is on the Eclipse project's Classpath.
4. Restart Eclipse after setting/changing environment variables.
5. Open DatabaseConnectionTest.java.
6. Right-click the Java file.
7. Select Run As -> Java Application.

A successful test should report a successful MariaDB connection and, where
applicable, display records from the configured database.


DATABASE TROUBLESHOOTING
------------------------
"No suitable driver found"
   -> MariaDB Connector/J is missing from that Eclipse project's Classpath.

"Access denied ... (using password: NO)"
   -> Eclipse did not inherit UCI_DB_PASSWORD. Quit Eclipse completely, verify
      the launchctl variables, and reopen Eclipse.

"Access denied ... (using password: YES)"
   -> MariaDB received a password but rejected the credentials. Verify the
      local MariaDB username and password.

Students should configure their own local MariaDB credentials. Instructor
credentials must not be embedded in the student package.

WHAT WAS CLEANED
----------------
- Removed the course-level .metadata Eclipse workspace.
- Removed macOS __MACOSX and .DS_Store artifacts.
- Removed stale bin/build outputs.
- Corrected Eclipse project names so they are unique.
- Separated Student and Instructor code to prevent duplicate-package conflicts.
- Moved Java files into package-correct src/ paths.
- Removed duplicate Final Project student Java copies from lib/.
- Standardized JavaSE-21 Eclipse metadata.

V3 FORMAT / STUDENT GUIDANCE UPDATE
-----------------------------------
- All Java source files were reformatted into readable multi-line Java source.
- Student projects contain visible STUDENT HINTS / IN-CLASS STUDENT HINTS /
  STUDENT PROJECT GUIDE comments.
- Existing TODO, HINT, and ANSWER CHECKPOINT comments were preserved.
- Midterm student review examples now contain STUDENT STUDY GUIDE comments.
- Eclipse formatter preferences use spaces, 4-space indentation, and a 120-column
  line width.
- Instructor solutions remain complete and private.
