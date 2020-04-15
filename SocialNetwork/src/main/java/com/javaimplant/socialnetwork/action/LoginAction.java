package com.javaimplant.socialnetwork.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.javaimplant.socialnetwork.dao.UserDAO;
import com.javaimplant.socialnetwork.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private User user;
	
	@Override
	public void validate() {
		UserDAO dao=new UserDAO();
		
		if(StringUtils.isEmpty(user.getUserName()))
		{
			addFieldError("user.userName","User Name cannot be blank");
			return;
		}
		
		List<User> users=dao.getUserByName(user.getUserName());
		
		if(users.isEmpty())
		{
			addFieldError("user.userName","User Not Found");
			return;
		}
		
		if(!users.get(0).getPassword().equals(user.getPassword()))
		{
			addFieldError("user.password","Password mismatch");
			return;			
		}
		
		this.user=users.get(0);
		
	}

	@Override
	public String execute() {
		System.out.println("We are executing login action!");
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		return SUCCESS;
	}
	
	public String insertUser()
	{
		UserDAO dao=new UserDAO();
		dao.insertUser(user);
		return SUCCESS;
	}
	
	public String addUser()
	{
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
