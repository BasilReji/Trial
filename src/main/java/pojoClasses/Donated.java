package pojoClasses;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Donated")
public class Donated {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "did")
	private int did;
	
	@Column(name = "Quantity")
	private String quant;
	
	@Column(name = "Status")
	private String Status;
	

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getQuant() {
		return quant;
	}

	public void setQuant(String quant) {
		this.quant = quant;
	}

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "pid")
	private Product id_Product;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_donator")
	private Donator id_donator;
	
	

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public Product getId_Product() {
		return id_Product;
	}

	public void setId_Product(Product id_Product) {
		this.id_Product = id_Product;
	}

	public Donator getId_donator() {
		return id_donator;
	}

	public void setId_donator(Donator id_donator) {
		this.id_donator = id_donator;
	}
	
	
	
}
