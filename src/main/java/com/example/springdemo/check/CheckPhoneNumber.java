package com.example.springdemo.check;

public class CheckPhoneNumber {
	// Check số điện thoại có hợp lệ không
	public static boolean isValidPhoneNumber(String phoneNumber) {
		String regex = "((09|08|03|07|05)[0-9]{8})";
		return phoneNumber.matches(regex);
	}
}
