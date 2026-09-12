package inclass.m6.project3;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/** Java Project III - Game Title Rental Shop (Swing), student starter. */
public class RentalShopGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = System.getenv().getOrDefault(
            "UCI_RENTAL_DB_URL", "jdbc:mariadb://127.0.0.1:3306/rental_shop");
    private static final String DB_USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String DB_PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    private final Vector<Vector<String>> gameData = new Vector<>();
    private final Vector<String> gameColumns = new Vector<>();
    private JTable gameTable;

    public RentalShopGUI() {
        initializeUI();
        fetchGameData();
    }

    private void initializeUI() {
        setTitle("Game Rental Shop Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        gameColumns.add("Game ID");
        gameColumns.add("Title");
        gameColumns.add("Platform");
        gameTable = new JTable(gameData, gameColumns);
        add(new JScrollPane(gameTable), BorderLayout.CENTER);
        JButton rentButton = new JButton("Rent Game");
        rentButton.addActionListener(e -> rentGame());
        add(rentButton, BorderLayout.SOUTH);
        setSize(600, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void fetchGameData() {
        // TODO: SELECT game_id, title, platform FROM games and populate the JTable.
        try (Connection ignored = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Connection checkpoint.
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private void rentGame() {
        // TODO: Read selected game, prompt for customer name, and INSERT rental.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RentalShopGUI::new);
    }
}
