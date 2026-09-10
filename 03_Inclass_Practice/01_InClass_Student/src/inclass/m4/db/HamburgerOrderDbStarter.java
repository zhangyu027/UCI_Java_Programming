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
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/** Student starter: persist hamburger orders in hamburger_db. */
public class HamburgerOrderDbStarter extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JTextArea outputArea = new JTextArea();
    public HamburgerOrderDbStarter() {
        super("Hamburger Order - JDBC Starter");
        JPanel buttons = new JPanel();
        buttons.add(new JButton("Place Order"));
        buttons.add(new JButton("View History"));
        buttons.add(new JButton("Cancel Order"));
        outputArea.setEditable(false);
        add(buttons, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        // TODO: Add ActionListeners.
        // TODO: Insert orders with PreparedStatement.
        // TODO: Display order history with SELECT + ResultSet.
        // TODO: Cancel an order with DELETE.
        // HINT: Db.open("hamburger_db")
        // HINT INSERT columns:
        // customer_name, burger_type, order_date
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 400);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        () -> new HamburgerOrderDbStarter().setVisible(true));
    }
}
