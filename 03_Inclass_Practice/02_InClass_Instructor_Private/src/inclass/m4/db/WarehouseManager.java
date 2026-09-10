package inclass.m4.db;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Instructor reference: warehouse calculations + MariaDB persistence. */
public class WarehouseManager extends JFrame {
    private static final long serialVersionUID = 1L;
    private int stock = 0;
    private final JTextField receivingField = new JTextField(8);
    private final JTextField priceField = new JTextField(8);
    private final JTextField releasingField = new JTextField(8);
    private final JLabel totalLabel = new JLabel("Total: $0.00");
    private final JLabel remainingLabel = new JLabel("Remaining Stock: 0");
    public WarehouseManager() {
        super("Warehouse Manager");
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.add(new JLabel("Receiving items:"));
        panel.add(receivingField);
        panel.add(new JLabel("Item price:"));
        panel.add(priceField);
        panel.add(new JLabel("Release items:"));
        panel.add(releasingField);
        JButton calculateButton = new JButton("Calculate Total");
        JButton releaseButton = new JButton("Release Items");
        panel.add(calculateButton);
        panel.add(totalLabel);
        panel.add(releaseButton);
        panel.add(remainingLabel);
        calculateButton.addActionListener(e -> calculateAndSave());
        releaseButton.addActionListener(e -> releaseItems());
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(440, 260);
        setLocationRelativeTo(null);
    }
    private void calculateAndSave() {
        try {
            int received = Integer.parseInt(receivingField.getText());
            double price = Double.parseDouble(priceField.getText());
            if (received < 0 || price < 0) {
                throw new IllegalArgumentException(
                "Quantity and price cannot be negative.");
            }
            stock += received;
            double total = received * price;
            totalLabel.setText(String.format("Total: $%.2f", total));
            remainingLabel.setText("Remaining Stock: " + stock);
            String sql = """
            INSERT INTO warehouse_data
            (received_items, item_price, total_price, remaining_stock)
            VALUES(?, ?, ?, ?)
            """;
            try(Connection connection = Db.open("warehouse_db");
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, received);
                ps.setDouble(2, price);
                ps.setDouble(3, total);
                ps.setInt(4, stock);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void releaseItems() {
        try {
            int released = Integer.parseInt(releasingField.getText());
            if (released < 0 || released > stock) {
                throw new IllegalArgumentException(
                "Invalid release quantity.");
            }
            stock -= released;
            remainingLabel.setText("Remaining Stock: " + stock);
            String sql = """
            UPDATE warehouse_data
            SET remaining_stock = ?
            ORDER BY id DESC
            LIMIT 1
            """;
            try(Connection connection = Db.open("warehouse_db");
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, stock);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        () -> new WarehouseManager().setVisible(true));
    }
}
