package controllerPack;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import modules.DonatorDao;
import modules.LoginDao;
import modules.OrphanDao;
import pojoClasses.Donated;
import pojoClasses.Donator;
import pojoClasses.Login;
import pojoClasses.Orphanages;
import pojoClasses.Product;
import pojoClasses.User;

@Controller
@ComponentScan("modules")
public class MyController {

	Login ld;

	@Autowired
	private DonatorDao dao;
	@Autowired
	private OrphanDao dao1;
	@Autowired
	private LoginDao dao2;

	
	User u=new User();
	Donator d=new Donator();
	Orphanages o=new Orphanages();
	Product p=new Product();
	Donated dd=new Donated();
	@RequestMapping("/")
	public String showform(Model m) {

		System.out.println("Project is running");
		// m.addAttribute("command", new Donator());
		return "index";
	}

	@RequestMapping("/index")
	public String showform2(Model m) {

		// m.addAttribute("command", new Donator());
		return "index";
	}

	@RequestMapping("/payment")
	public String showform3(Model m) {

		// m.addAttribute("command", new Donator());
		return "payment";
	}

	@RequestMapping("/join")
	public String showform1(Model m) {

		m.addAttribute("command", new Donator());
		m.addAttribute("command", new Orphanages());
		return "join";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("don") Donator don, @ModelAttribute("log") Login log,
			@ModelAttribute("us") User us) {
		int i = dao.save(don, log, us);
		if (i > 0) {
			System.out.println("Success");
		} else {
			System.out.println("Error");
		}
		return "redirect:/join";// will redirect to viewemp request mapping
	}

	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public String save1(@ModelAttribute("orp") Orphanages orp, @ModelAttribute("log") Login log,
			@ModelAttribute("us") User us) {
		int i = dao1.save1(orp, log, us);
		if (i > 0) {
			System.out.println("Success");
		} else {
			System.out.println("Error");
		}
		return "redirect:/join";// will redirect to viewemp request mapping
	}

	@RequestMapping("/Donator")
	public String showform4(Model m) {

		// m.addAttribute("command", new Donator());
		m.addAttribute("profile", d);
		return "Donator";
	}

	@RequestMapping("/Orphanages")
	public String showform5(Model m) {

		m.addAttribute("profile", o);
		// m.addAttribute("command", new Donator());
		return "Orphanages";
	}

	@RequestMapping(value="/login",method = RequestMethod.POST)    
    public ModelAndView login(HttpServletRequest r,Model m){   
    	
    	String user=r.getParameter("user");
    	String pass=r.getParameter("password");
    	
    	if(user.equals("admin")&&pass.equals("admin")) {
    		
    		List<User> list=dao.viewUser();
    		return new ModelAndView("Admin","us",list);
    	}
    	
    	u=dao2.login(user, pass);
    	d=dao2.donator(u);
    	o=dao2.orphan(u);
    	List<User> catList=new ArrayList<User>() ;
		
    	String role;
		if(user.equals(u.getUser())&&pass.equals(u.getPassword())) {
			
			role="Donator";
			
			if(role.equals(u.getRole())) {
			
				
				return new ModelAndView("Donator","profile",d);
			//will redirect to viewemp request mapping
				
			}else {
				
					
				return new ModelAndView("Orphanages","profile",o);
			}
			
		}
		

		return new ModelAndView("join","",null);
    	
    	//m.addAttribute("userdata",o);
    	
           
    }

//    
//    @RequestMapping("/Profile")    
//    public String showform6(Model m){    
//    	
//    	
//     //   m.addAttribute("command", new Donator());  
//        return "Profile";   
//    } 

	@RequestMapping("/Donate")
	public String showform7(Model m) {

		// m.addAttribute("command", new Donator());
		return "Donate";
	}

	@RequestMapping("/Request")
	public String showform8(Model m) {

		// m.addAttribute("command", new Donator());
		return "Request";
	}
	
	@RequestMapping(value = "/psave", method = RequestMethod.POST)
	public String psave( @ModelAttribute("pro") Product pro) {
		
		dao1.request(o, pro);
		
		//List<Product> list=	dao1.requested(o);
		return "redirect:/Request";// will redirect to viewemp request mapping
		//return new ModelAndView("Requested","req",list);
	}
	
	@RequestMapping("/don")
	public String showform9(Model m) {

		// m.addAttribute("command", new Donator());
		//return "Donation";
		
		List<Product> pl=dao.getProducts();
		m.addAttribute("plist", pl);
//		for(Product p:pl) {
//    		
//    		System.out.println(p.getPname());
//    	}
		return "Donation";
		
	}
	

	
	@RequestMapping(value = "/donating")
	public String donating( HttpServletRequest r) {
		
		String pid=r.getParameter("pid");
		//System.out.println(pid);
		int i=Integer.parseInt(pid);  
		
		p= dao.pr(i);
		
//		dao1.
		return "redirect:/Donate";// will redirect to viewemp request mapping
		//return new ModelAndView("Requested","profile",d);
	}

