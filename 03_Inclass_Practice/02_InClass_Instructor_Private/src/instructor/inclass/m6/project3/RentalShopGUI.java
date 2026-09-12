package instructor.inclass.m6.project3;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
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
    private static final String URL = System.getenv().getOrDefault(
            "UCI_RENTAL_DB_URL", "jdbc:mariadb://127.0.0.1:3306/rental_shop");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");
    private final Vector<Vector<String>> data = new Vector<>();
    private final Vector<String> columns = new Vector<>();
    private final JTable table = new JTable();

    public RentalShopGUI() {
        setTitle("Game Rental Shop Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        columns.add("Game ID"); columns.add("Title"); columns.add("Platform");
        add(new JScrollPane(table), BorderLayout.CENTER);
        JButton rent = new JButton("Rent Game");
        rent.addActionListener(e -> rentGame());
        add(rent, BorderLayout.SOUTH);
        setSize(600, 350);
        setLocationRelativeTo(null);
        refresh();
        setVisible(true);
    }

    private Connection open() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void refresh() {
        data.clear();
        try (Connection c = open(); ResultSet rs = c.createStatement().executeQuery(
                "SELECT game_id,title,platform FROM games ORDER BY game_id")) {
            while (rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(Integer.toString(rs.getInt(1)));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                data.add(row);
            }
            table.setModel(new DefaultTableModel(data, columns));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void rentGame() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select a game first."); return; }
        String customer = JOptionPane.showInputDialog(this, "Customer name:");
        if (customer == null || customer.isBlank()) return;
        try (Connection c = open(); PreparedStatement ps = c.prepareStatement(
                "INSERT INTO rentals(game_id,customer_name,rental_date) VALUES(?,?,CURRENT_DATE)")) {
            ps.setInt(1, Integer.parseInt(table.getValueAt(row, 0).toString()));
            ps.setString(2, customer.trim());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Rental saved.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RentalShopGUI::new);
    }
}
