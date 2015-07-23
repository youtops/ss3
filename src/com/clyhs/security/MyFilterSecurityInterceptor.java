package com.clyhs.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor
		implements Filter {
	private FilterInvocationSecurityMetadataSource securityMetadataSource; 

	@Override
	public Class<? extends Object> getSecureObjectClass() {
		// TODO Auto-generated method stub
		return FilterInvocation.class;
	}
	
	

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}



	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}



	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		// TODO Auto-generated method stub
		return this.securityMetadataSource;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		FilterInvocation fi = new FilterInvocation(request, response, chain);  
        invoke(fi); 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
     
	}
	
	public void invoke(FilterInvocation fi) throws IOException,  
    ServletException {  

        InterceptorStatusToken token = super.beforeInvocation(fi);  

        try {  
             fi.getChain().doFilter(fi.getRequest(), fi.getResponse());  
        } finally {  
            super.afterInvocation(token, null);  
        }  

    } 

}
