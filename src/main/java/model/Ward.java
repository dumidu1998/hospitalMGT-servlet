package model;

public class Ward {

	private int wardId;
	private String name;
	private int inchargeDoctorid;
	private String purpose;
	private int beds;
	private float rate;
	 
	public int getWardId() {
		return wardId;
	}
	public void setWardId(int wardId) {
		this.wardId = wardId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInchargeDoctorid() {
		return inchargeDoctorid;
	}
	public void setInchargeDoctorid(int inchargeDoctorid) {
		this.inchargeDoctorid = inchargeDoctorid;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	
}
