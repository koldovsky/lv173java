package tc.lv;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RealEstateAgencies")
public class RealEstateAgency extends BaseEntity {
	

	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="site")
	private URL site;
	
	@Column(name="phone")
	private String phone;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	private RealEstateAgency parent;
	
	@OneToMany(mappedBy="agency")
	private List<RealEstateAdminUser> admins = new ArrayList<>();
	
	@OneToMany(mappedBy="reAgency")
	private List<CurrencyRate> currencyRates = new ArrayList<>();

	public void addAdmin(RealEstateAdminUser admin){
		admin.setAgency(this);
		admins.add(admin);
	}
	
	public void addCurrencyRate(CurrencyRate rate){
		rate.setReAgency(this);
		currencyRates.add(rate);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public URL getSite() {
		return site;
	}

	public void setSite(URL site) {
		this.site = site;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public RealEstateAgency getParent() {
		return parent;
	}

	public void setParent(RealEstateAgency parent) {
		this.parent = parent;
	}
	
	
}
