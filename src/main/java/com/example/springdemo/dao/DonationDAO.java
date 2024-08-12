package com.example.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Donation;

public interface DonationDAO {
	// Hàm lấy tất cả donation
	public List<Donation> getDonations();
	// Hàm lấy tất cả donation để phân trang, với pageNumber là số trang, pageSize là số dòng trong 1 trang
	public List<Donation> getDonations(int pageNumber, int pageSize);
	// Hàm lấy 1 donation theo ID
	public Donation getDonation(int theId);
	// Hàm lưu donation
	public void saveDonation(Donation donation);
	// Hàm thay đổi status của donation
	public void changeStatus(int theId, String status);
	// Hàm thay đổi delete flag của donation
	public void changeDeleteFlag(int theId);
	// Hàm thay đổi số tiền theo status, nếu là huỷ donate thì trừ tiền đi, xác nhận donate thì cộng tiền vào
	public void changeMoney(int theId, int money, String status);
}
