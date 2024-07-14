package com.member.model;


import java.sql.Date;
import java.sql.Timestamp;


public class MemberVO implements java.io.Serializable {
	private Integer memberID;
	private String memberAccount;
	private String memberPassword;
	private String memberName;
	private String memberPhone;
	private String memberNickName;
	private Integer memberStatus;
	private Timestamp memberCreateTime;
	private byte[] memberPicture;
	private Date birthday;
	private String memberAddress;
	private String gender;
	private String nationalID;

	public MemberVO() {
		super();
	}

	public MemberVO(Integer memberID, String memberAccount, String memberPassword, String memberName,
			String memberPhone, String memberNickName, Integer memberStatus, Timestamp memberCreateTime,
			byte[] memberPicture, Date birthday, String memberAddress, String gender, String nationalID) {
		
		super();
		this.memberID = memberID;
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberNickName = memberNickName;
		this.memberStatus = memberStatus;
		this.memberCreateTime = memberCreateTime;
		this.memberPicture = memberPicture;
		this.birthday = birthday;
		this.memberAddress = memberAddress;
		this.gender = gender;
		this.nationalID = nationalID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public Integer getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(Integer memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Timestamp getMemberCreateTime() {
		return memberCreateTime;
	}

	public void setMemberCreateTime(Timestamp memberCreateTime) {
		this.memberCreateTime = memberCreateTime;
	}

	public byte[] getMemberPicture() {
		return memberPicture;
	}

	public void setMemberPicture(byte[] memberPicture) {
		this.memberPicture = memberPicture;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

}
