package com.luv2code.springdemo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springdemo.DTO.DonationDTO;
import com.example.springdemo.DTO.UserDTO;
import com.example.springdemo.check.CheckPhoneNumber;
import com.example.springdemo.check.CheckValueDonation;
import com.example.springdemo.service.DonationService;
import com.example.springdemo.service.UserDonationService;

@Controller
@RequestMapping("/ql-donation")
public class DonationManagementController {
	@Autowired
	private DonationService donationService;
	@Autowired
	private UserDonationService userDonationService;
	
	// Hàm để vào trang admin/donation
	@RequestMapping("/donate")
	public String donate(@RequestParam("idD") int theId) {
		donationService.changeStatus(theId, "donate");
		return "redirect:/admin/donation";
	}

	// Hàm để kết thúc 1 đợt quyên góp
	@RequestMapping("/teminate")
	public String terminate(@RequestParam("idD") int theId) {
		donationService.changeStatus(theId, "teminate");
		return "redirect:/admin/donation";
	}

	// Hàm để đóng 1 đợt quyên góp
	@RequestMapping("/close")
	public String close(@RequestParam("idD") int theId) {
		donationService.changeStatus(theId, "close");
		return "redirect:/admin/donation";
	}

	// Hàm để tạo attribute khi mở popup thêm donation
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("donationAdd", new UserDTO());
		return "donationAdd/add";
	}

	// Hàm để lưu dữ liệu khi người dùng nhập xong dữ liệu
	@PostMapping("/add")
	public String addDonation(@ModelAttribute("donationAdd") DonationDTO donationDTO,
			RedirectAttributes redirectAttributes) {
		List<DonationDTO> donationDTOs = donationService.getDonations();
		LocalDate startDate = LocalDate.parse(donationDTO.getStart());
		LocalDate endDate = LocalDate.parse(donationDTO.getEnd());
		LocalDate nowDate = LocalDate.now();
		boolean checkCodeExist = false; // biến check code xem đã tồn tại chưa
		boolean checkDateExist = false; // biến check xem ngày bắt đầu có trước ngày kết thúc không
		boolean checkDateNow = false; // biến check xem ngày bắt đầu và kết thúc có sau ngày hôm nay không
		boolean checkSuccess = false; // biến cho phép lưu nếu các tất cả các điều kiện kiểm tra đã đúng
		boolean checkPhone = false; // biến check số điện thoại có hợp lệ không
		if (donationDTOs.isEmpty()) {
			if (endDate.isBefore(startDate)) {
				checkDateExist = true;
			} else if (endDate.isBefore(nowDate) || startDate.isBefore(nowDate)) {
				checkDateNow = true;
			} else if (!CheckPhoneNumber.isValidPhoneNumber(donationDTO.getSdt())) {
				checkPhone = true;
			} else {
				checkSuccess = true;
			}
			CheckValueDonation.resultValueListIsEmpty(checkDateExist, checkDateNow, checkPhone, checkSuccess,
					redirectAttributes);
			if (checkSuccess) {
				redirectAttributes.addFlashAttribute("addDonationSuccess", "Thêm đợt quyên góp thành công");
				donationService.saveDonation(donationDTO);
				return "redirect:/admin/donation";
			}
		}
		for (DonationDTO donationDTO2 : donationDTOs) {

			if (donationDTO2.getCode().equals(donationDTO.getCode())) {
				checkCodeExist = true;
			} else if (endDate.isBefore(startDate)) {
				checkDateExist = true;
			} else if (endDate.isBefore(nowDate) || startDate.isBefore(nowDate)) {
				checkDateNow = true;
			} else if (!CheckPhoneNumber.isValidPhoneNumber(donationDTO.getSdt())) {
				checkPhone = true;
			} else {
				checkSuccess = true;
			}
		}
		CheckValueDonation.resultValueAll(checkCodeExist, checkDateExist, checkDateNow, checkPhone, checkSuccess,
				redirectAttributes);
		if (checkSuccess) {
			redirectAttributes.addFlashAttribute("addDonationSuccess", "Thêm đợt quyên góp thành công");
			donationService.saveDonation(donationDTO);
		}
		return "redirect:/admin/donation";
	}

	// Hàm để tạo attribute khi mở popup cập nhật donation
	@GetMapping("/update")
	public String showUpdateForm(Model model, @RequestParam("id") int theId) {
		DonationDTO donation = donationService.getDonationDTO(theId);
		model.addAttribute("donationUpdate", donation);
		return "donationUpdate/update";
	}

	// Hàm để lưu dữ liệu khi người dùng nhập xong dữ liệu
	@PostMapping("/update")
	public String updateDonation(@ModelAttribute("donationUpdate") DonationDTO donationDTO) {
		donationService.saveDonation(donationDTO);
		return "redirect:/admin/donation";
	}

	// Hàm xoá 1 donation bằng cách cập nhật biến delete flag từ 1 thành 0 thay vì xoá hoàn toàn
	@RequestMapping("/delete")
	public String delete(@RequestParam("idUserDonation") int theId) {
		donationService.changeDeleteFlag(theId);
		return "redirect:/admin/donation";
	}

	// Hàm xác nhận người dùng donate
	@RequestMapping("/confirm")
	public String confirm(@RequestParam("idUserDonationConfirm") int theId, @RequestParam("idDonationConfirm") int theIdDonation, Model mode, RedirectAttributes redirectAttributes) {
		userDonationService.changeStatusConfirm(theId);
		mode.addAttribute("confirmSuccess", "Success");
		redirectAttributes.addFlashAttribute("confirmSuccessfully", "Xác nhận thành công");
		return String.format("redirect:/admin/detail/%d", theIdDonation);
	}
	
	// Hàm huỷ xác nhận người dùng donate
	@RequestMapping("/undo")
	public String undo(@RequestParam("idUserDonationUndo") int theId, @RequestParam("idDonationUndo") int theIdDonation, Model mode, RedirectAttributes redirectAttributes) {
		userDonationService.changeStatusUndo(theId);
		mode.addAttribute("undoSuccess", "Success");
		redirectAttributes.addFlashAttribute("undoSuccessfully", "Huỷ xác nhận thành công");
		return String.format("redirect:/admin/detail/%d", theIdDonation);
	}
}
