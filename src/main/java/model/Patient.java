package model;

import java.util.Date;

public class Patient {

	private int patientId;
	private String name;
	private Date dOB;
	private String sex;
	private String nIC;
	private int age;
	private String address;
	private String mobileNo;
	private String email;

	public Patient(int patientId, String name, Date dOB, String sex, String nIC, int age, String address,
			String mobileNo, String email) {
		this.patientId = patientId;
		this.name = name;
		this.dOB = dOB;
		this.sex = sex;
		this.nIC = nIC;
		this.age = age;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public String getnIC() {
		return nIC;
	}

	public void setnIC(String nIC) {
		this.nIC = nIC;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
