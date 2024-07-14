package com.memberCoupon.model;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberCouponVO implements java.io.Serializable{
	private Integer memberCouponID;
	private Integer memberID;
	private Integer couponID;
	private Date memberCouponExpirationDate;
	private Integer memberCoupoStatus;
	private Timestamp memberCouponCreateTime;
	
	public Integer getMemberCouponID() {
		return memberCouponID;
	}
	public void setMemberCouponID(Integer memberCouponID) {
		this.memberCouponID = memberCouponID;
	}
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public Integer getCouponID() {
		return couponID;
	}
	public void setCouponID(Integer couponID) {
		this.couponID = couponID;
	}
	public Date getMemberCouponExpirationDate() {
		return memberCouponExpirationDate;
	}
	public void setMemberCouponExpirationDate(Date memberCouponExpirationDate) {
		this.memberCouponExpirationDate = memberCouponExpirationDate;
	}
	public Integer getMemberCoupoStatus() {
		return memberCoupoStatus;
	}
	public void setMemberCoupoStatus(Integer memberCoupoStatus) {
		this.memberCoupoStatus = memberCoupoStatus;
	}
	public Timestamp getMemberCouponCreateTime() {
		return memberCouponCreateTime;
	}
	public void setMemberCouponCreateTime(Timestamp memberCouponCreateTime) {
		this.memberCouponCreateTime = memberCouponCreateTime;
	}
	
}
