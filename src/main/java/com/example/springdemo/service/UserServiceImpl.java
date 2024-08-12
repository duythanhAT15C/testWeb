package com.example.springdemo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.DTO.UserDTO;
import com.example.springdemo.dao.RoleDAO;
import com.example.springdemo.dao.UserDAO;
import com.luv2code.springdemo.entity.Role;
import com.luv2code.springdemo.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;

	@Override
	@Transactional
	public User getUser(String email, String password) {
		return userDAO.getUser(email, password);
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int theId) {
		return userDAO.getUser(theId);
	}

	@Override
	@Transactional
	public void saveUser(UserDTO userDTO, String addOrUpdate) {
		User user = convertToEntity(userDTO, addOrUpdate);
		userDAO.saveUser(user);
	}

	@Override
	@Transactional
	public void changeStatus(int theId) {
		userDAO.changeStatus(theId);

	}

	@Override
	@Transactional
	public void changeDeleteFlag(int theId) {
		userDAO.changeDeleteFlag(theId);

	}

	// Hàm chuyển từ DTO sang entity
	private User convertToEntity(UserDTO userDTO, String addOrUpdate) {
		if (userDTO == null) {
			return null;
		}

//	    User user = userDAO.getUser(userDTO.getId());
		User user = new User();
		user.setId(userDTO.getId());
		user.setFullName(userDTO.getFullName());
		user.setEmail(userDTO.getEmail());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setAddress(userDTO.getAddress());
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());
		Role role = roleDAO.getRole(userDTO.getIdRole());
		if (role == null) {
			// Nếu không tìm thấy Role, có thể thông báo lỗi hoặc thêm mới Role nếu cần
			// thiết
			throw new RuntimeException("Không tìm thấy Role với id: " + userDTO.getIdRole());
		}
		user.setRole(role);
		if (userDTO.getId() == 0) {
			user.setStatus(1);
		} else {
			User user2 = userDAO.getUser(userDTO.getId());
			user.setStatus(user2.getStatus());
		}
		String dateString = "";
		// biến addOrUpdate dùng để xem người dùng đang tạo mới hay cập nhật
		if (addOrUpdate.equals("add")) {
			dateString = "Mới tạo";
			// Nếu người dùng chọn user thì là người dùng thường
			if (userDTO.getIdRole() == 1) {
				user.setNote("Người dùng thường");
			// Nếu người dùng chọn admin thì là người dùng VIP
			} else if (userDTO.getIdRole() == 2) {
				user.setNote("Người dùng VIP");
			}
		} else if (addOrUpdate.equals("update")) {
			User userInDB = userDAO.getUser(userDTO.getId());
			dateString = userInDB.getCreated();
			// Nếu người dùng chọn admin mà trong CSLD là người dùng thường thì đổi thành người dùng VIP
			if (userDTO.getIdRole() == 1) {
				user.setNote("Người dùng VIP");
				// Nếu người dùng chọn user mà trong CSLD là người dùng VIP thì đổi thành người dùng thường
			} else if (userDTO.getIdRole() == 2) {
				user.setNote("Người dùng thường");
			}
		}
		user.setCreated(dateString);
		// Delete flag = 1 tức là người dùng còn tồn tại
		user.setDeleteFlag(1);
		return user;
	}

	@Override
	@Transactional
	public void changeCreated(int theId) {
		userDAO.changeCreated(theId);

	}
}
