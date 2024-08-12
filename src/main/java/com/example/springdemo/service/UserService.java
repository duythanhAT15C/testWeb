package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.DTO.UserDTO;
import com.luv2code.springdemo.entity.User;


public interface UserService {
	public User getUser(String email, String password);
	public List<User> getUsers();
	public User getUser(int theId);
	public void saveUser(UserDTO userDTO, String addOrUpdate);
	public void changeStatus(int theId);
	public void changeDeleteFlag(int theId);
	public void changeCreated(int theId);
}
