package model;

public class Medicine {
	private int medicineId;
	private String brandName;
	private String Medicinename;
	private String type;
	private float price;
	private String remark;

	public Medicine(int medicineId, String brandName, String medicinename, String type, float price, String remark) {
		this.medicineId = medicineId;
		this.brandName = brandName;
		Medicinename = medicinename;
		this.type = type;
		this.price = price;
		this.remark = remark;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getMedicinename() {
		return Medicinename;
	}

	public void setMedicinename(String medicinename) {
		Medicinename = medicinename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
