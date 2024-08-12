package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	// Hàm lấy tất cả role
	@Override
	public List<Role> getRoles() {
		Session session = sessionFactory.getCurrentSession();
		Query<Role> query = session.createQuery("from Role", Role.class);
		List<Role> list = query.getResultList();
		return list;
	}
	
	// Hàm lưu role
	@Override
	public void saveRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(role);
	}
	
	// Hàm lấy 1 role theo Id
	@Override
	public Role getRole(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.get(Role.class, theId);
		return role;
	}

}
