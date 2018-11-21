package com.hibernate.basic;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class EmpManage {
	
	private static SessionFactory factory; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	factory = new Configuration().configure().addPackage("com.hibernate.basic").addAnnotatedClass(Employee.class).buildSessionFactory(); 
				
				// which package to add?
				//An instance of Configuration allows the applicationto specify properties and 
				//mapping documents to be used whencreating a SessionFactory
				//.configure() - used to specify to pick configuration from an hibernate.cfg.xml file
				// .addAnnotatedClass() - refers to the class where we have the annontations
				// 
				// used Configuration instead of AnnotationConfigutaion as it is deprecated
			
		Configuration configuration = new Configuration().configure().addPackage("com.hibernate.basic").addAnnotatedClass(Employee.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
		
		// this seems okay , not sure about it.
		EmpManage empManage = new EmpManage();
		empManage.addEmployee("Radha", "Goidani", 400);
		empManage.addEmployee("Akash", "Roy", 300);
		empManage.listEmployees();
	}
	
	
	
	public void addEmployee(String fname,String lname,int salary) {
		Session session = factory.openSession();
		Transaction transaction = null;
		Integer empId = null; 
		// DOUBT******* why Integer and not int
		// DOUBT*******int cannot be null.
		//  Only objects can have null value. 
		
		transaction = session.beginTransaction();
		Employee e = new Employee();
		e.setFirstName(fname);
		e.setLastName(lname);
		e.setSalary(salary);
		empId = (Integer) session.save(e);
		//************DOUBT how does this line exactly work? how does it add empId and save it?
		// session.save - this generates a new identifier and INSERTS record into database. It persists the transient object
		// return type of save is Serializable object
		transaction.commit();
		session.close();
	}
	
	public void listEmployees( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List<Employee> employees = session.createQuery("FROM Employee").list(); 
	         for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }

}
