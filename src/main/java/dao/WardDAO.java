package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Ward;

public class WardDAO {
	public String table = "ward";
	Connection connection;

	public WardDAO(Connection connection) {
		this.connection = connection;
	}

	public int addData(Ward ward) {
		PreparedStatement ps = null;
		String query = "INSERT INTO ward (ward_id,name, doctor_incharge, purpose, beds, rate,branch_id) VALUES (NULL, '"
				+ ward.getName() + "', " + ward.getInchargeDoctorid() + ", '" + ward.getPurpose() + "', "
				+ ward.getBeds() + ", " + ward.getRate() + "," + ward.getBranch() + " );";
		try {
			ps = connection.prepareStatement(query);
			ps.executeUpdate();

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Ward getAUserById(String id) {
		PreparedStatement ps = null;
		String query = "SELECT * FROM " + table + "  WHERE ward_id = " + id + ";";
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Ward ward = new Ward(rs.getInt("ward_id"), rs.getString("name"), rs.getInt("doctor_incharge"),
					rs.getString("purpose"), rs.getInt("beds"), rs.getFloat("rate"), rs.getInt("branch_id"));
			return ward;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getAll() {
		PreparedStatement ps = null;
		String query = "SELECT *,doctor.name as dname FROM ward INNER JOIN branch ON ward.branch_id=branch.branch_id INNER JOIN doctor ON ward.doctor_incharge=doctor.doctor_id";
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
		String query = "SELECT *,doctor.name as dname FROM ward INNER JOIN branch ON ward.branch_id=branch.branch_id INNER JOIN doctor ON ward.doctor_incharge=doctor.doctor_id where ward.branch_id="
				+ idd;
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateUser(Ward ward) {
		PreparedStatement ps = null;
		String query = "UPDATE  ward SET name='" + ward.getName() + "',doctor_incharge=" + ward.getInchargeDoctorid()
				+ ", purpose='" + ward.getPurpose() + "',beds=" + ward.getBeds() + ",rate=" + ward.getRate()
				+ ",branch_id="+ward.getBranch()+" WHERE ward_id=" + ward.getWardId();
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
		String query = "DELETE FROM " + table + "  WHERE ward_id = " + id + ";";
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
