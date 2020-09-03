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
import pojoClasses.User;

@Repository
@Transactional

public class LoginDao {
	
	User us=new User();
	Object f=new Object();
	Donator d=new Donator();
	Orphanages o=new Orphanages();
	Login log=new Login();
	
	@Autowired
	SessionFactory sessionFactory;

	public User login(String u,String pass) {
		int uid=0;
		
		Query query =this.sessionFactory.getCurrentSession().createQuery("from Login where user=:u and password=:p  ");
		query.setString("u", u);
		query.setString("p", pass);
		List<Login> list2 = query.list();
	
		for(Login l:list2) {
			
		us=l.getUid();
		
		}
		
		return us;
	}
		
	public Donator donator(User us) {
		
		Query query1 =this.sessionFactory.getCurrentSession().createQuery("from Donator d where d.uid.uid=:us  ");
		query1.setParameter("us", us.getUid());
		
		List<Donator> list3 = query1.list();
		
		
		for(Donator l1:list3) {
			
			d=l1;
			
			
		}
		
		return d;
	}
	
	public Orphanages orphan(User u) {
		
		Query query1 =this.sessionFactory.getCurrentSession().createQuery("from Orphanages o where o.uid.uid=:us   ");
		query1.setParameter("us", us.getUid());
		
		List<Orphanages> list4 = query1.list();
		
		
		for(Orphanages l1:list4) {
			
			o=l1;
			
			
		}
		return o;
	}
	
		public void deleteDonator(int id) {
		
		Query query1 =this.sessionFactory.getCurrentSession().createQuery("delete from Donator o where o.uid.uid=:us   ");
		query1.setParameter("us", id);
		query1.executeUpdate();
		
	}
		
		
		public void deleteOrphanage(int id) {
		
		Query query1 =this.sessionFactory.getCurrentSession().createQuery("delete from Orphanages o where o.uid.uid=:us   ");
		query1.setParameter("us", id);
		query1.executeUpdate();
		
	}
	
	public void deleteUser(int id) {
		
		Query query2 =this.sessionFactory.getCurrentSession().createQuery("delete from Login o where o.uid.uid=:us   ");
		query2.setParameter("us", id);
		query2.executeUpdate();
		
		Query query1 =this.sessionFactory.getCurrentSession().createQuery("delete from User o where o.uid=:us   ");
		query1.setParameter("us", id);
		query1.executeUpdate();
		
		
		
	}
	
	public String Role(int u) {
		String role="o";
		Query query1 =this.sessionFactory.getCurrentSession().createQuery(" from User o where o.uid=:us   ");
		query1.setParameter("us", u);
		
		List<User> list3=query1.list();
		
		for(User us:list3) {
			
			role=us.getRole();
		}
		return role;
	}
	
	public List<Donated> donated(int id){
		
		Query query1 =this.sessionFactory.getCurrentSession().createQuery(" from Donated o where o.id_Product.oid.idOrphan=:us   ");
		query1.setParameter("us", id);
		List<Donated> list=query1.list();		
		return list;
	}
	
}
