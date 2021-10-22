package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.PatientHospitalization;

public class PatientHospitalizationDAO {
	public String table = "pati_hospitalization";
	Connection connection;

	public PatientHospitalizationDAO(Connection connection) {
		this.connection = connection;
	}

	public int addData(PatientHospitalization patientHospitalization) {
		PreparedStatement ps = null;
		String query = "INSERT INTO pati_hospitalization (hospitalization_id,patient_id, reason, doctor_incharge, ward_id, remark,branch_id) VALUES (NULL, "
				+ patientHospitalization.getPatientId() + ", '" + patientHospitalization.getReason() + "', "
				+ patientHospitalization.getDoctorInChargeId() + ", " + patientHospitalization.getWardId() + ", '"
				+ patientHospitalization.getRemark() + "'," + patientHospitalization.getBranchId() + " );";
		try {
			ps = connection.prepareStatement(query);
			ps.executeUpdate();

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getUserName(int id) {
		PreparedStatement ps = null;
		String query = "SELECT * FROM pati_hospitalization ph INNER JOIN patient p ON p.patient_id=ph.patient_id WHERE hospitalization_id = " + id + ";";
		
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString("name");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return " ";
	}

	public PatientHospitalization getAUserById(String id) {
		PreparedStatement ps = null;
		String query = "SELECT * FROM pati_hospitalization ph INNER JOIN patient p ON p.patient_id=ph.patient_id WHERE hospitalization_id = " + id + ";";
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			rs.next();
			PatientHospitalization patientHospitalization = new PatientHospitalization(rs.getInt("hospitalization_id"),
					rs.getInt("patient_id"), rs.getString("reason"), rs.getInt("doctor_incharge"),
					rs.getDate("date_admitted"), rs.getDate("discharged_date"), rs.getInt("ward_id"),
					rs.getInt("no_of_days"), rs.getString("remark"), rs.getInt("branch_id"));
			return patientHospitalization;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getAll() {
		PreparedStatement ps = null;
		String query = "SELECT *,w.name as ward_name,pa.name as p_name FROM pati_hospitalization p INNER JOIN ward w ON w.ward_id=p.ward_id INNER JOIN branch b ON b.branch_id=p.branch_id INNER JOIN patient pa ON pa.patient_id=p.patient_id";
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
		String query = "SELECT *,w.name as ward_name,pa.name as p_name FROM pati_hospitalization p INNER JOIN ward w ON w.ward_id=p.ward_id INNER JOIN branch b ON b.branch_id=p.branch_id INNER JOIN patient pa ON pa.patient_id=p.patient_id WHERE p.branch_id="
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

	public int updateUser(PatientHospitalization patientHospitalization) {
		PreparedStatement ps = null;
		String query = "UPDATE  pati_hospitalization SET patient_id=" + patientHospitalization.getPatientId()
				+ ", reason='" + patientHospitalization.getReason() + "'',doctor_incharge="
				+ patientHospitalization.getDoctorInChargeId() + ", date_admitted='"
				+ patientHospitalization.getAdmittedDate() + "',discharged_date='"
				+ patientHospitalization.getDischargedDate() + "'',ward_id=" + patientHospitalization.getWardId()
				+ ", no_of_days=" + patientHospitalization.getNoOfDays() + ", remark='"
				+ patientHospitalization.getRemark() + "'', branch_id=" + patientHospitalization.getBranchId()
				+ " WHERE hospitalization_id=" + patientHospitalization.getHospitalizationId();
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
		String query = "DELETE FROM " + table + "  WHERE hospitalization_id = " + id + ";";
		try {
			ps = connection.prepareStatement(query);
			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void updateBranch(int patient, int branch, int doctor) {
		PreparedStatement ps = null;
		String query = "UPDATE  pati_hospitalization SET doctor_incharge=" + doctor + " , branch_id=" + branch
				+ " WHERE hospitalization_id=" + patient;
		try {
			ps = connection.prepareStatement(query);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
