package com.example.springdemo.DTO;

public class UserDonationDTO {
	private int id;
	private String created;
	private int money;
	private String name;
	private String status;
	private String text;
	private String donationDate;
	private String formattedMoney;
	private int donationId;
	private int userId;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the donationDate
	 */
	public String getDonationDate() {
		return donationDate;
	}

	/**
	 * @param donationDate the donationDate to set
	 */
	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}

	/**
	 * @return the donationId
	 */
	public int getDonationId() {
		return donationId;
	}

	/**
	 * @param donationId the donationId to set
	 */
	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

	/**
	 * @return the formattedMoney
	 */
	public String getFormattedMoney() {
		return formattedMoney;
	}

	/**
	 * @param formattedMoney the formattedMoney to set
	 */
	public void setFormattedMoney(String formattedMoney) {
		this.formattedMoney = formattedMoney;
	}

	@Override
	public String toString() {
		return "UserDonationDTO [id=" + id + ", created=" + created + ", money=" + money + ", name=" + name
				+ ", status=" + status + ", text=" + text + ", donationDate=" + donationDate + ", donationId="
				+ donationId + ", userId=" + userId + "]";
	}

}
