package th.co.aoe.imake.pst.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the PST_COSTS database table.
 * 
 */
@Entity
@Table(name="PST_COSTS")
public class PstCost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PC_ID")
	private Long pcId;

	@Column(name="PC_AMOUNT")
	private Long pcAmount;

	@Column(name="PC_NAME")
	private String pcName;

	@Column(name="PC_UID")
	private String pcUid;

	@Column(name="PC_UNIT")
	private String pcUnit;

	//bi-directional many-to-one association to PstJobPay
	/*@OneToMany(mappedBy="pstCost")
	private List<PstJobPay> pstJobPays;*/

	public PstCost() {
	}

	public Long getPcId() {
		return this.pcId;
	}

	public void setPcId(Long pcId) {
		this.pcId = pcId;
	}

	public Long getPcAmount() {
		return this.pcAmount;
	}

	public void setPcAmount(Long pcAmount) {
		this.pcAmount = pcAmount;
	}

	public String getPcName() {
		return this.pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getPcUid() {
		return this.pcUid;
	}

	public void setPcUid(String pcUid) {
		this.pcUid = pcUid;
	}

	public String getPcUnit() {
		return this.pcUnit;
	}

	public void setPcUnit(String pcUnit) {
		this.pcUnit = pcUnit;
	}

/*	public List<PstJobPay> getPstJobPays() {
		return this.pstJobPays;
	}

	public void setPstJobPays(List<PstJobPay> pstJobPays) {
		this.pstJobPays = pstJobPays;
	}
*/
}