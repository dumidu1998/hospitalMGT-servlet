package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BillPayment;

public class BillPaymentDAO {

    public String table = "bill_payments";
    Connection connection;

    public BillPaymentDAO(Connection connection) {
        this.connection = connection;
    }

    public int addData(BillPayment billPayment) {
        PreparedStatement ps = null;
        String query = "INSERT INTO bill_payments (payment_id, hosipitalization_id, doctor_fee, hospital_fee, total_medicine_fee, grand_total, remark) VALUES (NULL, "
                + billPayment.getHospitalizationId() + ", " + billPayment.getDoctorFee() + ", "
                + billPayment.getHospitalFee() + ", " + billPayment.getTotalMedicineFee() + ", "
                + billPayment.getGrandTotal() + ", '" + billPayment.getRemark() + "');";
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

    public BillPayment getADoctorById(String id) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table + "  WHERE payment_id = " + id + ";";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            BillPayment billPayment = new BillPayment(rs.getInt("payment_id"), rs.getInt("hosipitalization_id"),
                    rs.getFloat("doctor_fee"), rs.getFloat("hospital_fee"), rs.getFloat("total_medicine_fee"),
                    rs.getFloat("grand_total"), rs.getString("remark"));
            return billPayment;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getAll() {
        PreparedStatement ps = null;
        String query = "SELECT * FROM bill_payments";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateUser(BillPayment billPayment) {
        PreparedStatement ps = null;
        String query = "UPDATE  bill_payments SET hosipitalization_id=" + billPayment.getHospitalizationId()
                + ",doctor_fee=" + billPayment.getDoctorFee() + ",hospital_fee=" + billPayment.getHospitalFee()
                + ",total_medicine_fee=" + billPayment.getTotalMedicineFee() + ",grand_total="
                + billPayment.getGrandTotal() + ",remark='" + billPayment.getRemark() + "' WHERE payment_id="
                + billPayment.getBillId();
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
        String query = "DELETE FROM " + table + "  WHERE payment_id = " + id + ";";
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
