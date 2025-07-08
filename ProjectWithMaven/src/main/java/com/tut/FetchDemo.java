package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) 
	{
		
		Configuration cfm = new Configuration();
		
        cfm.configure();    
        
        SessionFactory factory = cfm.buildSessionFactory();
        
        //open new session
        Session session = factory.openSession();
        
        // Correct usage of load()
        Student student = session.byId(Student.class).load(104L);
        
//        - load() via byId() returns a proxy and may throw ObjectNotFoundException if the entity doesn’t exist.
        Student student1 = session.byId(Student.class).getReference(104L); // Lazy proxy
 
//- If you want a null-safe fetch, use:        
        Student student2 = session.byId(Student.class).loadOptional(101L).orElse(null); // ✅ Null-safe
        
        System.out.println(student);
        
    	//close session
        session.close();
        
        //close session factory
        factory.close();
		
	}

}
