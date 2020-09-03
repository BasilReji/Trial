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

public class OrphanDao {
	
	Product p=new Product();
	
	@Autowired
	SessionFactory sessionFactory;
	
	public int save1(Orphanages orp,Login l,User u) {
		
		u.setRole("Orphanage");
		this.sessionFactory.getCurrentSession().save(u);
		orp.setUid(u);
		l.setUid(u);
		int i =(Integer) this.sessionFactory.getCurrentSession().save(orp);
		this.sessionFactory.getCurrentSession().save(l);
		return i ;
	}
	
		public int request(Orphanages orp,Product p) {
			p.setStat("Active");
			int j=Integer.parseInt(p.getQuant()); 
			p.setRemain(j);
			p.setOid(orp);
			int i =(Integer) this.sessionFactory.getCurrentSession().save(p);
			return 1;
		}
		
		public List<Product> requested(Orphanages orp) {
			
			
			Query query1 =this.sessionFactory.getCurrentSession().createQuery("from Product d where d.oid.idOrphan=:us  ");
			query1.setParameter("us", orp.getIdOrphan());
			
			List<Product> list3 = query1.list();
			
			
			
			
			return list3;
		}
		
		public int deleteDonated(int u) {
			Query query =this.sessionFactory.getCurrentSession().createQuery("delete from Donated d where d.id_Product.pid=:us  ");
			query.setInteger("us", u);
			int i=query.executeUpdate();
			return i;
		}
		
		public int deleteProducts(int u) {
			
			 deleteDonated(u);
			
			Query query1 =this.sessionFactory.getCurrentSession().createQuery("delete from Product d where d.pid=:us  ");
			query1.setInteger("us", u);
			int j=query1.executeUpdate();
			return j;
			
		}
		
		public int editPro(int id,String pn,String q,String de,String c) {
			Query query1 =this.sessionFactory.getCurrentSession().createQuery("update  Product d  set d.pname=:pn,d.quant=:q,d.desc=:de,d.categ=:c where d.pid=:us  ");
			query1.setInteger("us", id);
			query1.setString("pn", pn);
			query1.setString("q",q );
			query1.setString("de", de);
			query1.setString("c", c);
			int j=query1.executeUpdate();
			return j;
		}
		
		public void Status(int id) {
			
			
			int i=0,j=1;
			Query query1 =this.sessionFactory.getCurrentSession().createQuery(" from Product d where d.pid=:us ");
			query1.setInteger("us", id);
			List<Product> list3 = query1.list();
			
			for(Product p:list3) {
				
				
				i=p.getRemain();
			//	System.out.println("Remain "+i);
			}
			
			Query query =this.sessionFactory.getCurrentSession().createQuery(" from Donated p where p.id_Product.pid=:us ");
			query.setInteger("us", id);
			List<Donated> list4 = query.list();
			
			for(Donated d:list4) {
				
				j=Integer.parseInt(d.getQuant()); 
			//	System.out.println(j);
				}
			
				if(i<=j) {
					
					Query query2 =this.sessionFactory.getCurrentSession().createQuery("update  Product d  set d.stat=:c,d.remain=:r where d.pid=:us  ");
					query2.setInteger("us", id);
					query2.setString("c", "Completed");
					query2.setInteger("r", 0);
					query2.executeUpdate();
				}
				else {
					
					
					int r=i-j;
					System.out.println(r);
					Query query3 =this.sessionFactory.getCurrentSession().createQuery("update  Product d  set d.remain=:c where d.pid=:us  ");
					query3.setInteger("us", id);
					query3.setInteger("c", r);
					query3.executeUpdate();
				}
			}
		
}
