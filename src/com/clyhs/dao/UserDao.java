package com.clyhs.dao;

import java.io.Serializable;

import com.clyhs.beans.User;

public interface UserDao extends BaseDao<User,Serializable> {

	public User findUserByAccount(String userAccount);
}
