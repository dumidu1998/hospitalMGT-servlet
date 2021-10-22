package model;

import java.util.Date;

public class BranchTransfer {

	private int transferId;
	private String reason;
	private Date dateofTransfer;
	private int transferredBranch;
	private int sourceBranch;
	private int appointedDoctor;
	private String remark;
	private int hospitalizationId;

	public BranchTransfer(int transferId, int hospitalizationId, String reason, Date dateofTransfer,
			int transferredBranch, int sourceBranch, int appointedDoctor, String remark) {
		this.transferId = transferId;
		this.reason = reason;
		this.dateofTransfer = dateofTransfer;
		this.transferredBranch = transferredBranch;
		this.sourceBranch = sourceBranch;
		this.appointedDoctor = appointedDoctor;
		this.remark = remark;
		this.hospitalizationId = hospitalizationId;
	}

	public int getSourceBranch() {
		return sourceBranch;
	}

	public int getHospitalizationId() {
		return hospitalizationId;
	}

	public void setHospitalizationId(int hospitalizationId) {
		this.hospitalizationId = hospitalizationId;
	}

	public void setSourceBranch(int sourceBranch) {
		this.sourceBranch = sourceBranch;
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDateofTransfer() {
		return dateofTransfer;
	}

	public void setDateofTransfer(Date dateofTransfer) {
		this.dateofTransfer = dateofTransfer;
	}

	public int getTransferredBranch() {
		return transferredBranch;
	}

	public void setTransferredBranch(int transferredBranch) {
		this.transferredBranch = transferredBranch;
	}

	public int getAppointedDoctor() {
		return appointedDoctor;
	}

	public void setAppointedDoctor(int appointedDoctor) {
		this.appointedDoctor = appointedDoctor;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
