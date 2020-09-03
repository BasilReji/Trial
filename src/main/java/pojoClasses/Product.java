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
@Table(name="Product")
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "pid")
	private int pid;
	
	@Column(name="pname")  
	String pname;
	
	@Column(name="Quantity") 
	String quant;
	
	@Column(name="Status") 
	String stat;
	
	@Column(name="Remaining") 
	int remain;
	
	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	@Column(name="Description") 
	String desc;
	
	@Column(name="Category") 
	String categ;
	
	public String getCateg() {
		return categ;
	}

	public void setCateg(String categ) {
		this.categ = categ;
	}

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_orphan")
	private Orphanages oid;
	
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getQuant() {
		return quant;
	}

	public void setQuant(String quant) {
		this.quant = quant;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Orphanages getOid() {
		return oid;
	}

	public void setOid(Orphanages oid) {
		this.oid = oid;
	}

	

	
}
