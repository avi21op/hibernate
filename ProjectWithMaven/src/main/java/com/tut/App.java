package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println("Project Started ...");
        Configuration cfm = new Configuration();
        cfm.configure();
        SessionFactory factory = cfm.buildSessionFactory();
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println(factory);
        
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        System.out.println(sessionFactory);
//        System.out.println(factory.isClosed());
        
        Student student = new Student();
        student.setId(104);
        student.setName("Aviraj");
        student.setCity("Kolkata");
        
//        System.out.println(student);
        
        Address address = new Address();
        address.setStreet("street1");
        address.setCity("Kolkata");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1234.235);
        
        FileInputStream fileInputStream = new FileInputStream("src/main/java/lenovo.jpg");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);
        address.setImage(data);
        
        //Current Session - no need to close
        Session session = factory.getCurrentSession();
        
        //open new session
        //Session newSession = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.persist(student);
        session.persist(address);
        
//        session.getTransaction().commit();
        tx.commit();
        
    	//close session
        //session.close();
        
        //close session factory
        factory.close();
		
		//open stateless session
        //StatelessSession statelessSession = sessionFactory.openStatelessSession();
		//perform stateless db operations
		//close session
		//statelessSession.close();
        
        fileInputStream.close();
		System.out.println("Done ...");
		
    }

}
