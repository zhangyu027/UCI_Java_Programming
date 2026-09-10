package student.finalproject.library;

/*
* STUDENT PROJECT GUIDE
* ---------------------
* Work in this order:
* 1. Run SetupCheck.
* 2. Create library_db with sql/library_setup.sql.
* 3. Add MariaDB Connector/J to this Eclipse project's Classpath.
* 4. Set UCI_LIBRARY_DB_URL, UCI_DB_USER, and UCI_DB_PASSWORD.
* 5. Run DatabaseConnectionTest until it prints SUCCESS.
* 6. Complete TODOs in DatabaseManager, LibraryService, and Main.
*
* KEY PARAMETERS:
* - JDBC URL: jdbc:mariadb://127.0.0.1:3306/library_db
* - Table: books(id, title, author, available_copies)
* - Use PreparedStatement for values entered by the user.
*
* ANSWER CHECKPOINT:
* Checkout must never reduce available_copies below 0.
*/
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
* JDBC operations required by the Library Management System.
*
* Complete TODO 2 through TODO 7.
*/
public class LibraryService {
    public void addBook(Book book)
    throws SQLException {
        /*
        * TODO 2: INSERT a new book.
        *
        * HINT:
        * String sql =
        *     "INSERT INTO books "
        *     + "(id, title, author, available_copies) "
        *     + "VALUES(?, ?, ?, ?)";
        *
        * Use:
        * - DatabaseManager.open()
        * - PreparedStatement
        * - setInt / setString
        * - executeUpdate()
        *
        * ANSWER CHECKPOINT:
        * Do not build SQL by concatenating user input.
        */
    }
    public boolean removeBook(int id)
    throws SQLException {
        /*
        * TODO 3: DELETE a book by id.
        *
        * HINT:
        * DELETE FROM books WHERE id = ?
        *
        * ANSWER CHECKPOINT:
        * return preparedStatement.executeUpdate() > 0;
        */
        return false;
    }
    public List<Book> search(String term)
    throws SQLException {
        /*
        * TODO 4:
        * Search by title OR author.
        *
        * HINT SQL:
        * SELECT id, title, author, available_copies
        * FROM books
        * WHERE LOWER(title) LIKE ?
        *    OR LOWER(author) LIKE ?
        * ORDER BY title
        *
        * HINT:
        * String query =
        *     "%" + term.toLowerCase() + "%";
        *
        * Create one Book object for every ResultSet row.
        */
        return Collections.emptyList();
    }
    public boolean checkout(int id)
    throws SQLException {
        /*
        * TODO 5:
        * Decrease available_copies by 1.
        *
        * IMPORTANT:
        * Do not allow copies to become negative.
        *
        * HINT SQL:
        * UPDATE books
        * SET available_copies = available_copies - 1
        * WHERE id = ?
        *   AND available_copies > 0
        */
        return false;
    }
    public boolean returnBook(int id)
    throws SQLException {
        /*
        * TODO 6:
        * Increase available_copies by 1
        * only when the book exists.
        *
        * HINT SQL:
        * UPDATE books
        * SET available_copies = available_copies + 1
        * WHERE id = ?
        */
        return false;
    }
    public List<Book> all()
    throws SQLException {
        /*
        * TODO 7:
        * Return all books ordered by title.
        *
        * HINT:
        * You may write a separate SELECT query,
        * or reuse search("") if your search method
        * correctly returns all books for an empty term.
        */
        return Collections.emptyList();
    }
}
