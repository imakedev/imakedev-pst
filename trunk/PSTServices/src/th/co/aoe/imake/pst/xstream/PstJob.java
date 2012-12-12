package th.co.aoe.imake.pst.xstream;

import java.io.Serializable;
import java.sql.Timestamp;

import th.co.aoe.imake.pst.xstream.common.VServiceXML;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * The persistent class for the PST_JOB database table.
 * 
 */
@XStreamAlias("PstJob")
public class PstJob  extends VServiceXML implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long pjId;

	private String pjContractMobileNo;

	private String pjContractName;

	private Timestamp pjCreatedTime;

	private String pjCustomerDepartment;

	private String pjCustomerName;

	private String pjCustomerNo;

	private String pjJobNo;

	
	private Timestamp pjUpdatedTime;

	//bi-directional many-to-one association to PstConcrete
	@XStreamAlias("pstConcrete")
	private PstConcrete pstConcrete;

	//bi-directional many-to-one association to PstJobEmployee
	/*@OneToMany(mappedBy="pstJob")
	private List<PstJobEmployee> pstJobEmployees;*/

	//bi-directional one-to-one association to PstJobPay
	@XStreamAlias("pstJobPay")
	private PstJobPay pstJobPay;

	//bi-directional one-to-one association to PstJobPayExt
	@XStreamAlias("pstJobPayExt")
	private PstJobPayExt pstJobPayExt;

	//bi-directional one-to-one association to PstJobWork
	@XStreamAlias("pstJobWork")
	private PstJobWork pstJobWork;

	public PstJob() {
	}

	public PstJob(Long pjId, String pjContractMobileNo, String pjContractName,
			Timestamp pjCreatedTime, String pjCustomerDepartment,
			String pjCustomerName, String pjCustomerNo, String pjJobNo,
			Timestamp pjUpdatedTime, PstConcrete pstConcrete,
			PstJobPay pstJobPay, PstJobPayExt pstJobPayExt,
			PstJobWork pstJobWork) {
		super();
		this.pjId = pjId;
		this.pjContractMobileNo = pjContractMobileNo;
		this.pjContractName = pjContractName;
		this.pjCreatedTime = pjCreatedTime;
		this.pjCustomerDepartment = pjCustomerDepartment;
		this.pjCustomerName = pjCustomerName;
		this.pjCustomerNo = pjCustomerNo;
		this.pjJobNo = pjJobNo;
		this.pjUpdatedTime = pjUpdatedTime;
		this.pstConcrete = pstConcrete;
		this.pstJobPay = pstJobPay;
		this.pstJobPayExt = pstJobPayExt;
		this.pstJobWork = pstJobWork;
	}

	public Long getPjId() {
		return this.pjId;
	}

	public void setPjId(Long pjId) {
		this.pjId = pjId;
	}

	public String getPjContractMobileNo() {
		return this.pjContractMobileNo;
	}

	public void setPjContractMobileNo(String pjContractMobileNo) {
		this.pjContractMobileNo = pjContractMobileNo;
	}

	public String getPjContractName() {
		return this.pjContractName;
	}

	public void setPjContractName(String pjContractName) {
		this.pjContractName = pjContractName;
	}

	public Timestamp getPjCreatedTime() {
		return this.pjCreatedTime;
	}

	public void setPjCreatedTime(Timestamp pjCreatedTime) {
		this.pjCreatedTime = pjCreatedTime;
	}

	public String getPjCustomerDepartment() {
		return this.pjCustomerDepartment;
	}

	public void setPjCustomerDepartment(String pjCustomerDepartment) {
		this.pjCustomerDepartment = pjCustomerDepartment;
	}

	public String getPjCustomerName() {
		return this.pjCustomerName;
	}

	public void setPjCustomerName(String pjCustomerName) {
		this.pjCustomerName = pjCustomerName;
	}

	public String getPjCustomerNo() {
		return this.pjCustomerNo;
	}

	public void setPjCustomerNo(String pjCustomerNo) {
		this.pjCustomerNo = pjCustomerNo;
	}

	public String getPjJobNo() {
		return this.pjJobNo;
	}

	public void setPjJobNo(String pjJobNo) {
		this.pjJobNo = pjJobNo;
	}

	public Timestamp getPjUpdatedTime() {
		return this.pjUpdatedTime;
	}

	public void setPjUpdatedTime(Timestamp pjUpdatedTime) {
		this.pjUpdatedTime = pjUpdatedTime;
	}

	public PstConcrete getPstConcrete() {
		return this.pstConcrete;
	}

	public void setPstConcrete(PstConcrete pstConcrete) {
		this.pstConcrete = pstConcrete;
	}

	/*public List<PstJobEmployee> getPstJobEmployees() {
		return this.pstJobEmployees;
	}

	public void setPstJobEmployees(List<PstJobEmployee> pstJobEmployees) {
		this.pstJobEmployees = pstJobEmployees;
	}*/

	public PstJobPay getPstJobPay() {
		return this.pstJobPay;
	}

	public void setPstJobPay(PstJobPay pstJobPay) {
		this.pstJobPay = pstJobPay;
	}

	public PstJobPayExt getPstJobPayExt() {
		return this.pstJobPayExt;
	}

	public void setPstJobPayExt(PstJobPayExt pstJobPayExt) {
		this.pstJobPayExt = pstJobPayExt;
	}

	public PstJobWork getPstJobWork() {
		return this.pstJobWork;
	}

	public void setPstJobWork(PstJobWork pstJobWork) {
		this.pstJobWork = pstJobWork;
	}

}