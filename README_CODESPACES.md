# UCI Java Programming - Codespaces Edition

This package is configured for GitHub Codespaces with **Java 21**, **Maven**, **MariaDB Connector/J 3.5.9**, an automatically initialized **MariaDB** database, and a browser-accessible desktop for **Swing/AWT** applications.

## First launch
1. Push this folder to GitHub (keep instructor folders in a **private repository** if students should not see solutions).
2. On GitHub choose **Code > Codespaces > Create codespace**.
3. Wait for `postCreateCommand` to finish. The root Maven build validates all eight student/instructor teaching projects.
4. Open any Java file containing `public static void main` and click **Run**.

## Database modules
No local JAR path is required. Maven downloads MariaDB Connector/J automatically.

The Codespace sets these environment variables automatically:
- `UCI_DB_URL=jdbc:mariadb://127.0.0.1:3306/University`
- `UCI_LIBRARY_DB_URL=jdbc:mariadb://127.0.0.1:3306/library_db`
- `UCI_DB_USER=javauser`
- `UCI_DB_PASSWORD=uci_codespace`

These credentials are only for the disposable classroom Codespace database; do not reuse them for production or personal systems.

Databases initialized automatically: `University`, `company_db`, `hamburger_db`, `student_grade_db`, `warehouse_db`, and `library_db`.

## Swing applications
Codespaces has no physical monitor, so this package starts a lightweight browser desktop. Open the **Ports** tab and open port **6080** (`Swing Desktop (noVNC)`). Leave that browser tab open while running Swing/AWT programs.

## File-I/O examples
A portable `data/` directory is included at the repository root and inside each teaching module so examples using paths such as `data/sales_data.txt` work from both repository and module working directories.

## Student vs instructor content
This archive intentionally contains both student and instructor projects because it is the instructor master package. **Do not publish the instructor-private folders in a public student repository.** For class distribution, copy only student folders to the public/Classroom repository.

## Validation
From the Codespace terminal:

```bash
mvn -DskipTests package
```

A successful build ends with `BUILD SUCCESS`.

To verify MariaDB:

```bash
mariadb -h 127.0.0.1 -u javauser -puci_codespace University -e "SELECT * FROM Students;"
```

## Important change from the old desktop package
Absolute paths such as `/Users/.../mariadb-java-client-3.5.9.jar` were removed. Dependencies are now portable and managed by Maven.
