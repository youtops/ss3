package com.clyhs.struts.acions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.clyhs.beans.User;
import com.clyhs.service.UserService;

public class LoginAction extends BaseAction {
	
	private UserService userService;
	
	private String username;
	
	private String password;
	
	
	
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		user = userService.findByUserAccount(username);
		HttpServletRequest request = ServletActionContext.getRequest();
    	HttpSession session = request.getSession();
		
    	session.setAttribute("user", user);
		
		if(user !=null)
		{
			return SUCCESS;
		}else
		{
			return INPUT;
		}
		
		
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
