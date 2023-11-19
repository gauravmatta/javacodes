package com.javaimplant.socialnetwork.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javaimplant.socialnetwork.model.User;
import com.javaimplant.socialnetwork.utils.Utils;

public class UserDAO {
	
	private SessionFactory factory;
	private Session session;
	
	public UserDAO()
	{
		factory=new Configuration().configure().buildSessionFactory();
		session=factory.openSession();
	}
	
	public void insertUser(User user)
	{
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	public List<User> getUserByName(String name)
	{
		return Utils.castList(User.class, session.createQuery("from User where userName = :name").setParameter("name",name).list());	
	}
	
	public void update(User user)
	{
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
	
	
	public void close()
	{
		session.close();
		factory.close();
	}
}
