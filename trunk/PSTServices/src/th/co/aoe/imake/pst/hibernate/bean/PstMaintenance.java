package th.co.aoe.imake.pst.hibernate.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PST_MAINTENANCE database table.
 * 
 */
@Entity
@Table(name="PST_MAINTENANCE",schema="PST_DB")
public class PstMaintenance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PstMaintenancePK id;

	@Column(name="PMAINTENANCE_DOC_NO")
	private String pmaintenanceDocNo;

	@Column(name="PMAINTENANCE_HOURS_OF_WORK")
	private BigDecimal pmaintenanceHoursOfWork;

	@Column(name="PMAINTENANCE_MILE")
	private BigDecimal pmaintenanceMile;

	@Column(name="PMAINTENANCE_STATUS")
	private String pmaintenanceStatus;

	//bi-directional many-to-one association to PstDepartment
	@ManyToOne
	@JoinColumn(name="PD_ID",insertable=false,updatable=false)
	private PstDepartment pstDepartment;

	//bi-directional many-to-one association to PstWorkType
	@ManyToOne
	@JoinColumn(name="PWT_ID",insertable=false,updatable=false)
	private PstWorkType pstWorkType;

	public PstMaintenance() {
	}

	public PstMaintenancePK getId() {
		return this.id;
	}

	public void setId(PstMaintenancePK id) {
		this.id = id;
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

}