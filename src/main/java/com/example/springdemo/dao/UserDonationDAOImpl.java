package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.UserDonation;

@Repository
public class UserDonationDAOImpl implements UserDonationDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DonationDAO donationDAO;

	// Hàm lấy danh sách user donation theo id của user đã donate
	@Override
	public List<UserDonation> getUserDonations(int userDonation) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserDonation> query = session.createQuery("from UserDonation where id=:donationId", UserDonation.class);
		query.setParameter("donationId", userDonation);
		List<UserDonation> list = query.getResultList();
		return list;
	}

	// Hàm lấy danh sách user donation theo id của đợt quyên góp
	@Override
	public List<UserDonation> getUserDonationsFromDonationID(int idDonation) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserDonation> query = session.createQuery("from UserDonation where donation_id=:donationId",
				UserDonation.class);
		query.setParameter("donationId", idDonation);
		List<UserDonation> list = query.getResultList();
		return list;
	}

	// Hàm lấy 1 user donation theo ID
	@Override
	public UserDonation getDonation(int theId) {
		Session session = sessionFactory.getCurrentSession();
		UserDonation userDonation = session.get(UserDonation.class, theId);
		return userDonation;
	}

	// Hàm lưu user donation
	@Override
	public void save(UserDonation userDonation) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userDonation);
	}

	// Hàm thay đổi status của user donation nếu admin ấn nút xác nhận
	@Override
	public void changeStatusConfirm(int theId) {
		Session session = sessionFactory.getCurrentSession();
		UserDonation userDonation = session.get(UserDonation.class, theId);
		if (userDonation.getStatus().equals("Chờ xác nhận") || userDonation.getStatus().equals("Huỷ xác nhận")) {
			userDonation.setStatus("Đã xác nhận");
			userDonation.setCreated("Donate thành công");
			session.save(userDonation);
			donationDAO.changeMoney(userDonation.getDonation().getId(), userDonation.getMoney(), "Chờ xác nhận");
		}

	}

	// Hàm thay đổi status của user donation nếu admin ấn nút huỷ xác nhận
	@Override
	public void changeStatusUndo(int theId) {
		Session session = sessionFactory.getCurrentSession();
		UserDonation userDonation = session.get(UserDonation.class, theId);
		if (userDonation.getStatus().equals("Đã xác nhận")) {
			userDonation.setStatus("Huỷ xác nhận");
			userDonation.setCreated("Donate không thành công");
			session.save(userDonation);
			donationDAO.changeMoney(userDonation.getDonation().getId(), userDonation.getMoney(), "Đã xác nhận");
		}
		
	}

}
