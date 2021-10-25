package model;

import java.util.Date;

public class PatientHospitalization {

	private int hospitalizationId;
	private int patientId;
	private String reason;
	private int doctorInChargeId;
	private Date admittedDate;
	private Date dischargedDate;
	private int wardId;
	private int noOfDays;
	private String remark;
	private int branchId;

	//Parameterized COnstructor
	public PatientHospitalization(int hospitalizationId, int patientId, String reason, int doctorInChargeId,
			Date admittedDate, Date dischargedDate, int wardId, int noOfDays, String remark, int branchId) {
		this.hospitalizationId = hospitalizationId;
		this.patientId = patientId;
		this.reason = reason;
		this.doctorInChargeId = doctorInChargeId;
		this.admittedDate = admittedDate;
		this.dischargedDate = dischargedDate;
		this.wardId = wardId;
		this.noOfDays = noOfDays;
		this.remark = remark;
		this.branchId = branchId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getHospitalizationId() {
		return hospitalizationId;
	}

	public void setHospitalizationId(int hospitalizationId) {
		this.hospitalizationId = hospitalizationId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getDoctorInChargeId() {
		return doctorInChargeId;
	}

	public void setDoctorInChargeId(int doctorInChargeId) {
		this.doctorInChargeId = doctorInChargeId;
	}

	public Date getAdmittedDate() {
		return admittedDate;
	}

	public void setAdmittedDate(Date admittedDate) {
		this.admittedDate = admittedDate;
	}

	public Date getDischargedDate() {
		return dischargedDate;
	}

	public void setDischargedDate(Date dischargedDate) {
		this.dischargedDate = dischargedDate;
	}

	public int getWardId() {
		return wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
