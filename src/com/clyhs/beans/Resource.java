package com.clyhs.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -82792927882470515L;
	
	private Integer resourceId;
	
    private String  resourceName; 
    
    private String  resourceDesc;  
    
    private String  resourceType; 
    
    private String  resourceString; 
    
    private Boolean priority;
    
    private Integer enabled;  
        
    private Integer issys;  
      
    private String  module;
    
    private Set<AuthorityResource> authorityResource = new HashSet<AuthorityResource>();

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceString() {
		return resourceString;
	}

	public void setResourceString(String resourceString) {
		this.resourceString = resourceString;
	}

	public Boolean getPriority() {
		return priority;
	}

	public void setPriority(Boolean priority) {
		this.priority = priority;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getIssys() {
		return issys;
	}

	public void setIssys(Integer issys) {
		this.issys = issys;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Set<AuthorityResource> getAuthorityResource() {
		return authorityResource;
	}

	public void setAuthorityResource(Set<AuthorityResource> authorityResource) {
		this.authorityResource = authorityResource;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((authorityResource == null) ? 0 : authorityResource
						.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((issys == null) ? 0 : issys.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result
				+ ((resourceDesc == null) ? 0 : resourceDesc.hashCode());
		result = prime * result
				+ ((resourceId == null) ? 0 : resourceId.hashCode());
		result = prime * result
				+ ((resourceName == null) ? 0 : resourceName.hashCode());
		result = prime * result
				+ ((resourceString == null) ? 0 : resourceString.hashCode());
		result = prime * result
				+ ((resourceType == null) ? 0 : resourceType.hashCode());
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
		Resource other = (Resource) obj;
		if (authorityResource == null) {
			if (other.authorityResource != null)
				return false;
		} else if (!authorityResource.equals(other.authorityResource))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (issys == null) {
			if (other.issys != null)
				return false;
		} else if (!issys.equals(other.issys))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (resourceDesc == null) {
			if (other.resourceDesc != null)
				return false;
		} else if (!resourceDesc.equals(other.resourceDesc))
			return false;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		if (resourceName == null) {
			if (other.resourceName != null)
				return false;
		} else if (!resourceName.equals(other.resourceName))
			return false;
		if (resourceString == null) {
			if (other.resourceString != null)
				return false;
		} else if (!resourceString.equals(other.resourceString))
			return false;
		if (resourceType == null) {
			if (other.resourceType != null)
				return false;
		} else if (!resourceType.equals(other.resourceType))
			return false;
		return true;
	} 
    
    

}
