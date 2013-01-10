package th.co.aoe.imake.pst.backoffice.form;

import java.io.Serializable;

import th.co.aoe.imake.pst.xstream.PstJob;

public class JobForm extends CommonForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PstJob pstJob;
	private String pjIdArray;
	private String prpNo;
	private String pjCreatedTime;
	public JobForm() {
		//super();
		this.pstJob = new PstJob();
	}
	public PstJob getPstJob() {
		return pstJob;
	}
	public void setPstJob(PstJob pstJob) {
		this.pstJob = pstJob;
	}
	public String getPjIdArray() {
		return pjIdArray;
	}
	public void setPjIdArray(String pjIdArray) {
		this.pjIdArray = pjIdArray;
	}
	public String getPrpNo() {
		return prpNo;
	}
	public void setPrpNo(String prpNo) {
		this.prpNo = prpNo;
	}
	public String getPjCreatedTime() {
		return pjCreatedTime;
	}
	public void setPjCreatedTime(String pjCreatedTime) {
		this.pjCreatedTime = pjCreatedTime;
	}
	
	//pstEmployeeStatus=new PstEmployeeStatus();
}
