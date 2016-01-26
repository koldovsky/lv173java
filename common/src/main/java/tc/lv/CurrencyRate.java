package tc.lv;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CurrencyRates")
public class CurrencyRate extends BaseEntity {
	

	private static final long serialVersionUID = 1L;

	@Column(name = "amount")
	private int amount;
	
	@Column(name = "fromDate")
	private Date fromDate;
	
	@Column(name = "toDate")
	private Date toDate;
	
	@ManyToOne
	@JoinColumn(name="reAgencyId")
	private RealEstateAgency reAgency;

	public CurrencyRate() {
		super();
	}

	public CurrencyRate(User createdBy, Date createdDate, User updatedBy, Date updatedDate, int amount, Date fromDate,
			Date toDate, RealEstateAgency reAgency) {
		super(createdBy, createdDate, updatedBy, updatedDate);
		this.amount = amount;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reAgency = reAgency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public RealEstateAgency getReAgency() {
		return reAgency;
	}

	public void setReAgency(RealEstateAgency reAgency) {
		this.reAgency = reAgency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + amount;
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyRate other = (CurrencyRate) obj;
		if (amount != other.amount)
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		return true;
	}
	
	

	
}
