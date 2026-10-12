package instructor.inclass.m6.project3;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/** Java Project III - Game Title Rental Shop (Swing), instructor reference. */
public class RentalShopGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private final RentalShop shop = new RentalShop();
    private final DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Game ID", "Title", "Platform"}, 0) {
        @Override public boolean isCellEditable(int row, int column) { return false; }
    };
    private final JTable table = new JTable(model);

    public RentalShopGUI() {
        setTitle("Game Rental Shop Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        JButton rent = new JButton("Rent Game");
        rent.addActionListener(e -> rentGame());
        add(rent, BorderLayout.SOUTH);
        setSize(600, 350);
        setLocationRelativeTo(null);
        try {
            shop.initialize();
            refresh();
        } catch (SQLException ex) {
            showDatabaseError(ex);
        }
        setVisible(true);
    }

    private void refresh() {
        try {
            model.setRowCount(0);
            for (Game game : shop.getGames()) {
                model.addRow(new Object[]{game.getGameId(), game.getTitle(), game.getPlatform()});
            }
        } catch (SQLException ex) {
            showDatabaseError(ex);
        }
    }

    private void rentGame() {
        int viewRow = table.getSelectedRow();
        if (viewRow < 0) {
            JOptionPane.showMessageDialog(this, "Select a game first.");
            return;
        }
        String customer = JOptionPane.showInputDialog(this, "Customer name:");
        if (customer == null) return;
        customer = customer.trim();
        if (customer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Customer name cannot be empty.");
            return;
        }
        int row = table.convertRowIndexToModel(viewRow);
        int gameId = (Integer) model.getValueAt(row, 0);
        try {
            shop.rentGame(gameId, customer);
            JOptionPane.showMessageDialog(this, "Rental saved.");
            refresh();
        } catch (SQLException ex) {
            showDatabaseError(ex);
        }
    }

    private void showDatabaseError(SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(),
                "Rental Shop", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RentalShopGUI::new);
    }
}

/** Encapsulated model of a game. */
final class Game {
    private final int gameId;
    private final String title;
    private final String platform;

    public Game(int gameId, String title, String platform) {
        this.gameId = gameId;
        this.title = title;
        this.platform = platform;
    }
    public int getGameId() { return gameId; }
    public String getTitle() { return title; }
    public String getPlatform() { return platform; }
}

/** Encapsulated rental model; returnDate is optional for active rentals. */
final class Rental {
    private final int rentalId;
    private final int gameId;
    private final String customerName;
    private final Date rentalDate;
    private final Date returnDate;

    public Rental(int rentalId, int gameId, String customerName, Date rentalDate, Date returnDate) {
        this.rentalId = rentalId;
        this.gameId = gameId;
        this.customerName = customerName;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }
    public int getRentalId() { return rentalId; }
    public int getGameId() { return gameId; }
    public String getCustomerName() { return customerName; }
    public Date getRentalDate() { return rentalDate; }
    public Date getReturnDate() { return returnDate; }
}

/** Database operations are separate from Swing event handling. */
final class RentalShop {
    private static final String URL = System.getenv().getOrDefault(
            "UCI_RENTAL_DB_URL", "jdbc:mariadb://127.0.0.1:3306/rental_shop");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    private static final String[][] SAMPLE_GAMES = {
        {"The Legend of Zelda: Breath of the Wild", "Nintendo Switch"},
        {"Red Dead Redemption 2", "PlayStation 4"},
        {"The Witcher 3: Wild Hunt", "PC"},
        {"Minecraft", "PC"},
        {"Super Mario Odyssey", "Nintendo Switch"},
        {"God of War", "PlayStation 4"},
        {"FIFA 23", "PlayStation 5"},
        {"Cyberpunk 2077", "PC"},
        {"Call of Duty: Modern Warfare", "Xbox One"},
        {"Grand Theft Auto V", "PC"}
    };

    private Connection open() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /** Safe to run repeatedly: preserves existing games and rentals. */
    public void initialize() throws SQLException {
        try (Connection c = open(); Statement statement = c.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS games ("
                    + "game_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "title VARCHAR(255) NOT NULL, platform VARCHAR(100) NOT NULL)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS rentals ("
                    + "rental_id INT PRIMARY KEY AUTO_INCREMENT, game_id INT,"
                    + "customer_name VARCHAR(255), rental_date DATE,"
                    + "return_date DATE, FOREIGN KEY (game_id) REFERENCES games(game_id))");
            // Seed by title/platform without duplicating existing sample records.
            String insert = "INSERT INTO games(title,platform) "
                    + "SELECT ?, ? WHERE NOT EXISTS "
                    + "(SELECT 1 FROM games WHERE title=? AND platform=?)";
            try (PreparedStatement ps = c.prepareStatement(insert)) {
                for (String[] game : SAMPLE_GAMES) {
                    ps.setString(1, game[0]);
                    ps.setString(2, game[1]);
                    ps.setString(3, game[0]);
                    ps.setString(4, game[1]);
                    ps.executeUpdate();
                }
            }
        }
    }

    public List<Game> getGames() throws SQLException {
        List<Game> games = new ArrayList<>();
        try (Connection c = open();
             PreparedStatement ps = c.prepareStatement(
                     "SELECT game_id,title,platform FROM games ORDER BY game_id");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                games.add(new Game(rs.getInt("game_id"),
                        rs.getString("title"), rs.getString("platform")));
            }
        }
        return games;
    }

    public void rentGame(int gameId, String customer) throws SQLException {
        try (Connection c = open();
             PreparedStatement ps = c.prepareStatement(
                     "INSERT INTO rentals(game_id,customer_name,rental_date) "
                     + "VALUES(?,?,CURRENT_DATE)")) {
            ps.setInt(1, gameId);
            ps.setString(2, customer);
            ps.executeUpdate();
        }
    }
}
