package com.example.springdemo.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// Hàm lấy user theo email và password
	@Override
	public User getUser(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where email=:email and password=:password", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = query.uniqueResult();
		return user;
	}

	// Hàm lấy tất cả user
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User", User.class);
		List<User> list = query.getResultList();
		return list;
	}
	
	// Hàm lấy 1 user theo ID
	@Override
	public User getUser(int theId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, theId);
		return user;
	}

	// Hàm lưu user
	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.clear();
		session.saveOrUpdate(user);
	}

	// Hàm thay đổi status của user theo ID
	@Override
	public void changeStatus(int theId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, theId);
		if (user.getStatus() == 1) {
			user.setStatus(0);
		} else {
			user.setStatus(1);
		}
		session.update(user);
	}

	// Hàm thay đổi delete flag của user theo ID(delete flag là biến cho biết user có xoá không)
	// Nếu bằng 0 thì là đã xoá, nếu bằng 1 thì chưa xoá
	@Override
	public void changeDeleteFlag(int theId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, theId);
		user.setDeleteFlag(0);
		session.update(user);
	}

	// Hàm thay đổi created của user
	@Override
	public void changeCreated(int theId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, theId);
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dateString = localDateTime.format(dateTimeFormatter);
		user.setCreated(dateString);
		session.update(user);

	}

}
