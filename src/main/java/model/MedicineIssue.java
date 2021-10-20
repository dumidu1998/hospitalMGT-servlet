package model;

public class MedicineIssue {
	private int medicineIssueId;
	private int hospitalizationId;
	private int medicineId;
	private int qty;

	public MedicineIssue(int medicineIssueId, int hospitalizationId, int medicineId, int qty) {
		this.medicineIssueId = medicineIssueId;
		this.hospitalizationId = hospitalizationId;
		this.medicineId = medicineId;
		this.qty = qty;
	}

	public int getMedicineIssueId() {
		return medicineIssueId;
	}

	public void setMedicineIssueId(int medicineIssueId) {
		this.medicineIssueId = medicineIssueId;
	}

	public int getHospitalizationId() {
		return hospitalizationId;
	}

	public void setHospitalizationId(int hospitalizationId) {
		this.hospitalizationId = hospitalizationId;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
