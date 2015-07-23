package com.clyhs.dao;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

public interface MyUserDetails extends UserDetails {
	//�û�id  
    public Integer getUserId();  
    //�û��˻�  
    public String  getUserAccount();  
    //�û���  
    public String  getUserName();  
    //�û�����  
    public String  getUserPassword();  
    //�û���������  
    public String  getUserDesc();  
    //�û��Ƿ�����  
    public boolean getEnabled();  
    //�Ƿ񳬼��û�  
    public boolean getIssys();    
    //�����ĵ�λ  
    public String  getUserDept();  
    //�û�ְλ  
    public String  getUserDuty();  
    //�û��ֹܵ���ϵͳ  
    public String  getSubSystem();     
    //�û����Ӧ�Ľ�ɫ��  
    public Set getUserRole(); 
}
