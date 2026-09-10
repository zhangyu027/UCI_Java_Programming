# MariaDB / JDBC instructor setup
Run the SQL files in `/sql` for the exercise you plan to demonstrate. Add MariaDB Connector/J to the Eclipse Build Path. The reference programs use environment variables so credentials are not hard-coded: `UCI_DB_USER`, `UCI_DB_PASSWORD`; the final project also accepts `UCI_LIBRARY_DB_URL`. Defaults are `root`, blank password, and localhost URLs. For classroom use, create a dedicated low-privilege account instead of using root.

The final project follows the supplied project practice: persistent MariaDB storage, add/remove/search books, checkout/return, validation, and a text-based menu. The assignment/rubric also requires a team PowerPoint and presentation; those are deliverables outside this Eclipse source project.
