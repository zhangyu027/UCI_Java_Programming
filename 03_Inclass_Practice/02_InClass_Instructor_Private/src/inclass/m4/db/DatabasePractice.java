package inclass.m4.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Instructor reference: SELECT records with JDBC. */
public class DatabasePractice {
    public static void main(String[] args) {
        String sql = "SELECT * FROM Students ORDER BY student_id";
        try(Connection connection = Db.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.println(
                resultSet.getInt("student_id") + " | "
                + resultSet.getString("first_name") + " | "
                + resultSet.getString("last_name") + " | "
                + resultSet.getString("email") + " | "
                + resultSet.getString("major"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
