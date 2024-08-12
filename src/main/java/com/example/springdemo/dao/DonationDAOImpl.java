package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Donation;

@Repository
public class DonationDAOImpl implements DonationDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	// Hàm lấy tất cả donation
	@Override
	public List<Donation> getDonations() {
		Session session = sessionFactory.getCurrentSession();
		Query<Donation> query = session.createQuery("from Donation", Donation.class);
		List<Donation> list = query.getResultList();
		return list;
	}
	
	// Hàm lấy 1 donation theo ID
	@Override
	public Donation getDonation(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Donation donation = session.get(Donation.class, theId);
		return donation;
	}
	
	// Hàm lưu donation
	@Override
	public void saveDonation(Donation donation) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(donation);
	}

	// Hàm thay đổi status của donation
	@Override
	public void changeStatus(int theId, String status) {
		Session session = sessionFactory.getCurrentSession();
		Donation donation = session.get(Donation.class, theId);
		if (donation.getStatus() == 1) {
			if (status.equals("teminate")) {
				donation.setStatus(2);
				donation.setCreated("Kết thúc quyên góp");
			} else if (status.equals("close")) {
				donation.setStatus(3);
				donation.setCreated("Đóng quyên góp");
			}
		} else if (donation.getStatus() == 0) {
			donation.setStatus(1);
			donation.setCreated("Đang quyên góp");
		}
		session.update(donation);

	}

	// Hàm thay đổi delete flag của donation
	@Override
	public void changeDeleteFlag(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Donation donation = session.get(Donation.class, theId);
		donation.setDeleteFlag(0);
		session.update(donation);

	}
	
	// Hàm lấy tất cả donation để phân trang, với pageNumber là số trang, pageSize là số dòng trong 1 trang
	@Override
	public List<Donation> getDonations(int pageNumber, int pageSize) {
		Session session = sessionFactory.getCurrentSession();

		// Calculate the offset for pagination
		int offset = (pageNumber - 1) * pageSize;

		Query<Donation> query = session.createQuery("from Donation", Donation.class);
		query.setFirstResult(offset); // Set the first result to get
		query.setMaxResults(pageSize); // Set the max results to get
		List<Donation> list = query.getResultList();
		return list;
	}

	// Hàm thay đổi số tiền theo status, nếu là huỷ donate thì trừ tiền đi, xác nhận donate thì cộng tiền vào
	@Override
	public void changeMoney(int theId, int money, String status) {
		Session session = sessionFactory.getCurrentSession();
		Donation donation = getDonation(theId);
		if (donation != null) {
			if (status.equals("Chờ xác nhận") || status.equals("Huỷ xác nhận")) {
				int oldMoney = donation.getMoney();
				donation.setMoney(oldMoney + money);
				session.update(donation);
			}
			else if (status.equals("Đã xác nhận")) {
				int oldMoney = donation.getMoney();
				donation.setMoney(oldMoney - money);
				session.update(donation);
			}
		} else {
			// Xử lý trường hợp donation là null
			System.out.println("Donation không tìm thấy với ID: " + theId);
		}
	}

}
