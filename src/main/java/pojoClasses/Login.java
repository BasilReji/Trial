package pojoClasses;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login")


public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "lid")
	private int lid;
	
	@Column(name="user")  
	String user;
	
	@Column(name="Password") 
	String password;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "uid")
	private User uid;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUid() {
		return uid;
	}

	public void setUid(User uid) {
		this.uid = uid;
	}

	

	
}
