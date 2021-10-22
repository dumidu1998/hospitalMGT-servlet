package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BranchTransfer;

public class BranchTransferDAO {

    public String table = "bill_payments";
    Connection connection;

    public BranchTransferDAO(Connection connection) {
        this.connection = connection;
    }

    public int addData(BranchTransfer branchTransfer) {
        PreparedStatement ps = null;
        String query = "INSERT INTO bill_payments (transfer_id, reason, transferred_branch, source_branch, appointed_doctor, remark) VALUES (NULL, "
                + branchTransfer.getReason() + ", " + branchTransfer.getTransferredBranch() + ", "
                + branchTransfer.getSourceBranch() + ", " + branchTransfer.getAppointedDoctor() + ", '"
                + branchTransfer.getRemark() + "');";
        try {
            ps = connection.prepareStatement(query);
            ps.executeUpdate();

            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public BranchTransfer getADoctorById(String id) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table + "  WHERE payment_id = " + id + ";";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            BranchTransfer branchTransfer = new BranchTransfer(rs.getInt("transfer_id"),rs.getInt("hospitalization_id"), rs.getString("reason"),
                    rs.getDate("date"), rs.getInt("transferred_branch"), rs.getInt("source_branch"),
                    rs.getInt("appointed_doctor"), rs.getString("remark"));
            return branchTransfer;

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

    public int updateUser(BranchTransfer branchTransfer) {
        PreparedStatement ps = null;
        String query = "UPDATE  bill_payments SET reason='" + branchTransfer.getReason() + "',transferred_branch="
                + branchTransfer.getTransferredBranch() + ",source_branch=" + branchTransfer.getSourceBranch()
                + ",appointed_doctor=" + branchTransfer.getAppointedDoctor() + ",remark='" + branchTransfer.getRemark()
                + "' WHERE transfer_id=" + branchTransfer.getTransferId();
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
        String query = "DELETE FROM " + table + "  WHERE transfer_id = " + id + ";";
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
