package com.clyhs.beans;

import java.io.Serializable;

public class AuthorityResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8005302825287313545L;

	private Integer id;
	
	private boolean enabled;
	
	private Authority authority;
	
	private Resource resource;

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

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	
}
