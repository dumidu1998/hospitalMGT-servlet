package model;

public class Doctor {
	private int doctorId;
	private int branchId;
	private String name;
	private String specialization;
	private String sex;
	private String nIC;
	private String educationQualification;
	private String professionalQualification;
	private String address;
	private String mobileNo;
	private String email;
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getnIC() {
		return nIC;
	}
	public void setnIC(String nIC) {
		this.nIC = nIC;
	}
	public String getEducationQualification() {
		return educationQualification;
	}
	public void setEducationQualification(String educationQualification) {
		this.educationQualification = educationQualification;
	}
	public String getProfessionalQualification() {
		return professionalQualification;
	}
	public void setProfessionalQualification(String professionalQualification) {
		this.professionalQualification = professionalQualification;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
