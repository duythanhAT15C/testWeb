package com.example.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Role;

public interface RoleDAO {
	// Hàm lấy tất cả role
	public List<Role> getRoles();
	// Hàm lưu role
	public void saveRole(Role role);
	// Hàm lấy 1 role theo Id
	public Role getRole(int theId);
}
