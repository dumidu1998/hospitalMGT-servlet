package model;

public class Stock {
	private int stockId;
	private int medicineId;
	private int qty;
	private float unitPrice;
	private float total;
	private int branchId;

	public Stock(int stockId, int medicineId, int qty, float unitPrice, float total, int branchId) {
		this.stockId = stockId;
		this.medicineId = medicineId;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.total = total;
		this.branchId = branchId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
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

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
