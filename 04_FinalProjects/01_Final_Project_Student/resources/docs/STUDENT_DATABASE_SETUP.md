# Final Project Database Setup — Student Instructions

## 1. Create the database
Run the provided `sql/library_setup.sql` using your local MariaDB installation.

Expected database:
- `library_db`
- table: `books`
- columns: `id`, `title`, `author`, `available_copies`

## 2. Give your local Java user access
An administrative MariaDB account may be needed for this one-time step:

```sql
GRANT ALL PRIVILEGES ON library_db.* TO 'javauser'@'localhost';
FLUSH PRIVILEGES;
```

Use your own local password; do not submit it in source code.

## 3. Add Connector/J to Eclipse
Download `mariadb-java-client-3.5.9.jar` and keep it in a stable local folder.
Then:

**Project > Properties > Java Build Path > Libraries > Classpath > Add External JARs...**

The JAR is intentionally NOT hard-coded into `.classpath`, because every student's
computer has a different file path.

## 4. Configure environment variables
Under **Run > Run Configurations > Environment**:

- `UCI_LIBRARY_DB_URL=jdbc:mariadb://127.0.0.1:3306/library_db`
- `UCI_DB_USER=javauser`
- `UCI_DB_PASSWORD=<your local password>`

## 5. Run checkpoints
1. `SetupCheck`
2. `DatabaseConnectionTest`
3. Only then begin `LibraryService` and `Main`.

## Troubleshooting
- `No suitable driver found`: Connector/J is missing from this project's Classpath.
- `Access denied (1045)`: check your local database username/password.
- `Access denied to database (1044)`: ask for/grant permission to `library_db`.
- `Table 'books' doesn't exist`: run `sql/library_setup.sql`.
- Google Drive cannot run MariaDB; it is storage only.
