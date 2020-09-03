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

import org.hibernate.annotations.Generated;

@Entity
@Table(name="donator")

public class Donator {

	//String idDonator,user,name,email,password,aadhar,phone,gender,willing;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idDonator")
	private int idDonator;
	
	
	@Column(name="aadhar")
	private String aadhar;
	
	
	
	@Column(name="gender")
	private String gender;
	
	
	
	
	public int getIdDonator() {
		return idDonator;
	}

	public void setIdDonator(int idDonator) {
		this.idDonator = idDonator;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWilling() {
		return willing;
	}

	public void setWilling(String willing) {
		this.willing = willing;
	}

	@Column(name="willing")
	private String willing;

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "uid")
	private User uid;




	public User getUid() {
		return uid;
	}

	public void setUid(User uid) {
		this.uid = uid;
	}
	
	
	
}
