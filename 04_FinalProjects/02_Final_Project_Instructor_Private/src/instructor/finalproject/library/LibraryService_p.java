package instructor.finalproject.library;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryService_p {
    public void addBook(Book book)
    throws SQLException {
        String sql = """
        INSERT INTO books(
        id,
        title,
        author,
        available_copies
)
        VALUES(?, ?, ?, ?)
        """;
        try(Connection connection =
        DatabaseManager.open();
        PreparedStatement ps =
        connection.prepareStatement(sql)) {
            ps.setInt(1, book.id());
            ps.setString(2, book.title());
            ps.setString(3, book.author());
            ps.setInt(
            4,
            book.availableCopies());
            ps.executeUpdate();
        }
    }
    public boolean removeBook(int id)
    throws SQLException {
        String sql = """
        DELETE FROM books
        WHERE id = ?
        """;
        try(Connection connection =
        DatabaseManager.open();
        PreparedStatement ps =
        connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() >0;
                   
        }
    }
    public List<Book> search(String term)
    throws SQLException {
        String sql = """
        SELECT
        id,
        title,
        author,
        available_copies
        FROM books
        WHERE LOWER(title) LIKE ?
        OR LOWER(author) LIKE ?
        ORDER BY title
        """;
        List<Book> books =
        new ArrayList<>();
        String query =
        "%"
        + term.toLowerCase()
        + "%";
        try(Connection connection =
        DatabaseManager.open();
        PreparedStatement ps =
        connection.prepareStatement(sql)) {
            ps.setString(1, query);
            ps.setString(2, query);
            try(ResultSet rs =
            ps.executeQuery()) {
                while (rs.next()) {
                    book.add(
                    mapBook(rs));
                }
            }
        }
        return books;
    }
    public boolean checkout(int id)
    throws SQLException {
        String sql = """
        UPDATE books
        SET available_copies =
        available_copies - 1
        WHERE id = ?
        AND available_copies > 0
        """;
        try(Connection connection =
        DatabaseManager.open();
        PreparedStatement ps =
        connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() >0;
        }
    }
    public boolean returnBook(int id)
    throws SQLException {
        String sql = """
        UPDATE books
        SET available_copies =
        available_copies + 1
        WHERE id = ?
        """;
        try(Connection connection =
        DatabaseManager.open();
        PreparedStatement ps =
        connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate()>0;
        }
    }
    public List<Book> all()
    throws SQLException {
        return search("");
    }
    private Book mapBook(ResultSet rs)
    throws SQLException {
        return new Book(
        rs.getInt("id"),
        rs.getString("title"),
        rs.getString("author"),
        rs.getInt(
        "available_copies"));
    }
}