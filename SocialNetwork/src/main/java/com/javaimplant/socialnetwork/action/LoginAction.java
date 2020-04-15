package com.javaimplant.socialnetwork.action;

import com.javaimplant.socialnetwork.dao.UserDAO;
import com.javaimplant.socialnetwork.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private User user;
	
	@Override
	public void validate() {
		
	}

	@Override
	public String execute() {
		System.out.println("We are executing login action!");
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		UserDAO dao=new UserDAO();
		dao.insertUser(user);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
