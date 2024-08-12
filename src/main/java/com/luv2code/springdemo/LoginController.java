package com.luv2code.springdemo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springdemo.service.UserService;
import com.luv2code.springdemo.entity.User;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;

	// Hàm tạo attribute khi người dùng đăng nhập
	@RequestMapping("/")
	public String formLogin(Model model, @RequestParam(value = "error", required = false) String error) {
		model.addAttribute("adminLogin", new User());
		if (error != null) {
			model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
		}
		return "admin/login";
	}

	// Hàm kiểm tra xem email và pass có trùng khớp không, nếu có thì kiểm tra xem
	// đó là admin hay user, cuối cùng là kiểm tra xem user đó có bị xoá không bằng
	// việc kiểm tra biến delete flag
	// nếu delete flag = 0 thì ẩn đi(tức đã xoá), = 1 thì hiện lên(tức chưa xoá)
	@PostMapping("/")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			RedirectAttributes redirectAttributes, HttpSession session) {
		User user = userService.getUser(email, password);

		if (user == null || user.getStatus() == 0) {
			redirectAttributes.addAttribute("error", "true");
			return "redirect:/login/";
		}
		if (user.getRole().getId() == 1) {
			session.setAttribute("user", user);
			userService.changeCreated(user.getId());
			return "redirect:/admin/";
		} else {
			if (user.getDeleteFlag() == 0) {
				redirectAttributes.addAttribute("error", "true");
				return "redirect:/login/";
			} else {
				session.setAttribute("user", user);
				userService.changeCreated(user.getId());
				return "redirect:/public/";
			}
		}
	}

}
