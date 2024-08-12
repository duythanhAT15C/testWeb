package com.example.springdemo.check;

import java.time.LocalDate;

public class CheckDate {
	// Hàm kiểm tra ngày kết thúc có trước ngày hiện tại hay không
	public static boolean teminatedDonation(LocalDate endDate, LocalDate now) {
		return endDate.isBefore(now);
	}
}
