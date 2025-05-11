package dao;

import model.Internship;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InternshipDAO {

    // Existing addInternship(...) here…

    /** Return a list of all internships in the DB */
    public static List<Internship> getAllInternships() {
        List<Internship> list = new ArrayList<>();
        String sql = "SELECT id, title, description, company_id, deadline FROM internships";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Internship(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("company_id"),
                    rs.getString("deadline")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean addInternship(Internship internship) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
