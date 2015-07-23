package com.clyhs.beans;

import java.io.Serializable;

public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8057217841553865395L;

	private Integer id;
	
	private boolean enabled;
	
	private User user ;
	
	private Role role ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
