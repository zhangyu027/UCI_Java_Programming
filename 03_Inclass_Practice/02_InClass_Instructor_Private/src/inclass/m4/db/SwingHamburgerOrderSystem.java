package inclass.m4.db;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/** Instructor reference: hamburger orders persisted in MariaDB. */
public class SwingHamburgerOrderSystem extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JTextArea outputArea = new JTextArea();
    public SwingHamburgerOrderSystem() {
        super("Hamburger Order Management System");
        JPanel buttons = new JPanel();
        for (String label : new String[] {
            "Place Order", "View History", "Cancel Order"
        }) {
            JButton button = new JButton(label);
            button.addActionListener(e -> runAction(label));
            buttons.add(button);
        }
        outputArea.setEditable(false);
        add(buttons, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 400);
        setLocationRelativeTo(null);
    }
    private void runAction(String action) {
        try {
            if (action.startsWith("Place")) {
                placeOrder();
            } else if (action.startsWith("View")) {
                viewHistory();
            } else {
                cancelOrder();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void placeOrder() throws SQLException {
        String customer = JOptionPane.showInputDialog(this, "Customer name:");
        String burger = JOptionPane.showInputDialog(this, "Burger type:");
        String sql = """
        INSERT INTO orders
        (customer_name, burger_type, order_date)
        VALUES(?, ?, ?)
        """;
        try(Connection connection = Db.open("hamburger_db");
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, customer);
            ps.setString(2, burger);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        }
        viewHistory();
    }
    private void viewHistory() throws SQLException {
        String sql = """
        SELECT order_id, customer_name, burger_type, order_date
        FROM orders
        ORDER BY order_id
        """;
        StringBuilder text = new StringBuilder();
        try(Connection connection = Db.open("hamburger_db");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                text.append(rs.getInt("order_id"))
                .append(" | ")
                .append(rs.getString("customer_name"))
                .append(" | ")
                .append(rs.getString("burger_type"))
                .append(" | ")
                .append(rs.getDate("order_date"))
                .append('\n');
            }
        }
        outputArea.setText(text.toString());
    }
    private void cancelOrder() throws SQLException {
        int id = Integer.parseInt(
        JOptionPane.showInputDialog(this, "Order ID:"));
        String sql = "DELETE FROM orders WHERE order_id = ?";
        try(Connection connection = Db.open("hamburger_db");
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        viewHistory();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        () -> new SwingHamburgerOrderSystem().setVisible(true));
    }
}
