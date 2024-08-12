package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.DTO.UserDonationDTO;
import com.luv2code.springdemo.entity.UserDonation;

public interface UserDonationService {
	public List<UserDonationDTO> getUserDonations(int userDonationId);
	public List<UserDonationDTO> getUserDonationsFromDonationID(int idDonation);
	public UserDonation getDonation(int theId);
	public String convertStringtoMoneyUserDonation(int theId);
	public void save(UserDonationDTO userDonationDTO);
	public String convertStringtoMoneyDonation(int theId);
	public void changeStatusConfirm(int theId);
	public void changeStatusUndo(int theId);
}
