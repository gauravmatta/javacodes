package com.javaimplant.socialnetwork.action;

public class LoginAction {
//public class LoginAction extends ActionSupport implements SessionAware {

//	@Override
	public String execute() {
		System.out.println("We are executing login action!");
//		System.out.println(user.getUserName());
//		System.out.println(user.getPassword());
		return "success";
	}

//	private User user;
//	private Map<String,Object> userSession;
//	
//	public Map<String, Object> getUserSession() {
//		return userSession;
//	}
//
//	public void setUserSession(Map<String, Object> userSession) {
//		this.userSession = userSession;
//	}

//	@Override
//	public void validate() {
//		UserDAO dao=new UserDAO();
//		if(StringUtils.isEmpty(user.getUserName()))
//		{
//			addFieldError("user.userName","User Name cannot be blank");
//			return;
//		}
//		List<User> users=dao.getUserByName(user.getUserName());
//		if(users.isEmpty())
//		{
//			addFieldError("user.userName","User Not Found");
//			return;
//		}
//		
//		if(!users.get(0).getPassword().equals(user.getPassword()))
//		{
//			addFieldError("user.password","Password mismatch");
//			return;			
//		}
//		this.user=users.get(0);
//		userSession.put("currentUser",this.user);
//		dao.close();
//	}
//
//	
//	public String addUser()
//	{
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
//	@Override
//	public void setSession(Map<String, Object> session) {
//		this.userSession=session;
//		
//	}
//
//	@Override
//	public void withSession(Map<String, Object> session) {
//		// TODO Auto-generated method stub
//		
//	}
//	
}
