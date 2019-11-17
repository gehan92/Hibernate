package com.gehanProject.firsthibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Laptop laptop = new Laptop();
        laptop.setLid(101);
    	laptop.setLname("Dell");
    	
    	
    	Student student = new Student();
    	student.setRollno(1);
    	student.setName("sajith");
    	student.setMarks(76);
    	student .setLaptop(laptop);
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.save(laptop);
		session.save(student);
    	
		Transaction tx = session.beginTransaction();
		tx.commit();
		System.out.print(laptop);
		System.out.print(student);
    }
}
