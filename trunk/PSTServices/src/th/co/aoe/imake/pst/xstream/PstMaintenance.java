package th.co.aoe.imake.pst.xstream;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import th.co.aoe.imake.pst.xstream.common.VServiceXML;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * The persistent class for the PST_MAINTENANCE database table.
 * 
 */
@XStreamAlias("PstMaintenance")
public class PstMaintenance extends VServiceXML implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long pcmType;

	private String pmaintenanceRefNo;

	private java.util.Date pmaintenanceCheckTime;

	private Long pdId;

	private Long pwtId;

	private String pmaintenanceDocNo;

	private BigDecimal pmaintenanceHoursOfWork;

	private BigDecimal pmaintenanceMile;

	private String pmaintenanceStatus;

	//bi-directional many-to-one association to PstDepartment
	@XStreamAlias("pstDepartment")
	private PstDepartment pstDepartment;

	//bi-directional many-to-one association to PstWorkType
	@XStreamAlias("pstWorkType")
	private PstWorkType pstWorkType;

	public PstMaintenance() {
	}

	 

	public PstMaintenance(Long pcmType, String pmaintenanceRefNo,
			Date pmaintenanceCheckTime, Long pdId, Long pwtId,
			String pmaintenanceDocNo, BigDecimal pmaintenanceHoursOfWork,
			BigDecimal pmaintenanceMile, String pmaintenanceStatus,
			PstDepartment pstDepartment, PstWorkType pstWorkType) {
		super();
		this.pcmType = pcmType;
		this.pmaintenanceRefNo = pmaintenanceRefNo;
		this.pmaintenanceCheckTime = pmaintenanceCheckTime;
		this.pdId = pdId;
		this.pwtId = pwtId;
		this.pmaintenanceDocNo = pmaintenanceDocNo;
		this.pmaintenanceHoursOfWork = pmaintenanceHoursOfWork;
		this.pmaintenanceMile = pmaintenanceMile;
		this.pmaintenanceStatus = pmaintenanceStatus;
		this.pstDepartment = pstDepartment;
		this.pstWorkType = pstWorkType;
	}



	public String getPmaintenanceDocNo() {
		return this.pmaintenanceDocNo;
	}

	public void setPmaintenanceDocNo(String pmaintenanceDocNo) {
		this.pmaintenanceDocNo = pmaintenanceDocNo;
	}

	public BigDecimal getPmaintenanceHoursOfWork() {
		return this.pmaintenanceHoursOfWork;
	}

	public void setPmaintenanceHoursOfWork(BigDecimal pmaintenanceHoursOfWork) {
		this.pmaintenanceHoursOfWork = pmaintenanceHoursOfWork;
	}

	public BigDecimal getPmaintenanceMile() {
		return this.pmaintenanceMile;
	}

	public void setPmaintenanceMile(BigDecimal pmaintenanceMile) {
		this.pmaintenanceMile = pmaintenanceMile;
	}

	public String getPmaintenanceStatus() {
		return this.pmaintenanceStatus;
	}

	public void setPmaintenanceStatus(String pmaintenanceStatus) {
		this.pmaintenanceStatus = pmaintenanceStatus;
	}

	public PstDepartment getPstDepartment() {
		return this.pstDepartment;
	}

	public void setPstDepartment(PstDepartment pstDepartment) {
		this.pstDepartment = pstDepartment;
	}

	public PstWorkType getPstWorkType() {
		return this.pstWorkType;
	}

	public void setPstWorkType(PstWorkType pstWorkType) {
		this.pstWorkType = pstWorkType;
	}



	public Long getPcmType() {
		return pcmType;
	}



	public void setPcmType(Long pcmType) {
		this.pcmType = pcmType;
	}



	public String getPmaintenanceRefNo() {
		return pmaintenanceRefNo;
	}



	public void setPmaintenanceRefNo(String pmaintenanceRefNo) {
		this.pmaintenanceRefNo = pmaintenanceRefNo;
	}



	public java.util.Date getPmaintenanceCheckTime() {
		return pmaintenanceCheckTime;
	}



	public void setPmaintenanceCheckTime(java.util.Date pmaintenanceCheckTime) {
		this.pmaintenanceCheckTime = pmaintenanceCheckTime;
	}



	public Long getPdId() {
		return pdId;
	}



	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}



	public Long getPwtId() {
		return pwtId;
	}



	public void setPwtId(Long pwtId) {
		this.pwtId = pwtId;
	}

}