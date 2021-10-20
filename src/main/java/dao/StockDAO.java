package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Stock;

public class StockDAO {
    public String table = "stock";
    Connection connection;

    public StockDAO(Connection connection) {
        this.connection = connection;
    }

    public int addData(Stock stock) {
        PreparedStatement ps = null;
        String query = "INSERT INTO stock (stock_id,medicine_id, qty, unit_pirce, total, branch_id) VALUES (NULL, "
                + stock.getMedicineId() + ", " + stock.getQty() + ", " + stock.getUnitPrice() + ", " + stock.getTotal()
                + ", " + stock.getBranchId() + " );";
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

    public Stock getAUserById(String id) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table + "  WHERE stock_id = " + id + ";";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Stock stock = new Stock(rs.getInt("stock_id"), rs.getInt("medicine_id"), rs.getInt("qty"),
                    rs.getFloat("unit_pirce"), rs.getFloat("total"), rs.getInt("branch_id"));
            return stock;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getAll() {
        PreparedStatement ps = null;
        String query = "SELECT * FROM stock";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateUser(Stock stock) {
        PreparedStatement ps = null;
        String query = "UPDATE stock SET medicine_id=" + stock.getMedicineId() + ",qty=" + stock.getQty()
                + ", unit_pirce=" + stock.getUnitPrice() + ",total=" + stock.getTotal() + ",branch_id="
                + stock.getBranchId() + " WHERE stock_id=" + stock.getStockId();
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
        String query = "DELETE FROM " + table + "  WHERE stock_id = " + id + ";";
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