	@RequestMapping(value = "/dsave", method = RequestMethod.POST)
	public String dsave( @ModelAttribute("don") Donated don) {
		
		
		
//		System.out.println(p.getPname());
//		System.out.println(d.getIdDonator());
		
		dao.donate(d, p, don);
	//	System.out.println(p.getPid());
		int id= p.getPid();
		dao1.Status(id);
//		dao1.
		return "redirect:/don";// will redirect to viewemp request mapping
		//return new ModelAndView("Requested","profile",d);
	}
	
	@RequestMapping("/Requested")
	public String showform10(Model m) {

		// m.addAttribute("command", new Donator());
		//return "Donation";
		
		List<Product> pl=dao1.requested(o);
		m.addAttribute("req", pl);
//		for(Product p:pl) {
//    		
//    		System.out.println(p.getPname());
//    	}
		return "Requested";
		
	}
	
	@RequestMapping(value = "/EditProduct")
	public String EditProduct( HttpServletRequest r,Model m) {
		
		String pid=r.getParameter("pid");
		String act=r.getParameter("edit");
		//System.out.println(pid);
		int i=Integer.parseInt(pid);  
		
		//System.out.println(i+" "+act);
		
		if(act.equals("Delete")) {
			
			int j=dao1.deleteProducts(i);
			
			if(j>0) {
				System.out.println("success");
			}
				
		}else if(act.equals("Edit")) {
			
			p= dao.pr(i);
			
			m.addAttribute("req", p);
			return "editProd";
			
		}
		
		
		
//		dao1.
		return "redirect:/Requested";// will redirect to viewemp request mapping
		//return new ModelAndView("Requested","profile",d);
	}
	
	@RequestMapping("/Donatedi")
	public String showform11(Model m) {

		
		List<Donated> pl=dao.donated(d);
		m.addAttribute("req", pl);
		return "Donated";
		
	}
	
	@RequestMapping(value = "/editPro", method = RequestMethod.POST)
	public String editPro(HttpServletRequest r) {
		
		String pid=r.getParameter("pid");
		int i=Integer.parseInt(pid);  
		String pn=r.getParameter("pname");
		String q=r.getParameter("quant");
		String de=r.getParameter("desc");
		String c=r.getParameter("categ");
		
		int j=dao1.editPro(i, pn,q,de,c);
		
		
		//List<Product> list=	dao1.requested(o);
		return "redirect:/Requested";// will redirect to viewemp request mapping
		//return new ModelAndView("Requested","req",list);
	}
	
	@RequestMapping(value = "/editDona", method = RequestMethod.POST)
	public String editDon(HttpServletRequest r) {
		
		String pid=r.getParameter("did");
		int i=Integer.parseInt(pid);  
		
		String q=r.getParameter("quant");
		String de=r.getParameter("Status");
		
		
		int j=dao.edit(i, q, de);
		
		
		//List<Product> list=	dao1.requested(o);
		return "redirect:/Donatedi";// will redirect to viewemp request mapping
		//return new ModelAndView("Requested","req",list);
	}
	@RequestMapping("/editDon")
	public String showform21(HttpServletRequest r,Model m) {
		
		String pid=r.getParameter("did");
		String act=r.getParameter("edit");
		int i=Integer.parseInt(pid);  
		
		if(act.equals("edit")) {
			dd=dao.don(i);
			m.addAttribute("req", dd);
			return "editDon";
		}
		else if(act.equals("Delete")){
			dao.delete(i);
		}
		return "Donated";
	}
	
	@RequestMapping("/aRequested")
	public String showform12(Model m) {

		
		List<Product> pl=dao.getProducts();
		m.addAttribute("req", pl);
		return "aRequested";
		
	}
	
	@RequestMapping("/aDonated")
	public String showform13(Model m) {

		
		List<Donated> pl=dao.viewDonated();
		m.addAttribute("req", pl);
		return "aDonated";
		
	}
	
	@RequestMapping("/Admin")
	public String showform14(Model m) {

		
		List<User> list=dao.viewUser();
		m.addAttribute("us", list);
		return "Admin";
		
		
	}
	
	@RequestMapping(value = "/EditUser")
	public String DeleteUser(HttpServletRequest r) {
		
		String pid=r.getParameter("pid");
		int i=Integer.parseInt(pid);  
		
		String role=dao2.Role(i);
		
		
		if(role.equals("Donator")) {
			
			dao2.deleteDonator(i);
			dao2.deleteUser(i);
		}
		else if(role.equals("Orphanage")) {
			
			dao2.deleteOrphanage(i);
			dao2.deleteUser(i);
		}
		
		return "redirect:/Admin";// will redirect to viewemp request mapping
		
	}
	
	@RequestMapping("/Donatedo")
	public String showform15(Model m) {

		int id=o.getIdOrphan();
		List<Donated> list=dao2.donated(id);
		m.addAttribute("us", list);
		return "Donatedo";
		
		
	}
	
}
