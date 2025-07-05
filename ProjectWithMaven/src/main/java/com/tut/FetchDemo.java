package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		Configuration cfm = new Configuration();
        cfm.configure();    
        
        SessionFactory factory = cfm.buildSessionFactory();
        
        //open new session
        Session newSession = factory.openSession();
        
        Student student = newSession.l        
        System.out.println(student);
        
    	//close session
        newSession.close();
        
        //close session factory
        factory.close();
		
	}

}
