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
@Table(name="Orphanages")

public class Orphanages {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idOrphan")
	private int idOrphan;
	
	
	
	@Column(name="RegNumber")
	private String regno;
	
	
	
	@Column(name="Place")
	private String place;



	public int getIdOrphan() {
		return idOrphan;
	}



	public void setIdOrphan(int idOrphan) {
		this.idOrphan = idOrphan;
	}



	public String getRegno() {
		return regno;
	}



	public void setRegno(String regno) {
		this.regno = regno;
	}



	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}

	

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
