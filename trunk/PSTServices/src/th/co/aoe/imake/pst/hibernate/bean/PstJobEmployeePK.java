package th.co.aoe.imake.pst.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the PST_JOB_EMPLOYEE database table.
 * 
 */
@Embeddable
public class PstJobEmployeePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	public PstJobEmployeePK(Long pjId, Long peId) {
		super();
		this.pjId = pjId;
		this.peId = peId;
	}
	@Column(name="PJ_ID")
	private Long pjId;

	@Column(name="PE_ID")
	private Long peId;

	public PstJobEmployeePK() {
	}
	public Long getPjId() {
		return this.pjId;
	}
	public void setPjId(Long pjId) {
		this.pjId = pjId;
	}
	public Long getPeId() {
		return this.peId;
	}
	public void setPeId(Long peId) {
		this.peId = peId;
	}

	/*public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PstJobEmployeePK)) {
			return false;
		}
		PstJobEmployeePK castOther = (PstJobEmployeePK)other;
		return 
			(this.pjId == castOther.pjId)
			&& (this.peId == castOther.peId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pjId;
		hash = hash * prime + this.peId;
		
		return hash;
	}*/
}