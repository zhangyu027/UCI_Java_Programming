# Final Project Pseudocode Guide

The Canvas practice assignment requires pseudocode for a Java Library Management System backed by MariaDB.

## Recommended pseudocode sections

### STARTUP / DATABASE CONNECTION
- Read database URL/user/password from configuration.
- Open JDBC connection.
- If connection fails, display a useful error and stop safely.
- Create the `books` table if necessary.

### ADD BOOK
- Prompt for ID, title, author, available copies.
- Validate ID/copies are numeric and copies >= 0.
- Validate required strings are nonblank.
- Execute parameterized INSERT.
- Display success or duplicate/error message.

### REMOVE BOOK
- Prompt for book ID.
- Validate ID.
- Execute parameterized DELETE.
- Report whether a book was removed.

### SEARCH BOOK
- Prompt for title or author term.
- Execute parameterized SELECT using LIKE.
- Loop through ResultSet and display matches.

### CHECK OUT
- Prompt for book ID.
- Update `available_copies = available_copies - 1` only when copies > 0.
- Report unavailable/not-found versus success.

### RETURN
- Prompt for book ID.
- Increase `available_copies` for an existing book.
- Report not-found versus success.

### TEXT UI
- Repeatedly display menu until Exit.
- Validate each menu choice.
- Catch expected input/database errors and keep the program usable.
