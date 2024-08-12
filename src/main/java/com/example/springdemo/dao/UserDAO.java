package com.example.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.User;

public interface UserDAO {
	// Hàm lấy user theo email và password
	public User getUser(String email, String password);
	// Hàm lấy tất cả user
	public List<User> getUsers();
	// Hàm lấy 1 user theo ID
	public User getUser(int theId);
	// Hàm lưu user
	public void saveUser(User user);
	// Hàm thay đổi status của user theo ID
	public void changeStatus(int theId);
	// Hàm thay đổi delete flag của user theo ID(delete flag là biến cho biết user có xoá không)
	// Nếu bằng 0 thì là đã xoá, nếu bằng 1 thì chưa xoá
	public void changeDeleteFlag(int theId);
	// Hàm thay đổi created của user
	public void changeCreated(int theId);
}
