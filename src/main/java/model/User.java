package model;

public class User {
	private int userId;
	private int role;
	private String username;
	private String email;
	private String password;
	private int branchId;

	public User() {
	}

	public User(int userId, int role, String username, String email, String password, int branchId) {
		this.userId = userId;
		this.role = role;
		this.username = username;
		this.email = email;
		this.password = password;
		this.branchId = branchId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
