package com.example.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.dao.RoleDAO;
import com.luv2code.springdemo.entity.Role;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDAO roleDAO; 
	@Override
	@Transactional
	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}
	@Override
	@Transactional
	public void saveRole(Role role) {
		roleDAO.saveRole(role);
	}
	@Override
	@Transactional
	public Role getRole(int theId) {
		return roleDAO.getRole(theId);
		
	}

}
