package com.javaimplant.socialnetwork.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.javaimplant.socialnetwork.dao.UserDAO;
import com.javaimplant.socialnetwork.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class AddFriendAction  extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	private Map<String,Object> userSession;
	private String name;
	
	@Override
	public String execute() throws Exception {
		UserDAO dao=new UserDAO();
		List<User> users=dao.getUserByName(name);
		User currentUser=(User)userSession.get("currentUser");
		Set<User> friends=currentUser.getFriends();
		friends.add(users.get(0));
		currentUser.setFriends(friends);
		dao.update(currentUser);
		dao.close();
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void validate() {
		if(StringUtils.isEmpty(name))
		{
			addFieldError("name","Name cannot be empty");
		}
		UserDAO dao=new UserDAO();
		List<User> users=dao.getUserByName(name);
		User currentUser=(User)userSession.get("currentUser");
//		System.out.println(currentUser);
		if(users.isEmpty())
		{
			addFieldError("name","User does not exist");
			return;
		}
		if(currentUser.getUserName().equals(users.get(0).getUserName()))
		{
			addFieldError("name","You cannot add yourself as Friend");
			return;
		}
		dao.close();
		
		for(User u:currentUser.getFriends())
		{
			if(u.getUserName().equals(users.get(0).getUserName()))
			{
				addFieldError("name","Already your Friend");
				return;
			}
		}
	}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession=session;
	}
	
 
}
