package com.clyhs.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import com.clyhs.dao.MyUserDetails;

public class User implements MyUserDetails,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 438895829318221288L;
	
	private Integer userId;
	
	private String  userName;
	
	private String  userAccount;
	
	private String  userPassword;
	
	private String  userDesc; 
	
    private boolean enabled;
	
	private boolean issys;
	
	private String  userDept;
	
	private String  userDuty; 
	
	private String  subSystem;
	
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	
	//实现了UserDetails之后的相关变量  
    private  String password;  
    private  String username;  
    private  Set<GrantedAuthority> authorities;  
    private  boolean accountNonExpired;  
    private  boolean accountNonLocked;  
    private  boolean credentialsNonExpired; 
    
    public User(){  
        
    }  
          
    public User(int userId, String userAccount, String userName,  
            String userPassword, String userDesc, Boolean enabled,  
            Boolean issys, String userDept, String userDuty, String subSystem,  
            Set<UserRole> UserRole,boolean accountNonExpired, boolean accountNonLocked,  
            boolean credentialsNonExpired,Collection<GrantedAuthority> authorities) {  
          
        if (((userAccount == null) || "".equals(userAccount)) || (userPassword == null)) {  
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");  
        }  
          
        this.userId = userId;  
        this.userAccount = userAccount;  
        this.userName = userName;  
        this.userPassword = userPassword;  
        this.userDesc = userDesc;  
        this.enabled = enabled;  
        this.issys = issys;  
        this.userDept = userDept;  
        this.userDuty = userDuty;  
        this.subSystem = subSystem;  
        this.userRole = UserRole;  
        this.password = userPassword;  
        this.username = userAccount;  
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));  
        this.accountNonExpired = accountNonExpired;  
        this.accountNonLocked = accountNonLocked;  
        this.credentialsNonExpired = credentialsNonExpired;  
    } 

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean getIssys() {
		return issys;
	}

	public void setIssys(boolean issys) {
		this.issys = issys;
	}

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	public String getUserDuty() {
		return userDuty;
	}

	public void setUserDuty(String userDuty) {
		this.userDuty = userDuty;
	}

	public String getSubSystem() {
		return subSystem;
	}

	public void setSubSystem(String subSystem) {
		this.subSystem = subSystem;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	
	
	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
	
	public int hashCode() {  
        int code = 9792;  
  
      //若该用户不是登录人员，则可以允许没有authorities。  
        if (null != getUsername() && null != getAuthorities()) {  
            for (GrantedAuthority authority : getAuthorities()) {  
  
                code = code * (authority.hashCode() % 7);  
            }  
        }  
  
        if (this.getPassword() != null) {  
            code = code * (this.getPassword().hashCode() % 7);  
        }  
  
        if (this.getUsername() != null) {  
            code = code * (this.getUsername().hashCode() % 7);  
        }  
  
        if (this.isAccountNonExpired()) {  
            code = code * -2;  
        }  
  
        if (this.isAccountNonLocked()) {  
            code = code * -3;  
        }  
  
        if (this.isCredentialsNonExpired()) {  
            code = code * -5;  
        }  
  
        if (this.isEnabled()) {  
            code = code * -7;  
        }  
  
        return code;  
    }  
	
	public boolean equals(Object rhs) {  
        if (!(rhs instanceof User) || (rhs == null)) {  
            return false;  
        }  
  
        User user = (User) rhs;  
  
        //具有的权限。  
        if (!authorities.equals(user.authorities)) {  
            return false;  
        }  
  
        // 通过Spring Security构建一个用户时，用户名和密码不能为空。  
        return (this.getPassword().equals(user.getPassword()) && this.getUsername().equals(user.getUsername())  
                && (this.isAccountNonExpired() == user.isAccountNonExpired())  
                && (this.isAccountNonLocked() == user.isAccountNonLocked())  
                && (this.isCredentialsNonExpired() == user.isCredentialsNonExpired())  
                && (this.isEnabled() == user.isEnabled()));  
    }  
	
	private static SortedSet<GrantedAuthority> sortAuthorities(Collection<GrantedAuthority> authorities) {  
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");  
        // Ensure array iteration order is predictable (as per UserDetails.getAuthorities() contract and SEC-717)  
        SortedSet<GrantedAuthority> sortedAuthorities =  
            new TreeSet<GrantedAuthority>(new AuthorityComparator());  
  
        for (GrantedAuthority grantedAuthority : authorities) {  
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");  
            sortedAuthorities.add(grantedAuthority);  
        }  
  
        return sortedAuthorities;  
    }
	
	private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {  
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {  
            // Neither should ever be null as each entry is checked before adding it to the set.  
            // If the authority is null, it is a custom authority and should precede others.  
            if (g2.getAuthority() == null) {  
                return -1;  
            }  
  
            if (g1.getAuthority() == null) {  
                return 1;  
            }  
            return g1.getAuthority().compareTo(g2.getAuthority());  
        }  
    } 
	
	 public String toString() {  
	        StringBuilder sb = new StringBuilder();  
	        sb.append(super.toString()).append(": ");  
	        sb.append("Username: ").append(this.username).append("; ");  
	        sb.append("" +  
	                "" +  
	                ": [PROTECTED]; ");  
	        sb.append("UserAccount: ").append(this.userAccount).append("; ");  
	        sb.append("UserDept: ").append(this.userDept).append("; ");  
	        sb.append("UserDuty: ").append(this.userDuty).append("; ");  
	        sb.append("UserDesc: ").append(this.userDesc).append("; ");  
	        sb.append("SubSystem: ").append(this.subSystem).append("; ");  
	        sb.append("UserIsSys: ").append(this.issys).append("; ");  
	        sb.append("Enabled: ").append(this.enabled).append("; ");  
	        sb.append("AccountNonExpired: ").append(this.accountNonExpired).append("; ");  
	        sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired).append("; ");  
	        sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");  
	  
	        if ( null !=authorities  && !authorities.isEmpty()) {  
	            sb.append("Granted Authorities: ");  
	  
	            boolean first = true;  
	            for (GrantedAuthority auth : authorities) {  
	                if (!first) {  
	                    sb.append(",");  
	                }  
	                first = false;  
	  
	                sb.append(auth);  
	            }  
	        } else {  
	            sb.append("Not granted any authorities");  
	        }  
	  
	        return sb.toString();  
	    }  
	

}
