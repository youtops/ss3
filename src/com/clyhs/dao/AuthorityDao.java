package com.clyhs.dao;

import java.io.Serializable;
import java.util.List;

import com.clyhs.beans.Authority;

public interface AuthorityDao extends BaseDao<Authority, Serializable> {

	List<Authority> getAll();
}
