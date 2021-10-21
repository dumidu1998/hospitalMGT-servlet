package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Doctor;

public class DoctorDAO {

    public String table = "doctor";
    Connection connection;

    public DoctorDAO(Connection connection) {
        this.connection = connection;
    }

    public int addData(Doctor doctor) {
        PreparedStatement ps = null;
        String query = "INSERT INTO doctor (doctor_id, branch_id, name, specialization, sex, nic, education_qualification, professional_qualification, address, mobile, email) VALUES (NULL, "
                + doctor.getBranchId() + ", '" + doctor.getName() + "', '" + doctor.getSpecialization() + "', '"
                + doctor.getSex() + "', '" + doctor.getnIC() + "', '" + doctor.getEducationQualification() + "', '"
                + doctor.getProfessionalQualification() + "', '" + doctor.getAddress() + "', '" + doctor.getMobileNo()
                + "', '" + doctor.getEmail() + "');";
        try {
            ps = connection.prepareStatement(query);
            ps.executeUpdate();

            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public Doctor getADoctorById(String id) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table + "  WHERE doctor_id = " + id + ";";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Doctor doctor = new Doctor(rs.getInt("doctor_id"), rs.getInt("branch_id"), rs.getString("name"),
                    rs.getString("specialization"), rs.getString("sex"), rs.getString("nic"),
                    rs.getString("education_qualification"), rs.getString("professional_qualification"),
                    rs.getString("address"), rs.getString("mobile"), rs.getString("email"));
            return doctor;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getAll() {
        PreparedStatement ps = null;
        String query = "SELECT * FROM doctor d INNER JOIN branch b ON b.branch_id=d.branch_id";
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
        String query = "SELECT * FROM doctor d INNER JOIN branch b ON b.branch_id=d.branch_id WHERE d.branch_id="+idd;
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateUser(Doctor doctor) {
        PreparedStatement ps = null;
        String query = "UPDATE  doctor SET branch_id=" + doctor.getBranchId() + ",name='" + doctor.getName()
                + "',specialization='" + doctor.getSpecialization() + "',sex='" + doctor.getSex() + "',nic='"
                + doctor.getnIC() + "',education_qualification='" + doctor.getEducationQualification()
                + "',professional_qualification='" + doctor.getProfessionalQualification() + "',address='"
                + doctor.getAddress() + "',mobile='" + doctor.getMobileNo() + "',email='" + doctor.getEmail()
                + "' WHERE doctor_id=" + doctor.getDoctorId();
        try {
            ps = connection.prepareStatement(query);
            ps.executeUpdate();

            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public boolean del(String id) {
        PreparedStatement ps = null;
        String query = "DELETE FROM " + table + "  WHERE doctor_id = " + id + ";";
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
