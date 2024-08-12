package com.example.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.UserDonation;

public interface UserDonationDAO {
	// Hàm lấy danh sách user donation theo id của user đã donate
	public List<UserDonation> getUserDonations(int userDonationId);
	// Hàm lấy danh sách user donation theo id của đợt quyên góp
	public List<UserDonation> getUserDonationsFromDonationID(int idDonation);
	// Hàm lấy 1 user donation theo ID
	public UserDonation getDonation(int theId);
	// Hàm lưu user donation
	public void save(UserDonation userDonation);
	// Hàm thay đổi status của user donation nếu admin ấn nút xác nhận
	public void changeStatusConfirm(int theId);
	// Hàm thay đổi status của user donation nếu admin ấn nút huỷ xác nhận
	public void changeStatusUndo(int theId);
}
