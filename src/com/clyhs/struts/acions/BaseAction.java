package com.clyhs.struts.acions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8351135513970501272L;
	
	protected void setSession(String key,String value)
	{
		ActionContext.getContext().getSession().put(key,value);
	}
	
	protected Object getSession(String key)
	{
		return ActionContext.getContext().getSession().get(key);
	}

}
