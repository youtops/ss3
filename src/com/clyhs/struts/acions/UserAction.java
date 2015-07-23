package com.clyhs.struts.acions;

import java.io.Serializable;

import org.springframework.security.core.userdetails.UserDetails;

import com.clyhs.beans.User;
import com.clyhs.service.MyUserDetailsService;
import com.clyhs.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 271745652533845262L;
	
	private UserService<User,Serializable> userService;
	
	private MyUserDetailsService myUserDetailService;

	

	public void setMyUserDetailService(MyUserDetailsService myUserDetailService) {
		this.myUserDetailService = myUserDetailService;
	}



	public void setUserService(UserService<User, Serializable> userService) {
		this.userService = userService;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user = userService.findByUserAccount("admin");
		
		//UserDetails userDetails = myUserDetailService.loadUserByUsername("admin");
		
		System.out.println(user.getUserName());
		return SUCCESS;
	}
	
	

}
