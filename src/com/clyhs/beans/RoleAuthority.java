package com.clyhs.beans;

import java.io.Serializable;

public class RoleAuthority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7658330491163627204L;

	private Integer id;  
       
    private Boolean enabled;
    
    private Role role;
    
    private Authority authority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
    
}
