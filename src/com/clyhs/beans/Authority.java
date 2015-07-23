package com.clyhs.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Authority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -358708231973123254L;
	
	private Integer authorityId;
	
	private String  authorityName;
	
	private String  authorityDesc;
	
	private boolean enabled;
	
	private boolean issys;
	
	private String  module;
	
	private Set<RoleAuthority> roleAuthority = new HashSet<RoleAuthority>();
	
	private Set<AuthorityResource> authorityResource = new HashSet<AuthorityResource>();

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityDesc() {
		return authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isIssys() {
		return issys;
	}

	public void setIssys(boolean issys) {
		this.issys = issys;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Set<RoleAuthority> getRoleAuthority() {
		return roleAuthority;
	}

	public void setRoleAuthority(Set<RoleAuthority> roleAuthority) {
		this.roleAuthority = roleAuthority;
	}

	public Set<AuthorityResource> getAuthorityResource() {
		return authorityResource;
	}

	public void setAuthorityResource(Set<AuthorityResource> authorityResource) {
		this.authorityResource = authorityResource;
	}
	
	
	
	
	
	

}
