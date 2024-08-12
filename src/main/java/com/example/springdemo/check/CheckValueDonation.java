package com.example.springdemo.check;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class CheckValueDonation {
	// Check tất cả các trường nếu trong CSDL có dữ liệu
	public static void resultValueAll(boolean checkCodeExist, boolean checkDateExist, boolean checkDateNow,
			boolean checkPhone, boolean checkSuccess, RedirectAttributes redirectAttributes) {
		// Check code xem đã tồn tại hay chưa
		// Check ngày kết thúc có sau ngày bắt đầu hay không bởi biến checkDateExist
		// Check số điện thoại xem hợp lệ hay không bởi biến checkPhone
		// Check ngày bắt đầu và ngày kết thúc có sau ngày hiện tại hay không bởi biến checkDateNow
		if (checkCodeExist && checkDateExist && checkPhone && checkDateNow) {
			redirectAttributes.addFlashAttribute("addDonationCodeAndDateFalse", "Dữ liệu nhập không đúng");
		} else if (checkCodeExist) {
			redirectAttributes.addFlashAttribute("addDonationCodeFalse", "Mã đợt quyên góp đã tồn tại");
		} else if (checkDateExist) {
			redirectAttributes.addFlashAttribute("addDonationDateFalse", "Ngày bắt đầu phải trước ngày kết thúc");
		} else if (checkDateNow) {
			redirectAttributes.addFlashAttribute("addDonationDateNowFalse",
					"Ngày bắt đầu và kết thúc phải sau ngày hôm nay");
		} else if (checkPhone) {
			redirectAttributes.addFlashAttribute("addPhoneFalse", "Số điện thoại không hợp lệ");
		}
	}

	// Check tất cả các trường nếu trong CSDL không có dữ liệu, không cần check code
	public static void resultValueListIsEmpty(boolean checkDateExist, boolean checkDateNow, boolean checkPhone,
			boolean checkSuccess, RedirectAttributes redirectAttributes) {
		// Check ngày kết thúc có sau ngày bắt đầu hay không bởi biến checkDateExist
		// Check số điện thoại xem hợp lệ hay không bởi biến checkPhone
		// Check ngày bắt đầu và ngày kết thúc có sau ngày hiện tại hay không bởi biến checkDateNow
		if (checkDateExist && checkPhone && checkDateNow) {
			redirectAttributes.addFlashAttribute("addDonationCodeAndDateFalse", "Dữ liệu nhập không đúng");
		} else if (checkDateExist) {
			redirectAttributes.addFlashAttribute("addDonationDateFalse", "Ngày bắt đầu phải trước ngày kết thúc");
		} else if (checkDateNow) {
			redirectAttributes.addFlashAttribute("addDonationDateNowFalse",
					"Ngày bắt đầu và kết thúc phải sau ngày hôm nay");
		} else if (checkPhone) {
			redirectAttributes.addFlashAttribute("addPhoneFalse", "Số điện thoại không hợp lệ");
		}
	}
}
