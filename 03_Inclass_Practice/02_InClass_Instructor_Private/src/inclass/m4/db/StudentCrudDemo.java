package inclass.m4.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/** Instructor reference: console CRUD demonstration. */
public class StudentCrudDemo {
    public static void main(String[] args) {
        displayStudents();
        addStudent(1002, "Maria", "Lopez", "maria@uci.edu", "Data Science");
        displayStudents();
        updateStudent(1002, "Statistics");
        displayStudents();
        deleteStudent(1002);
        displayStudents();
    }
    public static void displayStudents() {
        String sql = "SELECT * FROM Students ORDER BY student_id";
        try(Connection conn = Db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Students ---");
            while (rs.next()) {
                System.out.println(
                rs.getInt("student_id") + " | "
                + rs.getString("first_name") + " | "
                + rs.getString("last_name") + " | "
                + rs.getString("email") + " | "
                + rs.getString("major"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addStudent(
    int id,
    String firstName,
    String lastName,
    String email,
    String major) {
        String sql = """
        INSERT INTO Students
        (student_id, first_name, last_name, email, major)
        VALUES(?, ?, ?, ?, ?)
        """;
        try(Connection conn = Db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            ps.setString(5, major);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateStudent(int id, String newMajor) {
        String sql = "UPDATE Students SET major = ? WHERE student_id = ?";
        try(Connection conn = Db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newMajor);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteStudent(int id) {
        String sql = "DELETE FROM Students WHERE student_id = ?";
        try(Connection conn = Db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
