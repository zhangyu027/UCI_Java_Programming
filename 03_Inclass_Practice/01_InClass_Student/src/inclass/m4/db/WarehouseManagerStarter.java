package inclass.m4.db;

/*
* IN-CLASS STUDENT HINTS - JDBC
* -----------------------------
* First checkpoint: DatabaseConnectionTest must connect successfully.
*
* Shared helper:
* - Db.getConnection() opens the default University database connection.
* - Db.open() is a compatibility alias.
* - Some examples may use Db.open(databaseName) for another practice database.
*
* JDBC STEPS:
* Connection -> PreparedStatement -> set parameters -> execute -> ResultSet
*
* Keep SQL values parameterized with ? placeholders.
*/
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Student starter: warehouse calculation + persistence. */
public class WarehouseManagerStarter extends JFrame {
    private static final long serialVersionUID = 1L;
    public WarehouseManagerStarter() {
        super("Warehouse Manager Starter");
        JTextField receivingField = new JTextField(8);
        JTextField priceField = new JTextField(8);
        JTextField releasingField = new JTextField(8);
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.add(new JLabel("Receiving items:"));
        panel.add(receivingField);
        panel.add(new JLabel("Item price:"));
        panel.add(priceField);
        panel.add(new JLabel("Release items:"));
        panel.add(releasingField);
        panel.add(new JButton("Calculate Total"));
        panel.add(new JLabel("Total: $0.00"));
        panel.add(new JButton("Release Items"));
        panel.add(new JLabel("Remaining Stock: 0"));
        // TODO: Calculate received quantity * price.
        // TODO: Track remaining stock.
        // TODO: Validate release quantity.
        // TODO: Save/update records using Db.open("warehouse_db").
        // HINT table: warehouse_data
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(440, 260);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        () -> new WarehouseManagerStarter().setVisible(true));
    }
}
