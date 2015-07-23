package com.clyhs.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.clyhs.beans.User;

public interface UserService<T extends User,PK extends Serializable> {
    
	public User getById(PK id);
	
	public User findByUserAccount(String userAccount);
	
	public List<String> loadUserAuthorities(final String username) ;
	
	public List<GrantedAuthority> loadUserAuthoritiesByName(String username);
}
