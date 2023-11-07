package hcmute.entity;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email", length = 50, nullable = false)
	private String email;

	@Column(name = "fullname", length = 50)
	private String fullname;

	@Column(name = "phone")
	private int phone;

	@Column(name = "passwd", length = 32, nullable = false)
	private String passwd;

	@Column(name = "signup_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date signupDate;

	@Column(name = "last_login")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;

	@Column(name = "is_admin")
	private int isAdmin;

	public User() {
		// Default constructor
	}

	public String getEmail() {
		return email;
	}

	public String getFullname() {
		return fullname;
	}

	public int getId() {
		return id;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public String getPasswd() {
		return passwd;
	}

	public int getPhone() {
		return phone;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public User(String email, String fullname, int phone, String passwd, Date signupDate, Date lastLogin, int isAdmin) {
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
		this.passwd = passwd;
		this.signupDate = signupDate;
		this.lastLogin = lastLogin;
		this.isAdmin = isAdmin;
	}
	// Getters and setters
}
