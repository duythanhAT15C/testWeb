package com.example.springdemo.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.DTO.UserDonationDTO;
import com.example.springdemo.dao.DonationDAO;
import com.example.springdemo.dao.UserDAO;
import com.example.springdemo.dao.UserDonationDAO;
import com.luv2code.springdemo.entity.Donation;
import com.luv2code.springdemo.entity.User;
import com.luv2code.springdemo.entity.UserDonation;

@Service
public class UserDonationServiceImpl implements UserDonationService {
	@Autowired
	private UserDonationDAO userDonationDAO;
	@Autowired
	private DonationDAO donationDAO;
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public List<UserDonationDTO> getUserDonations(int donationId) {
		List<UserDonation> userDonations = userDonationDAO.getUserDonations(donationId);
		List<UserDonationDTO> userDonationDTOs = new ArrayList<>();
		// Lấy dữ liệu format cho number ở vị trí là việt nam
		NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));

		for (UserDonation userDonation : userDonations) {
			UserDonationDTO userDonationDTO = new UserDonationDTO();
			userDonationDTO.setId(userDonation.getId());
			userDonationDTO.setCreated(userDonation.getCreated().toString());
			userDonationDTO.setMoney(userDonation.getMoney());
			userDonationDTO.setName(userDonation.getName());
			userDonationDTO.setStatus(userDonation.getStatus());
			userDonationDTO.setText(userDonation.getText());
			userDonationDTO.setDonationDate(userDonation.getDonationDate().toString());
			userDonationDTO.setDonationId(userDonation.getDonation().getId());
			userDonationDTO.setUserId(userDonation.getUser().getId());

			String formattedMoney = formatter.format(userDonation.getMoney());
			userDonationDTO.setFormattedMoney(formattedMoney);

			// Thêm DTO vào danh sách kết quả
			userDonationDTOs.add(userDonationDTO);
		}

		return userDonationDTOs;
	}

	@Override
	@Transactional
	public List<UserDonationDTO> getUserDonationsFromDonationID(int idDonation) {
		List<UserDonation> userDonations = userDonationDAO.getUserDonationsFromDonationID(idDonation);
		List<UserDonationDTO> userDonationDTOs = new ArrayList<>();
		// Lấy dữ liệu format cho number ở vị trí là việt nam
		NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));

		for (UserDonation userDonation : userDonations) {
			UserDonationDTO userDonationDTO = new UserDonationDTO();
			userDonationDTO.setId(userDonation.getId());
			userDonationDTO.setCreated(userDonation.getCreated().toString());
			userDonationDTO.setMoney(userDonation.getMoney());
			userDonationDTO.setName(userDonation.getName());
			userDonationDTO.setStatus(userDonation.getStatus());
			userDonationDTO.setText(userDonation.getText());
			userDonationDTO.setDonationDate(userDonation.getDonationDate().toString());
			userDonationDTO.setDonationId(userDonation.getDonation().getId());
			userDonationDTO.setUserId(userDonation.getUser().getId());

			String formattedMoney = formatter.format(userDonation.getMoney());
			userDonationDTO.setFormattedMoney(formattedMoney);

			// Thêm DTO vào danh sách kết quả
			userDonationDTOs.add(userDonationDTO);
		}

		return userDonationDTOs;
	}

	@Override
	@Transactional
	public UserDonation getDonation(int theId) {
		return userDonationDAO.getDonation(theId);
	}

	// Hàm định dạng lại số tiền lấy ra từ CSDL và in ra màn hình theo format mong muốnn đối với user donation
	@Override
	@Transactional
	public String convertStringtoMoneyUserDonation(int theId) {
		UserDonation userDonation = userDonationDAO.getDonation(theId);
		if (userDonation != null) {
			try {
				int money = userDonation.getMoney();
				DecimalFormat decimalFormat = new DecimalFormat("#,###");
				return decimalFormat.format(money);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return "";
	}

	@Override
	@Transactional
	public void save(UserDonationDTO userDonationDTO) {
		UserDonation userDonation = convertToEntity(userDonationDTO);
		userDonationDAO.save(userDonation);
	}

	private UserDonation convertToEntity(UserDonationDTO userDonationDTO) {
		if (userDonationDTO == null) {
			return null;
		}

//	    User user = userDAO.getUser(userDTO.getId());
		UserDonation userDonation = new UserDonation();
		userDonation.setId(userDonationDTO.getId());
		userDonation.setCreated("Donate chưa thành công");
		userDonation.setMoney(userDonationDTO.getMoney());
		userDonation.setName(userDonationDTO.getName());
		userDonation.setStatus("Chờ xác nhận");
		userDonation.setText(userDonationDTO.getText().trim());
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dateString = localDate.format(dateTimeFormatter);
		userDonation.setDonationDate(dateString);
		User user = userDAO.getUser(userDonationDTO.getUserId());
		Donation donation = donationDAO.getDonation(userDonationDTO.getDonationId());
		userDonation.setDonation(donation);
		userDonation.setUser(user);
		return userDonation;
	}

	// Hàm định dạng lại số tiền lấy ra từ CSDL và in ra màn hình theo format mong muốn đối với donation
	@Override
	@Transactional
	public String convertStringtoMoneyDonation(int theId) {
		UserDonation userDonation = userDonationDAO.getDonation(theId);
		if (userDonation != null) {
			try {
				int money = userDonation.getMoney();
				DecimalFormat decimalFormat = new DecimalFormat("#,###");
				return decimalFormat.format(money);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return "aaa";
	}

	@Override
	@Transactional
	public void changeStatusConfirm(int theId) {
		userDonationDAO.changeStatusConfirm(theId);

	}

	@Override
	@Transactional
	public void changeStatusUndo(int theId) {
		userDonationDAO.changeStatusUndo(theId);
		
	}

}
