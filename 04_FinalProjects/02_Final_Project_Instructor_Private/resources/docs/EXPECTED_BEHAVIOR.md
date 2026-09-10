# Expected Behavior

The application should display a text menu with options 1-6 and 0.

- Add: inserts a new book.
- Remove: deletes an existing book.
- Search: matches title or author, case-insensitive.
- Checkout: decrements copies only if copies > 0.
- Return: increments copies only if the book exists.
- List all: displays all records.
- Exit/restart: database records remain.

Use `PreparedStatement` for parameterized SQL.
