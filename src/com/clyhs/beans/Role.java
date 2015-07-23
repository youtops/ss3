package com.clyhs.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7722888669572154327L;

	private Integer roleId;
	
	private String  roleName;
	
	private String  roleDesc;
	
	private boolean issys;
	
	private boolean enabled;	
	
    //平台中的子系统  
    private String  module;
    
    private Set<UserRole> userRole = new HashSet<UserRole>();
    
    private Set<RoleAuthority> roleAuthority = new HashSet<RoleAuthority>();

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public boolean isIssys() {
		return issys;
	}

	public void setIssys(boolean issys) {
		this.issys = issys;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public Set<RoleAuthority> getRoleAuthority() {
		return roleAuthority;
	}

	public void setRoleAuthority(Set<RoleAuthority> roleAuthority) {
		this.roleAuthority = roleAuthority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + (issys ? 1231 : 1237);
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result
				+ ((roleAuthority == null) ? 0 : roleAuthority.hashCode());
		result = prime * result
				+ ((roleDesc == null) ? 0 : roleDesc.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result
				+ ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result
				+ ((userRole == null) ? 0 : userRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (enabled != other.enabled)
			return false;
		if (issys != other.issys)
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (roleAuthority == null) {
			if (other.roleAuthority != null)
				return false;
		} else if (!roleAuthority.equals(other.roleAuthority))
			return false;
		if (roleDesc == null) {
			if (other.roleDesc != null)
				return false;
		} else if (!roleDesc.equals(other.roleDesc))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}
	
	
}
