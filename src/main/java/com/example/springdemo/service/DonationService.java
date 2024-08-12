package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.DTO.DonationDTO;
import com.luv2code.springdemo.entity.Donation;


public interface DonationService {
	public List<DonationDTO> getDonations();
	public List<DonationDTO> getDonations(int pageNumber, int pageSize);
	public DonationDTO getDonationDTO(int theId);
	public void saveDonation(DonationDTO donationDTO);
	public void changeStatus(int theId, String status);
	public void changeDeleteFlag(int theId);
	public Donation convertToEntity(DonationDTO donationDTO);
}
