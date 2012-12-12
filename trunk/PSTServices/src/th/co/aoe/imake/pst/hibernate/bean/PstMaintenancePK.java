package th.co.aoe.imake.pst.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the PST_MAINTENANCE database table.
 * 
 */
@Embeddable
public class PstMaintenancePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PCM_TYPE")
	private Long pcmType;

	@Column(name="PMAINTENANCE_REF_NO")
	private String pmaintenanceRefNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PMAINTENANCE_CHECK_TIME")
	private java.util.Date pmaintenanceCheckTime;

	@Column(name="PD_ID")
	private Long pdId;

	@Column(name="PWT_ID")
	private Long pwtId;

	public PstMaintenancePK() {
	}
	public Long getPcmType() {
		return this.pcmType;
	}
	public void setPcmType(Long pcmType) {
		this.pcmType = pcmType;
	}
	public String getPmaintenanceRefNo() {
		return this.pmaintenanceRefNo;
	}
	public void setPmaintenanceRefNo(String pmaintenanceRefNo) {
		this.pmaintenanceRefNo = pmaintenanceRefNo;
	}
	public java.util.Date getPmaintenanceCheckTime() {
		return this.pmaintenanceCheckTime;
	}
	public void setPmaintenanceCheckTime(java.util.Date pmaintenanceCheckTime) {
		this.pmaintenanceCheckTime = pmaintenanceCheckTime;
	}
	public Long getPdId() {
		return this.pdId;
	}
	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}
	public Long getPwtId() {
		return this.pwtId;
	}
	public void setPwtId(Long pwtId) {
		this.pwtId = pwtId;
	}

	/*public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PstMaintenancePK)) {
			return false;
		}
		PstMaintenancePK castOther = (PstMaintenancePK)other;
		return 
			(this.pcmType == castOther.pcmType)
			&& this.pmaintenanceRefNo.equals(castOther.pmaintenanceRefNo)
			&& this.pmaintenanceCheckTime.equals(castOther.pmaintenanceCheckTime)
			&& (this.pdId == castOther.pdId)
			&& (this.pwtId == castOther.pwtId);
	}*/

	/*public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pcmType;
		hash = hash * prime + this.pmaintenanceRefNo.hashCode();
		hash = hash * prime + this.pmaintenanceCheckTime.hashCode();
		hash = hash * prime + this.pdId;
		hash = hash * prime + this.pwtId;
		
		return hash;
	}*/
}