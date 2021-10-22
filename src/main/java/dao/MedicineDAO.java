package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Medicine;

public class MedicineDAO {
    public String table = "medicine";
    Connection connection;

    public MedicineDAO(Connection connection) {
        this.connection = connection;
    }

    public int addData(Medicine medicine) {
        PreparedStatement ps = null;
        String query = "INSERT INTO medicine (medicine_id, brand_name, medicine_name, type, price, remark) VALUES (NULL, '"
                + medicine.getBrandName() + "', '" + medicine.getMedicinename() + "', '" + medicine.getType() + "', "
                + medicine.getPrice() + ", '" + medicine.getRemark() + "');";
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

    public Medicine getAUserById(String id) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table + "  WHERE medicine_id = " + id + ";";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Medicine medicine = new Medicine(rs.getInt("medicine_id"), rs.getString("brand_name"),
                    rs.getString("medicine_name"), rs.getString("type"), rs.getFloat("price"), rs.getString("remark"));
            return medicine;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getAll() {
        PreparedStatement ps = null;
        String query = "SELECT * FROM medicine";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateUser(Medicine medicine) {
        PreparedStatement ps = null;
        String query = "UPDATE  medicine SET brand_name=" + medicine.getBrandName() + ",medicine_name='"
                + medicine.getMedicinename() + "',type='" + medicine.getType() + "',price='" + medicine.getPrice()
                + "',remark=" + medicine.getRemark() + " WHERE medicine_id=" + medicine.getMedicineId();
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
        String query = "DELETE FROM " + table + "  WHERE medicine_id = " + id + ";";
        try {
            ps = connection.prepareStatement(query);
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	public int updatePrice(int medid, float price) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
        String query = "UPDATE  medicine SET price='" + price
                + "' WHERE medicine_id=" + medid;
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

}
