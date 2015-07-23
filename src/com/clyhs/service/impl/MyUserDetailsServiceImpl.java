package com.clyhs.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.clyhs.beans.User;
import com.clyhs.service.MyUserDetailsService;
import com.clyhs.service.UserService;

public class MyUserDetailsServiceImpl implements MyUserDetailsService {
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException{
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>(); 
		
		auths  = userService.loadUserAuthoritiesByName(username);
		System.out.println(username+"load::::::::::::::"+auths);
		User user = userService.findByUserAccount(username);
		System.out.println("user.getUserId() "+user.getUserId()+" user.getUserName()"+user.getUserName()+" user.getUserPassword()"+user.getUserPassword());  
		return new User(  
                user.getUserId(),  
                user.getUserAccount(),   
                user.getUserName(),   
                user.getUserPassword(),   
                user.getUserDesc(),  
                user.getEnabled(),  
                user.getIssys(),   
                user.getUserDuty(),   
                user.getUserDept(),   
                user.getSubSystem(),   
                user.getUserRole(),   
                true,   
                true,   
                true,  
                auths);
		//return null;
	}

}
