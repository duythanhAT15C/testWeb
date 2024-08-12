package com.example.springdemo.check;

public class CheckValuePassword {
	// Check password có đủ mạnh hay không
	public static boolean isValidPassword(String str) {
		return str.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
	}
}
