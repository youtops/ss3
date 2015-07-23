package com.clyhs.service.impl;

import java.util.List;

import com.clyhs.beans.Authority;
import com.clyhs.dao.AuthorityDao;
import com.clyhs.service.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService<Authority> {

	private AuthorityDao authorityDao;
	@Override
	public List<Authority> getAll() {
		// TODO Auto-generated method stub
		return authorityDao.getAll();
	}
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

}
