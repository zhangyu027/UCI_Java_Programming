# Module 4 — Instructor Reference

This cleaned package standardizes the two supplied M4 versions.

Canonical schema:
    University.Students(
        student_id,
        first_name,
        last_name,
        email,
        major
    )

Connection:
    jdbc:mariadb://127.0.0.1:3306/University

Db.java intentionally supports both:
    Db.getConnection()
    Db.open()

This keeps compatibility with older classroom examples that may call Db.open().

Before running:
1. Run sql/university_setup.sql.
2. Add MariaDB Connector/J to the project Classpath.
3. Configure:
   UCI_DB_URL
   UCI_DB_USER
   UCI_DB_PASSWORD
4. Run DatabaseConnectionTest.
5. Run StudentDatabaseApp.

The instructor solution demonstrates PreparedStatement-based CRUD
with input validation and readable multi-line Java formatting.
