package com.clyhs.struts.acions;

import org.springframework.security.core.userdetails.UserDetails;

import com.clyhs.service.MyUserDetailsService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	
    private MyUserDetailsService myUserDetailService;

	

	public void setMyUserDetailService(MyUserDetailsService myUserDetailService) {
		this.myUserDetailService = myUserDetailService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//UserDetails userDetails = myUserDetailService.loadUserByUsername("admin");
		System.out.println("admin/index.jsp");
		return SUCCESS;
	}

}
