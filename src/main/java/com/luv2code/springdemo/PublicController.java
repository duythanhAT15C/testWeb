package com.luv2code.springdemo;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springdemo.DTO.DonationDTO;
import com.example.springdemo.DTO.UserDonationDTO;
import com.example.springdemo.service.DonationService;
import com.example.springdemo.service.UserDonationService;
import com.luv2code.springdemo.entity.User;
import com.luv2code.springdemo.entity.UserDonation;

@Controller
@RequestMapping("/public")
public class PublicController {
	@Autowired
	private DonationService donationService;
	@Autowired
	private UserDonationService userDonationService;

	// Hàm để hiển thị danh sách các đợt quyên góp và phân trang
	@RequestMapping("/")
	public String showPage(Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "5") int size) {
		List<DonationDTO> listSize = donationService.getDonations();
		List<DonationDTO> filteredListSize = new ArrayList<>();
		for (DonationDTO donation : listSize) {
	        if (donation.getDeleteFlag() != 0) {
	            filteredListSize.add(donation);
	        }
	    }
		int totalDonations = filteredListSize.size();
		if (totalDonations == 0) {
			model.addAttribute("donationNone", "Không có đợt quyên góp nào");
			return "public/home";
		}
		int pageNumber = (page < 1) ? 1 : page;
		int pageSize = (size < 1) ? 5 : size;
		List<DonationDTO> list = donationService.getDonations(pageNumber, pageSize);
		List<DonationDTO> filteredList = new ArrayList<>();
		for (DonationDTO donationDTO : list) {
			if(donationDTO.getDeleteFlag() != 0) {
				filteredList.add(donationDTO);
			}
		}
		int totalPages = (int) Math.ceil((double) totalDonations / pageSize);
		if (pageNumber < 1 || pageNumber > totalPages) {
			return "redirect:/public/";
		}
		model.addAttribute("list", list);
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalPages", totalPages);
		return "public/home";
	}

	// Hàm để đăng nhập
	@GetMapping("/login")
	public String logout() {
		return "redirect:/login/";
	}

	// Hàm để đăng xuất
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/public/";
	}

	// Hàm mở chi tiết của 1 đợt quyên góp
	@RequestMapping("/detail")
	public String showDetail() {
		return "public/detail";
	}

	// Hàm mở chi tiết của 1 đợt quyên góp với id
	@GetMapping("/detail/{donationId}")
	public String showDetail(@PathVariable("donationId") int theId, Model model, HttpSession session) {
		DonationDTO donation = donationService.getDonationDTO(theId);
		model.addAttribute("donationDetail", donation);
		List<UserDonationDTO> list = userDonationService.getUserDonationsFromDonationID(theId);
		model.addAttribute("list", list);
		UserDonation userDonation = userDonationService.getDonation(theId);
		model.addAttribute("donation", userDonation);
		model.addAttribute("userDonation", userDonation);
		return "public/detail";
	}

	// Hàm để donate 1 đợt quyên góp khi xem chi tiết đợt quyên góp đó
	@PostMapping("/detail/{donationId}")
	public String donate(@PathVariable("donationId") int theId, HttpServletRequest request,
			RedirectAttributes redirectAttributes, @ModelAttribute("userDonation") UserDonationDTO userDonationDTO) {
		boolean test = true;
		if (test) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user == null) {
				redirectAttributes.addFlashAttribute("msgDetailFalse", "Bạn cần đăng nhập để quyên góp.");
				return "redirect:/public/detail/{donationId}";
			} else if (userDonationDTO.getMoney() < 1000) {
				redirectAttributes.addFlashAttribute("msgMoneyFalse", "Bạn phải nhập số tiền lớn hơn 1000 VNĐ");
				return "redirect:/public/detail/{donationId}";
			}
			userDonationDTO.setDonationId(theId);
			userDonationDTO.setUserId(user.getId());
			userDonationService.save(userDonationDTO);
			redirectAttributes.addFlashAttribute("msgDetailId", "Donate thành công, bạn cần phải chờ xác nhận");
		} else {
			redirectAttributes.addFlashAttribute("msgDetailId", "Donate failed");
		}

		return "redirect:/public/detail/{donationId}";
	}

	// Hàm để add attribute khi mở popup quyên góp
	@GetMapping("/donate")
	private String showFormDonate(Model model) {
		model.addAttribute("userDonation", new UserDonationDTO());
		return "userDonation/donate";
	}

	// Hàm thực hiện lưu thông tin người dùng donate
	@PostMapping("/donate")
	private String donate(@ModelAttribute("userDonation") UserDonationDTO userDonationDTO, HttpServletRequest request,
			RedirectAttributes redirectAttributes, @RequestParam("idDonation") int idDonation) {
		System.out.println("a");
		System.out.println(idDonation);
		boolean test = true;
		if (test) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user == null) {
				redirectAttributes.addFlashAttribute("msgDetailFalse", "Bạn cần đăng nhập để quyên góp.");
				return "redirect:/public/";
			} else if (userDonationDTO.getMoney() < 1000) {
				redirectAttributes.addFlashAttribute("msgMoneyFalse", "Bạn phải nhập số tiền lớn hơn 1000 VNĐ");
				return "redirect:/public/";
			}
			userDonationDTO.setDonationId(idDonation);
			userDonationDTO.setUserId(user.getId());
			userDonationService.save(userDonationDTO);
			redirectAttributes.addFlashAttribute("msgDonate", "Donate thành công, bạn cần phải chờ xác nhận");
		} else {
			redirectAttributes.addFlashAttribute("msgDonate", "Donate failed");
		}
		return "redirect:/public/";
	}
}
