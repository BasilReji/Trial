package modules;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojoClasses.Donated;
import pojoClasses.Donator;
import pojoClasses.Login;
import pojoClasses.Orphanages;
import pojoClasses.Product;
import pojoClasses.User;

@Repository
@Transactional


public class DonatorDao {

	@Autowired
	SessionFactory sessionFactory;
	
	Product p= new Product();
	public int save(Donator dao,Login l,User u) {
		u.setRole("Donator");
		this.sessionFactory.getCurrentSession().save(u);
		
		
		dao.setUid(u);
		l.setUid(u);
		int i =(Integer) this.sessionFactory.getCurrentSession().save(dao);
		this.sessionFactory.getCurrentSession().save(l);
		return i ;
	}
	
	public List<User> getUser(int user) {
		
		
		Query query1 =this.sessionFactory.getCurrentSession().createQuery("from User  where uid=:us   ");
		query1.setParameter("us", user);
		
		List<User> list4 = query1.list();
		
			return list4;
		
	}
	
	public List<Product> getProducts(){
		
		Query query1 =this.sessionFactory.getCurrentSession().createQuery("from Product");
		
		
		List<Product> list4 = query1.list();
		
			return list4;
	}
	
	public int donate(Donator don,Product p,Donated d) {
		
		d.setId_donator(don);
		d.setId_Product(p);
		
		
		int i =(Integer) this.sessionFactory.getCurrentSession().save(d);
		return 1;
	}
	
	public Product pr(int u) {
		
		
		Query query =this.sessionFactory.getCurrentSession().createQuery("from Product where pid=:u   ");
		query.setInteger("u", u);
		List<Product> list2 = query.list();
	
		for(Product l:list2) {
			
		p=l;
		
		}
		
		return p;
	}
	
	public List<Donated> donated(Donator orp) {
		
		
		Query query1 =this.sessionFactory.getCurrentSession().createQuery("from Donated d where d.id_donator.idDonator=:us  ");
		query1.setParameter("us", orp.getIdDonator());
		
		List<Donated> list3 = query1.list();
		
		
		
		
		return list3;
	}
	
	public int edit(int id,String q,String c) {
		Query query1 =this.sessionFactory.getCurrentSession().createQuery("update  Donated d  set d.quant=:q,d.Status=:c where d.did=:us  ");
		query1.setInteger("us", id);
		
		query1.setString("q",q );
		
		query1.setString("c", c);
		int j=query1.executeUpdate();
		return j;
	}
	
	Donated dd=new Donated();
public Donated don(int u) {
		
		
		Query query =this.sessionFactory.getCurrentSession().createQuery("from Donated where did=:u   ");
		query.setInteger("u", u);
		List<Donated> list2 = query.list();
	
		for(Donated l:list2) {
			
		dd=l;
		
		}
		
		return dd;
	}

	public List<User> viewUser() {
	
		Query query =this.sessionFactory.getCurrentSession().createQuery("from User ");
		List<User> list2 = query.list();
		
		return list2;
	}
	
	public List<Donated> viewDonated() {
		
		Query query =this.sessionFactory.getCurrentSession().createQuery("from Donated ");
		List<Donated> list2 = query.list();
		
		return list2;
	}
	
	public void delete(int id) {
		
		
		
		Query query =this.sessionFactory.getCurrentSession().createQuery("delete from Donated where did=:u   ");
		query.setInteger("u", id);
		query.executeUpdate();
	}
	

	
}
