# UCI Java Programming - Codespaces Edition

This repository is configured for GitHub Codespaces with **Java 21**, **Maven**, **MariaDB Connector/J 3.5.9**, automatically initialized **MariaDB** course databases, and a browser-accessible desktop for **Swing/AWT** applications.

## First launch
1. On GitHub choose **Code > Codespaces > Create codespace on master**.
2. Wait for the Codespace setup to finish. The database setup runs automatically when the Codespace is created, and classroom services start automatically when it starts.
3. Open any Java file containing `public static void main` and click **Run**.

For a newly created Codespace, you do **not** need to manually run `setup-db.sh`, `start-services.sh`, or database initialization commands.

For an existing Codespace, normally update the course repository with:

```bash
git pull origin master
```

If a future repository update specifically changes the database initialization or Codespaces environment, the instructor may ask you to rebuild or refresh the environment. Do not do that unless instructed.

## Database modules
No local JAR path is required. Maven downloads MariaDB Connector/J automatically.

The Codespace sets these classroom environment variables automatically:
- `UCI_DB_URL=jdbc:mariadb://127.0.0.1:3306/University`
- `UCI_LIBRARY_DB_URL=jdbc:mariadb://127.0.0.1:3306/library_db`
- `UCI_DB_USER=javauser`
- `UCI_DB_PASSWORD=JavaClass2026`

These credentials are only for the disposable classroom Codespace database; do not reuse them for production or personal systems.

Databases initialized automatically include:
- `University`
- `library_db`
- `company_db`
- `hamburger_db`
- `student_grade_db`
- `warehouse_db`
- `rental_shop`
- `EmployeeManagement`

## Swing applications
Codespaces has no physical monitor, so this package starts a lightweight browser desktop. Open the **Ports** tab and open port **6080** (`Swing Desktop (noVNC)`). Leave that browser tab open while running Swing/AWT programs.

Console applications do not require the Swing desktop.

## File-I/O examples
A portable `data/` directory is included so examples using paths such as `data/sales_data.txt` work without personal absolute paths.

## Student vs instructor content
This repository is the instructor master package and currently contains both student and instructor projects. Instructor-private folders should not be distributed as student solutions.

## Validation
From the Codespace terminal:

```bash
mvn clean compile
```

A successful build ends with `BUILD SUCCESS`.

## Important change from the old desktop package
Absolute personal JAR paths are not required in Codespaces. Dependencies are portable and managed by Maven.
