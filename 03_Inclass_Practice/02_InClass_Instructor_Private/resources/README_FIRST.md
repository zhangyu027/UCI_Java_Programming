# Module 4 In-Class Practice — Instructor

This package was normalized from the supplied Instructor_inclass_m4.zip and student in-Class_m4.zip.

Important fixes:
- All one-line Java files reformatted.
- Hard-coded instructor password removed.
- Db.java now supports getConnection(), open(), and open(databaseName).
- All database examples now compile against one helper.
- SQL setup added for all databases used by the examples.
- Student and instructor coverage aligned.
- Database tables are created by setup SQL rather than unexpectedly inside GUI constructors.

Suggested teaching order:
1. Exception demos.
2. GUI-only Swing starters.
3. DatabaseConnectionTest.
4. SELECT with DatabasePractice.
5. Console CRUD with StudentCrudDemo.
6. EmployeeManager.
7. Hamburger order DB example.
8. StudentGradeManager.
9. WarehouseManager.

Environment variables:
UCI_DB_SERVER_URL=jdbc:mariadb://127.0.0.1:3306
UCI_DB_URL=jdbc:mariadb://127.0.0.1:3306/University
UCI_DB_USER=javauser
UCI_DB_PASSWORD=<local password>
