package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Branch;

public class BranchDAO {
	public String table = "branch";
	Connection connection;

	public BranchDAO(Connection connection) {
		this.connection = connection;
	}

	public int addData(Branch branch) {
		PreparedStatement ps = null;
		String query = "INSERT INTO branch (branch_id, branch_name) VALUES (NULL, '" + branch.getBranchName() + "')";
		try {
			ps = connection.prepareStatement(query);
			ps.executeUpdate();

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public ResultSet getAll() {
		PreparedStatement ps = null;
		String query = "SELECT * FROM branch";
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateUser(Branch branch) {
		PreparedStatement ps = null;
		String query = "UPDATE branch SET branch_name='" + branch.getBranchName() + "' WHERE branch_id="
				+ branch.getBranchId();
		try {
			ps = connection.prepareStatement(query);
			ps.executeUpdate();

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public Branch getABranchById(String id) {
		PreparedStatement ps = null;
		String query = "SELECT * FROM " + table + "  WHERE branch_id = " + id + ";";
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Branch branch = new Branch(rs.getInt("branch_id"), rs.getString("branch_name"));
			return branch;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean del(String id) {
		PreparedStatement ps = null;
		String query = "DELETE FROM " + table + "  WHERE branch_id = " + id + ";";
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
