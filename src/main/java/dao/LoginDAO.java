package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class LoginDAO {
    public String table = "user";
    Connection connection;

    public LoginDAO(Connection connection) {
        this.connection = connection;
    }

    public int checkLogin(String username, String password) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table + "  WHERE username = '" + username + "'' AND password='" + password
                + "';";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
            }
            if (i >= 1) {
                return 1;
            } else
                return 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
