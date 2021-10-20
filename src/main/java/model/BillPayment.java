package model;

public class BillPayment {
	private int billId;
	private int hospitalizationId;
	private float doctorFee;
	private float HospitalFee;
	private float totalMedicineFee;
	private float grandTotal;
	private String remark;

	public BillPayment(int billId, int hospitalizationId, float doctorFee, float hospitalFee, float totalMedicineFee,
			float grandTotal, String remark) {
		this.billId = billId;
		this.hospitalizationId = hospitalizationId;
		this.doctorFee = doctorFee;
		HospitalFee = hospitalFee;
		this.totalMedicineFee = totalMedicineFee;
		this.grandTotal = grandTotal;
		this.remark = remark;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getHospitalizationId() {
		return hospitalizationId;
	}

	public void setHospitalizationId(int hospitalizationId) {
		this.hospitalizationId = hospitalizationId;
	}

	public float getDoctorFee() {
		return doctorFee;
	}

	public void setDoctorFee(float doctorFee) {
		this.doctorFee = doctorFee;
	}

	public float getHospitalFee() {
		return HospitalFee;
	}

	public void setHospitalFee(float hospitalFee) {
		HospitalFee = hospitalFee;
	}

	public float getTotalMedicineFee() {
		return totalMedicineFee;
	}

	public void setTotalMedicineFee(float totalMedicineFee) {
		this.totalMedicineFee = totalMedicineFee;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
