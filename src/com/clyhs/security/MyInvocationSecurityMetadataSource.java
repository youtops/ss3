package com.clyhs.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

import com.clyhs.beans.Authority;
import com.clyhs.beans.AuthorityResource;
import com.clyhs.service.AuthorityService;

public class MyInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	
	private AuthorityService authorityService;
	
	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	private UrlMatcher urlMatcher = new AntUrlPathMatcher();  
	  
    private static Map<String, Collection<ConfigAttribute>> resourceMap=null;  
  
    public MyInvocationSecurityMetadataSource() {  
        loadResourceDefine();  
    } 

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String url = ((FilterInvocation) object).getRequestUrl(); 
		System.out.println(getClass().getName() + "~~~~~~~~~" + url); 
		int firstQuestionMarkIndex = url.indexOf("?");  
		  
        if (firstQuestionMarkIndex != -1) {  
            url = url.substring(0, firstQuestionMarkIndex);  
            
        } 
        Iterator<String> ite = resourceMap.keySet().iterator();  
        while (ite.hasNext()) {  
            String resURL = ite.next();  
            if (urlMatcher.pathMatchesUrl(url, resURL)) {  
  
                return resourceMap.get(resURL);  
  
            }  
  
        } 
		//return null;
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private void loadResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>(); 
		
		List<Authority> AuthorityLists = new ArrayList<Authority>();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		
		//AuthorityLists = authorityService.getAll();
		AuthorityLists = session.createQuery("from Authority").list();
		for(Authority auth :AuthorityLists)
		{
			ConfigAttribute ca = new SecurityConfig(auth.getAuthorityName());
			Set<AuthorityResource> authorityResources = auth.getAuthorityResource();
			System.out.println("*******************************"+auth.getAuthorityName());
			for(AuthorityResource ar :authorityResources)
			{
				String url = ar.getResource().getResourceString();
				System.out.println("*******************************"+url);
				if (resourceMap.containsKey(url)) {
					 Collection<ConfigAttribute> value = resourceMap.get(url);
					 value.add(ca);
					 resourceMap.put(url, value);
					 System.out.println("key url"+url+":"+resourceMap.get(url));
				}else
				{
					Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();  
                    atts.add(ca);  
                    resourceMap.put(url, atts); 
                    System.out.println("key url"+url+":"+resourceMap.get(url));
				}
			}
		}
	}
	
	

}
