package dao;

import model.Application;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {

    /** Insert a new application into the DB */
    public static boolean addApplication(Application application) {
        String sql = "INSERT INTO applications (student_id, internship_id, cover_letter, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, application.getStudentId());
            stmt.setInt(2, application.getInternshipId());
            stmt.setString(3, application.getCoverLetter());
            stmt.setString(4, "Pending");

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /** Fetch all applications (for viewApplications.jsp) */
    public static List<Application> getApplications() {
        List<Application> list = new ArrayList<>();
        String sql = "SELECT s.name AS student_name, i.title AS internship_title, a.status " +
                     "FROM applications a " +
                     "JOIN users s ON a.student_id = s.user_id " +
                     "JOIN internships i ON a.internship_id = i.id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Application(
                    rs.getString("student_name"),
                    rs.getString("internship_title"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
