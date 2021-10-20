package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	public String table = "user";
	Connection connection;

	public UserDAO(Connection connection) {
		this.connection = connection;
	}

	public int addData(User user) {
		PreparedStatement ps = null;
		String query = "INSERT INTO user (user_id, role, username, email, password, branch_id) VALUES (NULL, "
				+ user.getRole() + ", '" + user.getUsername() + "', '" + user.getEmail() + "', '" + user.getPassword()
				+ "', '" + user.getBranchId() + "');";
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

	public User getAUserById(String id) {
		PreparedStatement ps = null;
		String query = "SELECT * FROM " + table + "  WHERE user_id = " + id + ";";
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			User user = new User(rs.getInt("user_id"), rs.getInt("role"), rs.getString("username"),
					rs.getString("email"), rs.getString("password"), rs.getInt("branch_id"));
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getAll() {
		PreparedStatement ps = null;
		String query = "SELECT * FROM user";
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateUser(User user) {
		PreparedStatement ps = null;
		String query = "UPDATE  user SET role=" + user.getRole() + ",username='" + user.getUsername() + "',email='"
				+ user.getEmail() + "',password='" + user.getPassword() + "',branch_id=" + user.getBranchId()
				+ " WHERE user_id=" + user.getUserId();
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
		String query = "DELETE FROM " + table + "  WHERE user_id = " + id + ";";
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
