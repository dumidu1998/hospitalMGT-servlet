package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MedicineIssue;

public class medicineIssueDAO {
    public String table = "medicine_issue";
    Connection connection;

    public medicineIssueDAO(Connection connection) {
        this.connection = connection;
    }

    public int addData(MedicineIssue medicineIssue) {
        PreparedStatement ps = null;
        String query = "INSERT INTO medicine_issue (issue_id, hospitalization_id, medicine_id, qty) VALUES (NULL, "
                + medicineIssue.getHospitalizationId() + ", " + medicineIssue.getMedicineId() + ", "
                + medicineIssue.getQty() + ");";
        try {
            ps = connection.prepareStatement(query);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public MedicineIssue getAUserById(String id) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table + "  WHERE issue_id = " + id + ";";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            MedicineIssue medicineIssue = new MedicineIssue(rs.getInt("issue_id"), rs.getInt("hospitalization_id"),
                    rs.getInt("medicine_id"), rs.getInt("qty"));
            return medicineIssue;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getAll() {
        PreparedStatement ps = null;
        String query = "SELECT * FROM medicine_issue";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateUser(MedicineIssue medicineIssue) {
        PreparedStatement ps = null;
        String query = "UPDATE  medicine_issue SET hospitalization_id=" + medicineIssue.getHospitalizationId()
                + ",medicine_id=" + medicineIssue.getMedicineId() + ",qty=" + medicineIssue.getQty()
                + " WHERE issue_id=" + medicineIssue.getMedicineIssueId();
        try {
            ps = connection.prepareStatement(query);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public boolean del(String id) {
        PreparedStatement ps = null;
        String query = "DELETE FROM " + table + "  WHERE issue_id = " + id + ";";
        try {
            ps = connection.prepareStatement(query);
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
