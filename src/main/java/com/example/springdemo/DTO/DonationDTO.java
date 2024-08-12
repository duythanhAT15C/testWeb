package com.example.springdemo.DTO;

public class DonationDTO {
	private int id;
	private String code;
	private String name;
	private String start;
	private String end;
	private String tochuc;
	private String sdt;
	private String noidung;
	private String created;
	private int money;
	private String formatMoney;
	private String formatStartDate;
	private String formatEndDate;
	private int status;
	private int deleteFlag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getTochuc() {
		return tochuc;
	}
	public void setTochuc(String tochuc) {
		this.tochuc = tochuc;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * @return the formatMoney
	 */
	public String getFormatMoney() {
		return formatMoney;
	}
	/**
	 * @param formatMoney the formatMoney to set
	 */
	public void setFormatMoney(String formatMoney) {
		this.formatMoney = formatMoney;
	}
	
	
	/**
	 * @return the formatStartDate
	 */
	public String getFormatStartDate() {
		return formatStartDate;
	}
	/**
	 * @param formatStartDate the formatStartDate to set
	 */
	public void setFormatStartDate(String formatStartDate) {
		this.formatStartDate = formatStartDate;
	}
	/**
	 * @return the formatEndDate
	 */
	public String getFormatEndDate() {
		return formatEndDate;
	}
	/**
	 * @param formatEndDate the formatEndDate to set
	 */
	public void setFormatEndDate(String formatEndDate) {
		this.formatEndDate = formatEndDate;
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
	@Override
	public String toString() {
		return "DonationDTO [id=" + id + ", code=" + code + ", name=" + name + ", start=" + start + ", end=" + end
				+ ", tochuc=" + tochuc + ", sdt=" + sdt + ", noidung=" + noidung + ", created=" + created + ", money="
				+ money + ", formatMoney=" + formatMoney + ", formatStartDate=" + formatStartDate + ", formatEndDate="
				+ formatEndDate + ", status=" + status + ", deleteFlag=" + deleteFlag + "]";
	}


	
	
}
