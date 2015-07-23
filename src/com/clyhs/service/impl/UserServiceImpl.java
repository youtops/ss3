package com.clyhs.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.clyhs.beans.RoleAuthority;
import com.clyhs.beans.User;
import com.clyhs.beans.UserRole;
import com.clyhs.dao.UserDao;
import com.clyhs.service.UserService;

public class UserServiceImpl<T extends User,PK extends Serializable> implements UserService<T, PK> {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@SuppressWarnings("unchecked")
	@Override
	public User getById(PK id) {
		// TODO Auto-generated method stub
		return (User) userDao.getById(id);
	}
	@Override
	public User findByUserAccount(String userAccount) {
		// TODO Auto-generated method stub
		System.out.println("-------------");
		
		
		
		return userDao.findUserByAccount(userAccount);
	}
	
	
	
	@Override
	public List<GrantedAuthority> loadUserAuthoritiesByName(String username) {
		// TODO Auto-generated method stub
		try{
			
			System.out.println(username+"....au....");
			
			List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
			List<String> authorityNameList = loadUserAuthorities(username);
			
			for(String authName :authorityNameList )
			{
				 GrantedAuthorityImpl authority = new GrantedAuthorityImpl(authName);
				 auths.add(authority);
			}
			return auths;
			
		}catch(RuntimeException e)
		{
			throw e;
		}
		
		//return null;
	}
	/**
	 * 
	 * 获得用户的权限
	 */
	@Override
	public List<String> loadUserAuthorities(final String username) {
		// TODO Auto-generated method stub
		
		try{
			System.out.println(username+"===au===");
			List<String> authorityName = new ArrayList<String>();
			User user = findByUserAccount(username);
			
			System.out.println("user.getusername()"+user.getUsername());
			Set<UserRole> userRoles = user.getUserRole();
			for(UserRole userRole:userRoles)
			{
				Set<RoleAuthority> roleAuthoritys = userRole.getRole().getRoleAuthority();
				for(RoleAuthority roleAuthority:roleAuthoritys)
				{
					String authName = roleAuthority.getAuthority().getAuthorityName();
					System.out.println("::::::::::::::::::::"+authName+"+++++++++++++");
					authorityName.add(authName);
				}
			}
			return authorityName;
		}catch(RuntimeException e)
		{
			System.out.println("find by authority by username failed");
			throw e;
		}
			
		//return null;
	}
	

	
	
}
