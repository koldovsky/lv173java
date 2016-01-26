package tc.lv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CustomerUsers")
public class CustomerUser extends User{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Column(name = "firstName")
		private String firstName;
		
		@Column(name = "lastName")
		private String lastName;
		
		@Column(name = "phone")
		private String phone;
		
		@Column(name = "passport")
		private String passport;
		
		@Column(name = "individualTaxNumber")
		private long individualTaxNumber;
		
		@ManyToOne
		@JoinColumn(name="addressId")
		private Address address;
		
		public CustomerUser() {
			super();
		}
	
		public CustomerUser(String firstName, String lastName, String phone, String passport, long individualTaxNumber) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.passport = passport;
			this.individualTaxNumber = individualTaxNumber;
		}
	
		public String getFirstName() {
			return firstName;
		}
	
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
	
		public String getLastName() {
			return lastName;
		}
	
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
		public String getPhone() {
			return phone;
		}
	
		public void setPhone(String phone) {
			this.phone = phone;
		}
	
		public String getPassport() {
			return passport;
		}
	
		public void setPassport(String passport) {
			this.passport = passport;
		}
	
		public long getIndividualTaxNumber() {
			return individualTaxNumber;
		}
	
		public void setIndividualTaxNumber(long individualTaxNumber) {
			this.individualTaxNumber = individualTaxNumber;
		}
		
		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		@Override
		public String toString() {
			return "CustomerUser [FirstName=" + firstName + ", LastName=" + lastName + ", phone=" + phone + ", passport="
					+ passport + ", individualTaxNumber=" + individualTaxNumber + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + (int) (individualTaxNumber ^ (individualTaxNumber >>> 32));
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((passport == null) ? 0 : passport.hashCode());
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
			CustomerUser other = (CustomerUser) obj;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (individualTaxNumber != other.individualTaxNumber)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (passport == null) {
				if (other.passport != null)
					return false;
			} else if (!passport.equals(other.passport))
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
				return false;
			return true;
		}
		
		
		
		
}