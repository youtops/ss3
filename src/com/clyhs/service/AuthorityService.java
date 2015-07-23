package com.clyhs.service;

import java.util.List;

import com.clyhs.beans.Authority;
import com.clyhs.dao.AuthorityDao;

public interface AuthorityService<T extends Authority> {
	
	
	List<Authority> getAll();
}
