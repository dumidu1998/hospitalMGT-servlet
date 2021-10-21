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

	public User checkLogin(String username, String password) {
		PreparedStatement ps = null;
		String query = "SELECT * FROM " + table + "  WHERE username = '" + username + "' AND password='" + password
				+ "';";
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				i++;
			}
			if (i == 1) {
				ResultSet rs2 = ps.executeQuery();
				rs2.next();
				return new User(rs2.getInt("user_id"), rs2.getInt("role"), rs2.getString("username"),
						rs2.getString("email"), rs2.getString("password"), rs2.getInt("branch_id"));
			} else
				return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
