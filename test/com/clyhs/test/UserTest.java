package com.clyhs.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.clyhs.beans.Role;
import com.clyhs.beans.User;
import com.clyhs.beans.UserRole;
import com.clyhs.util.HibernateUtils;

import junit.framework.TestCase;

public class UserTest extends TestCase {

	@SuppressWarnings("unchecked")
	public void add()
	{
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			
			
			
			User user = new User();
			user = (User) session.load(User.class, 1);
			Role role = new Role();
			role = (Role) session.load(Role.class, 1);
			
			UserRole userRole = new UserRole();
			userRole.setEnabled(true);
			userRole.setRole(role);
			userRole.setUser(user);
			
			session.save(userRole);
			
			
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}finally {
			HibernateUtils.closeSession(session);
		}
	}
}
