package tc.lv;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends BaseEntity implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -8534304252661398739L;

	@Column(name = "email")
	private String email;
	
	@Column(name = "password")	
	private String password;
	
	@OneToOne(mappedBy="createdBy")
	private BaseEntity createSmb;
	
	@OneToOne(mappedBy="updatedBy")
	private BaseEntity updateSmb;
	
	public User() {
		super();
	}

	public User(User createdBy, Date createdDate, User updatedBy, Date updatedDate, String email, String password) {
		super(createdBy, createdDate, updatedBy, updatedDate);
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminUser [email=" + email + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
	
}
