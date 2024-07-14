package com.partner.model;

import java.sql.Timestamp;

public class PartnerVO implements java.io.Serializable{
	private Integer partnerID;
	private String taxID;
	private String partnerName;
	private String partnerHeading;
	private String partnerAddress;
	private String partnerPhone;
	private String partnerContactPerson;
	private String partnerPassword;
	private String partnerEmail;
	private Timestamp partnerCreateTime;
	private Integer partnerAccountStatus;
	
	public Integer getPartnerID() {
		return partnerID;
	}
	public void setPartnerID(Integer partnerID) {
		this.partnerID = partnerID;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getPartnerHeading() {
		return partnerHeading;
	}
	public void setPartnerHeading(String partnerHeading) {
		this.partnerHeading = partnerHeading;
	}
	public String getPartnerAddress() {
		return partnerAddress;
	}
	public void setPartnerAddress(String partnerAddress) {
		this.partnerAddress = partnerAddress;
	}
	public String getPartnerPhone() {
		return partnerPhone;
	}
	public void setPartnerPhone(String partnerPhone) {
		this.partnerPhone = partnerPhone;
	}
	public String getPartnerContactPerson() {
		return partnerContactPerson;
	}
	public void setPartnerContactPerson(String partnerContactPerson) {
		this.partnerContactPerson = partnerContactPerson;
	}
	public String getPartnerPassword() {
		return partnerPassword;
	}
	public void setPartnerPassword(String partnerPassword) {
		this.partnerPassword = partnerPassword;
	}
	public String getPartnerEmail() {
		return partnerEmail;
	}
	public void setPartnerEmail(String partnerEmail) {
		this.partnerEmail = partnerEmail;
	}
	public Timestamp getPartnerCreateTime() {
		return partnerCreateTime;
	}
	public void setPartnerCreateTime(Timestamp partnerCreateTime) {
		this.partnerCreateTime = partnerCreateTime;
	}
	public Integer getPartnerAccountStatus() {
		return partnerAccountStatus;
	}
	public void setPartnerAccountStatus(Integer partnerAccountStatus) {
		this.partnerAccountStatus = partnerAccountStatus;
	}
}
