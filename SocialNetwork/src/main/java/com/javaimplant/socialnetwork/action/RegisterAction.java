//package com.javaimplant.socialnetwork.action;
//
//import java.util.Map;
//
//import org.apache.commons.lang3.StringUtils;
//
//import com.javaimplant.socialnetwork.dao.UserDAO;
//import com.javaimplant.socialnetwork.model.User;
//import com.opensymphony.xwork2.ActionSupport;
//
//public class RegisterAction extends ActionSupport {
//
//	private static final long serialVersionUID = 1L;
//	private User user;
//	private Map<String,Object> userSession;
//	
//	@Override
//	public void validate() {
//		if(StringUtils.isEmpty(user.getUserName()))
//		{
//			addFieldError("user.userName","User Name cannot be blank");
//			return;
//		}
//		
//		if(user.getUserName().length()>64)
//		{
//			addFieldError("user.userName","User Name cannot be more than 64 characters");
//			return;
//		}
//		
//		UserDAO dao=new UserDAO();
//		if(!dao.getUserByName(user.getUserName()).isEmpty())
//		{
//			addFieldError("user.userName","User already exists");
//			return;
//		}
//		
//		if(user.getPassword().length()>64)
//		{
//			addFieldError("user.password","Password too Long");
//			return;
//		}
//		dao.close();
//	}
//
//	public Map<String, Object> getUserSession() {
//		return userSession;
//	}
//
//	public void setUserSession(Map<String, Object> userSession) {
//		this.userSession = userSession;
//	}
//
//	@Override
//	public String execute() throws Exception {
//		UserDAO dao=new UserDAO();
//		dao.insertUser(user);
//		dao.close();
//		return SUCCESS;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
//	
//
//}
