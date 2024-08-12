package com.luv2code.springdemo.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "note")
	private String note;
	@Column(name = "status")
	private int status;
	@Column(name = "created")
	private String created;
	@Column(name = "delete_flag")
	private int deleteFlag;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private Role role;
	@OneToMany( mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<UserDonation> userDonations;
	public User() {

	}
	
	public User(String address, String email, String fullName, String note, String password, String phoneNumber,
			int status, String userName, String created) {
		super();
		this.address = address;
		this.email = email;
		this.fullName = fullName;
		this.note = note;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.userName = userName;
		this.created = created;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<UserDonation> getUserDonations() {
		return userDonations;
	}

	public void setUserDonations(List<UserDonation> userDonations) {
		this.userDonations = userDonations;
	}
	
	
	/**
	 * @return the deleteFlag
	 */
	public int getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public void add(UserDonation userDonation) {
		if(userDonations == null) {
			userDonations = new ArrayList<>();
		}
		userDonations.add(userDonation);
		userDonation.setUser(this);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", address=" + address + ", email=" + email + ", fullName=" + fullName + ", note="
				+ note + ", password=" + password + ", phoneNumber=" + phoneNumber + ", status=" + status
				+ ", userName=" + userName + ", created=" + created + ", role=" + role + ", userDonations="
				+ userDonations + "]";
	}
	
}
