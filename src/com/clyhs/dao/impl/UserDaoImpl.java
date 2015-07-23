package com.clyhs.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.clyhs.beans.User;
import com.clyhs.dao.BaseDao;
import com.clyhs.dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl<User, Serializable, UserDao> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByAccount(String userAccount) {
		// TODO Auto-generated method stub
		System.out.println("userdao:"+userAccount);
		List<User> list = getSession().createQuery(" from User u where u.userAccount=?")
		                  .setParameter(0, userAccount).list();
		
		if(list.size() > 0)
		{
			return list.get(0);
		}else
		{	
		    return null;
		}
	}
    
	
	
}
