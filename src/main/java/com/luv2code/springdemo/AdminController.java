package com.luv2code.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.springdemo.DTO.DonationDTO;
import com.example.springdemo.DTO.UserDTO;
import com.example.springdemo.DTO.UserDonationDTO;
import com.example.springdemo.service.DonationService;
import com.example.springdemo.service.RoleService;
import com.example.springdemo.service.UserDonationService;
import com.example.springdemo.service.UserService;
import com.luv2code.springdemo.entity.Role;
import com.luv2code.springdemo.entity.User;
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private DonationService donationService;
	@Autowired
	private UserDonationService userDonationService;
	@Autowired
	private RoleService roleService;
	
	// Hàm hiển thị danh sách các account
    @GetMapping("/account")
    public String showAccountPage(Model model) {
    	// Lấy danh sách user
    	List<User> list = userService.getUsers();
    	// add attribute
    	model.addAttribute("list", list);
    	List<Role> listRoles = roleService.getRoles();
    	model.addAttribute("roleList", listRoles);
        return "admin/account";
    }

    // Hàm hiển thị danh sách các donate
    @GetMapping("/donation")
    public String showDonationPage(Model model) {
    	List<DonationDTO> list = donationService.getDonations();
    	model.addAttribute("list", list);
        return "admin/donation";
    }
    
    // Hàm để đăng xuất
    @GetMapping("/logout")
    public String logout() {
    	return "redirect:/login/";
    }
    
    // Hàm để vào trang home
    @GetMapping("/")
    public String admin(Model model) {
    	model.addAttribute("userAdd", new UserDTO());
    	return "admin/home";
    }
    
    // Hàm để vào trang chi tiết của 1 donation
    @GetMapping("/detail/{donationId}")
    public String detail(@PathVariable("donationId") int theId, Model model) {
    	DonationDTO donation = donationService.getDonationDTO(theId);
    	model.addAttribute("donationDetail", donation); // dùng để hiển thị danh sách các donation
    	List<UserDonationDTO> list = userDonationService.getUserDonationsFromDonationID(donation.getId());
    	model.addAttribute("userDonationList", list); // dùng để hiện thị danh sách các user đã donate
    	return "admin/detail";
    }
}
