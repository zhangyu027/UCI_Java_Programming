package midterm.jdbc;

/*
* STUDENT STUDY GUIDE
* -------------------
* Review the JDBC sequence: Connection -> PreparedStatement/Statement -> ResultSet -> close resources. Identify the SQL parameters and result columns.
*
* CHECKPOINT:
* Be able to explain the key Java concept without reading the code line-by-line.
*/
import java.sql.*;

public class JdbcReview {
    public static void main(String[]a) {
        String url="jdbc:mariadb://localhost:3306/University";
        System.out.println(url);
        System.out.println("Use DriverManager.getConnection(url, user, password)");
    }
}