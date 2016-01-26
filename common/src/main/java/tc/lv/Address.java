package tc.lv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Addresses")
public class Address extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="city")
	private String city;
	
	@Column(name="region")
	private String region;
	
	@Column(name="country")
	private String country;
	
	@Column(name="postalCode")
	private int postalCode; 
	
	@OneToMany(mappedBy="address")
	List<CustomerUser> customers = new ArrayList<>();
	
	@OneToOne(mappedBy="address")
	private RealEstateAgency agency;
	
	public Address(){
	}

	public Address(User createdBy, Date createdDate, User updatedBy, Date updatedDate, String city, String region,
			String country, int postalCode, List<CustomerUser> customers) {
		super(createdBy, createdDate, updatedBy, updatedDate);
		this.city = city;
		this.region = region;
		this.country = country;
		this.postalCode = postalCode;
		this.customers = customers;
	}

	public void addCustomer(CustomerUser customer){
		customer.setAddress(this);
		customers.add(customer);
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public List<CustomerUser> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerUser> customers) {
		this.customers = customers;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + postalCode;
		result = prime * result + ((region == null) ? 0 : region.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (postalCode != other.postalCode)
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}
	
	
}
