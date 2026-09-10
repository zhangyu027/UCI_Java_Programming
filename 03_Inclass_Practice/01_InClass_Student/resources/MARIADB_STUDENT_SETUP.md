# Module 4 MariaDB Student Setup

## Before class
1. Install MariaDB Community Server.
2. Start MariaDB.
3. Ask the instructor for the course SQL setup script or create the required `University` database and tables.
4. Download `mariadb-java-client-3.5.9.jar`.
5. Add the JAR to the Eclipse project's **Classpath** (not Modulepath).

## Eclipse database variables
Open **Run > Run Configurations > Java Application > Environment** and add:

- `UCI_DB_URL=jdbc:mariadb://127.0.0.1:3306/University`
- `UCI_DB_USER=javauser`
- `UCI_DB_PASSWORD=<your local password>`

## First checkpoint
Run `inclass.m4.db.DatabasePractice`.
You should see `SUCCESS: Connected to MariaDB.` before proceeding.

## Common problems
- `No suitable driver found`: Connector/J is not on this project's Classpath.
- `Access denied`: verify username/password and MariaDB grants.
- `SELECT: command not found`: SQL was typed in Terminal instead of inside the MariaDB prompt.
- Google Drive: may store project files, but does not run MariaDB.
