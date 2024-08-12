package com.luv2code.springdemo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springdemo.DTO.UserDTO;
import com.example.springdemo.check.CheckPhoneNumber;
import com.example.springdemo.check.CheckValuePassword;
import com.example.springdemo.service.UserService;
import com.luv2code.springdemo.entity.User;

@Controller
@RequestMapping("/ql-user")
public class UserManagementController {
	@Autowired
	private UserService userService;

	// Hàm để khoá user
	@RequestMapping("/lock")
	public String lock(@RequestParam("idUser") int theId) {
		userService.changeStatus(theId);
		return "redirect:/admin/account";
	}

	// Hàm để xoá user
	@RequestMapping("/delete")
	public String delete(@RequestParam("idUser") int theId, HttpSession session,
			RedirectAttributes redirectAttributes) {
		User currentUser = (User) session.getAttribute("user");
		if (currentUser != null && Integer.valueOf(currentUser.getId()).equals(theId)) {
			redirectAttributes.addFlashAttribute("deleteError", "Tài khoản đang đăng nhập, không thể xoá");
		} else {
			userService.changeDeleteFlag(theId);
			redirectAttributes.addFlashAttribute("deleteSuccess", "Xoá tài khoản thành công");
		}
		return "redirect:/admin/account";
	}

	// Hàm add attribute khi mở popup thêm user
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("userAdd", new UserDTO());
		return "userAdd/add";
	}

	// Hàm thực hiện lưu user khi người dùng nhập đầy đủ thông tin
	@PostMapping("/add")
	public String addUser(@ModelAttribute("userAdd") UserDTO userDTO, RedirectAttributes redirectAttributes,
			Model model) {
		List<User> users = userService.getUsers();
		boolean checkPhone = false; // check số điện thoại xem hợp lệ không
		boolean checkPass = false; // check pass xem có đủ mạnh kh
		boolean checkSuccess = false; // nếu các điều kiện đúng thì sẽ thêm thành công
		boolean userExists = false; // check xem user đó có tồn tại không
		if (users.isEmpty()) {
			if (!CheckPhoneNumber.isValidPhoneNumber(userDTO.getPhoneNumber())) {
				checkPhone = true;
			} else if (!CheckValuePassword.isValidPassword(userDTO.getPassword())) {
				checkPass = true;
			} else {
				checkSuccess = true;
			}

			if (checkPhone) {
				redirectAttributes.addFlashAttribute("addPhoneFalse", "Số điện thoại không hợp lệ");
			} else if (checkPass) {
				redirectAttributes.addFlashAttribute("addPassFalse", "Password chưa đủ mạnh");
			} else if (checkSuccess) {
				userService.saveUser(userDTO, "add");
				redirectAttributes.addFlashAttribute("addUserSuccess", "Thêm người dùng thành công");
			}
			return "redirect:/admin/account";
		}

		// Kiểm tra các điều kiện cơ bản
		if (!CheckPhoneNumber.isValidPhoneNumber(userDTO.getPhoneNumber())) {
			checkPhone = true;
		} else if (!CheckValuePassword.isValidPassword(userDTO.getPassword())) {
			checkPass = true;
		} else {
			// Kiểm tra các điều kiện trong danh sách người dùng
			for (User user : users) {
				// Nếu tìm thấy người dùng với email và username trùng khớp
				if (user.getEmail().equals(userDTO.getEmail())) {
					userExists = true;
					if (user.getDeleteFlag() == 0) {
						redirectAttributes.addFlashAttribute("addUserFalse", "Email đã được sử dụng");
					} else {
						redirectAttributes.addFlashAttribute("addUserFalse", "Email hoặc User Name đã tồn tại");
					}
					break; // Ngừng vòng lặp khi tìm thấy bản ghi
				}
			}
			// Nếu không tìm thấy người dùng và không có lỗi về phone hoặc password, lưu
			// người dùng mới
			if (!userExists) {
				userService.saveUser(userDTO, "add");
				redirectAttributes.addFlashAttribute("addUserSuccess", "Thêm người dùng thành công");
			}
		}
		if (checkPhone) {
			redirectAttributes.addFlashAttribute("addPhoneFalse", "Số điện thoại không hợp lệ");
		} else if (checkPass) {
			redirectAttributes.addFlashAttribute("addPassFalse", "Password chưa đủ mạnh");
		}
		return "redirect:/admin/account";
	}

	// Hàm để add attribute khi mở popup cập nhật
	@GetMapping("/update")
	public String showUpdateForm(Model model, @RequestParam("id") int theId) {
		User user = userService.getUser(theId);
		model.addAttribute("userUpdate", user);
		return "userUpdate/update";
	}

	// Hàm lưu thông tin người dùng thay đổi khi người dùng nhập đầy đủ vào form
	@PostMapping("/update")
	public String update(@ModelAttribute("userUpdate") UserDTO userDTO, RedirectAttributes redirectAttributes) {
		if (!CheckPhoneNumber.isValidPhoneNumber(userDTO.getPhoneNumber())) {
			redirectAttributes.addFlashAttribute("updatePhoneFalse", "Số điện thoại không đúng");
		} else {
			userService.saveUser(userDTO, "update");
			redirectAttributes.addFlashAttribute("updatePhoneSuccess", "Cập nhật thành công");
		}
		return "redirect:/admin/account";
	}
}
