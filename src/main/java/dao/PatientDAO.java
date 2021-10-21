package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Patient;

public class PatientDAO {
    public String table = "patient";
    Connection connection;

    public PatientDAO(Connection connection) {
        this.connection = connection;
    }

    public int addData(Patient patient) {
        PreparedStatement ps = null;
        String query = "INSERT INTO patient (patient_id, name, dob, sex, nic, age, address, mobile, email) VALUES (NULL, '"
                + patient.getName() + "', '" + patient.getdOB() + "', '" + patient.getSex() + "', '" + patient.getnIC()
                + "', " + patient.getAge() + ", '" + patient.getAddress() + "','" + patient.getMobileNo() + "','"
                + patient.getEmail() + "' );";
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

    public Patient getAUserById(String id) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table + "  WHERE patient_id = " + id + ";";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Patient patient = new Patient(rs.getInt("patient_id"), rs.getString("name"), rs.getDate("dob"),
                    rs.getString("sex"), rs.getString("nic"), rs.getInt("age"), rs.getString("address"),
                    rs.getString("mobile"), rs.getString("email"));
            return patient;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getAll() {
        PreparedStatement ps = null;
        String query = "SELECT * FROM patient";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet getAllbyBranch(int idd) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM patient";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateUser(Patient patient) {
        PreparedStatement ps = null;
        String query = "UPDATE  patient SET name='" + patient.getName() + "',dob='" + patient.getdOB() + "',sex='"
                + patient.getSex() + "',nic='" + patient.getnIC() + "',age=" + patient.getAge() + ",address='"
                + patient.getAddress() + "',mobile='" + patient.getMobileNo() + "',email='" + patient.getEmail()
                + "' WHERE patient_id=" + patient.getPatientId();
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
        String query = "DELETE FROM " + table + "  WHERE patient_id = " + id + ";";
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
