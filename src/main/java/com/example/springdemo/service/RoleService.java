package com.example.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Role;

public interface RoleService {
	public List<Role> getRoles();
	public void saveRole(Role role);
	public Role getRole(int theId);
}
