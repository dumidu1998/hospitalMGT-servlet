package model;

public class Branch {
	private int bId;
	private String branchName;

	public Branch(int bId, String branchName) {
		this.bId = bId;
		this.branchName = branchName;
	}

	public int getBranchId() {
		return bId;
	}

	public void setBranchId(int branchId) {
		this.bId = bId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
