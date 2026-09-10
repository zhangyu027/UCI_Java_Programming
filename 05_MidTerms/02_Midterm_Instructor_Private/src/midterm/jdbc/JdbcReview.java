package midterm.jdbc;

import java.sql.*;

public class JdbcReview {
    public static void main(String[]a) {
        String url="jdbc:mariadb://localhost:3306/University";
        System.out.println(url);
        System.out.println("Use DriverManager.getConnection(url, user, password)");
    }
}
