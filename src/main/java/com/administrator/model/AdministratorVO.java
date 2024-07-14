package com.administrator.model;

import java.sql.Timestamp;

public class AdministratorVO implements java.io.Serializable {
	private Integer administratorID;
	private String administratorAccount;
	private String administratorPassword;
	private Timestamp administratorCreateTime;
	private Integer administratorStatus;

	public AdministratorVO() {
		super();
	}

	public AdministratorVO(Integer administratorID, String administratorAccount, String administratorPassword,
			Timestamp administratorCreateTime, Integer administratorStatus) {
		super();
		this.administratorID = administratorID;
		this.administratorAccount = administratorAccount;
		this.administratorPassword = administratorPassword;
		this.administratorCreateTime = administratorCreateTime;
		this.administratorStatus = administratorStatus;
	}

	public Integer getAdministratorID() {
		return administratorID;
	}

	public void setAdministratorID(Integer administratorID) {
		this.administratorID = administratorID;
	}

	public String getAdministratorAccount() {
		return administratorAccount;
	}

	public void setAdministratorAccount(String administratorAccount) {
		this.administratorAccount = administratorAccount;
	}

	public String getAdministratorPassword() {
		return administratorPassword;
	}

	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}

	public Timestamp getAdministratorCreateTime() {
		return administratorCreateTime;
	}

	public void setAdministratorCreateTime(Timestamp administratorCreateTime) {
		this.administratorCreateTime = administratorCreateTime;
	}

	public Integer getAdministratorStatus() {
		return administratorStatus;
	}

	public void setAdministratorStatus(Integer administratorStatus) {
		this.administratorStatus = administratorStatus;
	}

}
