package com.example.springdemo.service;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.DTO.DonationDTO;
import com.example.springdemo.dao.DonationDAO;
import com.luv2code.springdemo.entity.Donation;

@Service
public class DonationServiceImpl implements DonationService {
	@Autowired
	private DonationDAO donationDAO;

	@Override
	@Transactional
	public List<DonationDTO> getDonations() {
		List<DonationDTO> donationDTOs = new ArrayList<>();
		// Lấy dữ liệu format cho number ở vị trí là việt nam
		NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
		List<Donation> donations = donationDAO.getDonations();
		for (Donation donation2 : donations) {
			DonationDTO donationDTO = new DonationDTO();
			DateTimeFormatter dbFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			// định dạng lại start date và end date khi lấy từ CSDL ra theo định dạng mong muốn(dùng cho hiển thị ra màn hình)
			LocalDate startDateDb = LocalDate.parse(donation2.getStartDate(), dbFormatter); 
			LocalDate endDateDb = LocalDate.parse(donation2.getEndDate(), dbFormatter);
			String startDate = startDateDb.format(displayFormatter);
			String endDate = endDateDb.format(displayFormatter);
			donationDTO.setId(donation2.getId());
			donationDTO.setCode(donation2.getCode());
			donationDTO.setCreated(donation2.getCreated());
			donationDTO.setNoidung(donation2.getDescription());
			// Dùng cho lúc cập nhật thông tin
			donationDTO.setStart(donation2.getStartDate());
			donationDTO.setEnd(donation2.getEndDate());
			donationDTO.setFormatStartDate(startDate);
			donationDTO.setFormatEndDate(endDate);
			// định dạng lại kiểu hiển thị cho money
			String formattedMoney = formatter.format(donation2.getMoney());
			donationDTO.setFormatMoney(formattedMoney);
			donationDTO.setName(donation2.getName());
			donationDTO.setTochuc(donation2.getOrganizationName());
			donationDTO.setSdt(donation2.getPhoneNumber());
			donationDTO.setStatus(donation2.getStatus());
			donationDTO.setDeleteFlag(donation2.getDeleteFlag());
			donationDTOs.add(donationDTO);
		}
		return donationDTOs;
	}

	@Override
	@Transactional
	public DonationDTO getDonationDTO(int theId) {
		// Lấy dữ liệu format cho number ở vị trí là việt nam
		NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
		Donation donation = donationDAO.getDonation(theId);
		DonationDTO donationDTO = new DonationDTO();
		DateTimeFormatter dbFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate startDateDb = LocalDate.parse(donation.getStartDate(), dbFormatter);
		LocalDate endDateDb = LocalDate.parse(donation.getEndDate(), dbFormatter);
		// định dạng lại start date và end date khi lấy từ CSDL ra theo định dạng mong muốn(dùng cho hiển thị ra màn hình)
		String startDate = startDateDb.format(displayFormatter);
		String endDate = endDateDb.format(displayFormatter);
		donationDTO.setId(donation.getId());
		donationDTO.setCode(donation.getCode());
		donationDTO.setCreated(donation.getCreated());
		donationDTO.setNoidung(donation.getDescription());
		// Dùng cho lúc cập nhật thông tin
		donationDTO.setStart(donation.getStartDate());
		donationDTO.setEnd(donation.getEndDate());
		donationDTO.setFormatStartDate(startDate);
		donationDTO.setFormatEndDate(endDate);
		// định dạng lại kiểu hiển thị cho money
		String formattedMoney = formatter.format(donation.getMoney());
		donationDTO.setFormatMoney(formattedMoney);
		donationDTO.setName(donation.getName());
		donationDTO.setTochuc(donation.getOrganizationName());
		donationDTO.setSdt(donation.getPhoneNumber());
		donationDTO.setStatus(donation.getStatus());
		donationDTO.setDeleteFlag(donation.getDeleteFlag());
		return donationDTO;
	}

	@Override
	@Transactional
	public void saveDonation(DonationDTO donationDTO) {
		Donation donation = convertToEntity(donationDTO);
		donationDAO.saveDonation(donation);

	}
	@Override
	@Transactional
	public Donation convertToEntity(DonationDTO donationDTO) {
		if (donationDTO == null) {
			return null;
		}

//	    donation donation = donationDAO.getdonation(donationDTO.getId());
		Donation donation = new Donation();
		donation.setId(donationDTO.getId());
		donation.setCode(donationDTO.getCode());
		donation.setName(donationDTO.getName());
		donation.setStartDate(donationDTO.getStart());
		donation.setEndDate(donationDTO.getEnd());
		donation.setOrganizationName(donationDTO.getTochuc());
		donation.setPhoneNumber(donationDTO.getSdt());
		donation.setDescription(donationDTO.getNoidung());
		if (donationDTO.getId() == 0) {
			donation.setStatus(0);
			donation.setCreated("Mới tạo");
		} else {
			Donation donation2 = donationDAO.getDonation(donationDTO.getId());
			donation.setStatus(donation2.getStatus());
			donation.setMoney(donation2.getMoney());
			donation.setCreated(donation2.getCreated());
		}
		donation.setDeleteFlag(1);
		return donation;
	}

	@Override
	@Transactional
	public void changeStatus(int theId, String status) {
		donationDAO.changeStatus(theId, status);

	}

	@Override
	@Transactional
	public void changeDeleteFlag(int theId) {
		donationDAO.changeDeleteFlag(theId);

	}

	@Override
	@Transactional
	public List<DonationDTO> getDonations(int pageNumber, int pageSize) {
		List<DonationDTO> donationDTOs = new ArrayList<>();
		// Lấy dữ liệu format cho number ở vị trí là việt nam
		NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
		List<Donation> donations = donationDAO.getDonations(pageNumber, pageSize);
		for (Donation donation2 : donations) {
			DonationDTO donationDTO = new DonationDTO();
			DateTimeFormatter dbFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate startDateDb = LocalDate.parse(donation2.getStartDate(), dbFormatter);
			LocalDate endDateDb = LocalDate.parse(donation2.getEndDate(), dbFormatter);
			// định dạng lại start date và end date khi lấy từ CSDL ra theo định dạng mong muốn(dùng cho hiển thị ra màn hình)
			String startDate = startDateDb.format(displayFormatter);
			String endDate = endDateDb.format(displayFormatter);
			donationDTO.setId(donation2.getId());
			donationDTO.setCode(donation2.getCode());
			donationDTO.setCreated(donation2.getCreated());
			donationDTO.setNoidung(donation2.getDescription());
			// Dùng cho lúc cập nhật thông tin
			donationDTO.setStart(donation2.getStartDate());
			donationDTO.setEnd(donation2.getEndDate());
			donationDTO.setFormatStartDate(startDate);
			donationDTO.setFormatEndDate(endDate);
			// định dạng lại kiểu hiển thị cho money
			String formattedMoney = formatter.format(donation2.getMoney());
			donationDTO.setFormatMoney(formattedMoney);
			donationDTO.setName(donation2.getName());
			donationDTO.setTochuc(donation2.getOrganizationName());
			donationDTO.setSdt(donation2.getPhoneNumber());
			donationDTO.setStatus(donation2.getStatus());
			donationDTO.setDeleteFlag(donation2.getDeleteFlag());
			donationDTOs.add(donationDTO);
		}
		return donationDTOs;
	}

}
