package com.javaimplant.SocialNetwork;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javaimplant.socialnetwork.dao.UserDAO;
import com.javaimplant.socialnetwork.model.User;

public class Main {
	
	public static void main(String args[]) 
	{
		 	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	        Session session = factory.openSession();
	        session.beginTransaction();
	 
	        User u1 = new User("Test1","Test1");
	        User u2 = new User("Test2","Test2");
	        User u3 = new User("Test3","Test3");
	        UserDAO dao=new UserDAO();
	        dao.insertUser(u1);
	        dao.insertUser(u2);
	        dao.insertUser(u3);
	        
	}
}
