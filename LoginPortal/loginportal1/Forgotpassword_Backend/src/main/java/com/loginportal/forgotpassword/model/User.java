package com.loginportal.forgotpassword.model;

import java.sql.Timestamp;

public class User {

	private Long userID;
	private String emailID;
	private String userRole = "user";
	private String firstName;
	private String lastName;
	private String phoneNo;
	private boolean emailConfirmationFlag = false;
	private Timestamp accountCreationTime;
	private PasswordHistory passwordHistory;
	private SecurityAnswer securityAns;
	

	public User() {
		super();
	}

	public User(Long userID) {
		super();
		this.userID = userID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public boolean isEmailConfirmationFlag() {
		return emailConfirmationFlag;
	}

	public void setEmailConfirmationFlag(boolean emailConfirmationFlag) {
		this.emailConfirmationFlag = emailConfirmationFlag;
	}

	public Timestamp getAccountCreationTime() {
		return accountCreationTime;
	}

	public void setAccountCreationTime(Timestamp accountCreationTime) {
		this.accountCreationTime = accountCreationTime;
	}

	public PasswordHistory getPasswordHistory() {
		return passwordHistory;
	}

	public void setPasswordHistory(PasswordHistory passwordHistory) {
		this.passwordHistory = passwordHistory;
	}

	public SecurityAnswer getSecurityAns() {
		return securityAns;
	}

	public void setSecurityAns(SecurityAnswer securityAns) {
		this.securityAns = securityAns;
	}


	@Override
	public String toString() {
		return "User [userID=" + userID + ", emailID=" + emailID + ", userRole=" + userRole + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNo=" + phoneNo + ", emailConfirmationFlag=" + emailConfirmationFlag
				+ ", accountCreationTime=" + accountCreationTime + ", passwordHistory=" + passwordHistory
				+ ", securityAns=" + securityAns +  "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountCreationTime == null) ? 0 : accountCreationTime.hashCode());
		result = prime * result + (emailConfirmationFlag ? 1231 : 1237);
		result = prime * result + ((emailID == null) ? 0 : emailID.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((passwordHistory == null) ? 0 : passwordHistory.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((securityAns == null) ? 0 : securityAns.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accountCreationTime == null) {
			if (other.accountCreationTime != null)
				return false;
		} else if (!accountCreationTime.equals(other.accountCreationTime))
			return false;
		if (emailConfirmationFlag != other.emailConfirmationFlag)
			return false;
		if (emailID == null) {
			if (other.emailID != null)
				return false;
		} else if (!emailID.equals(other.emailID))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (passwordHistory == null) {
			if (other.passwordHistory != null)
				return false;
		} else if (!passwordHistory.equals(other.passwordHistory))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (securityAns == null) {
			if (other.securityAns != null)
				return false;
		} else if (!securityAns.equals(other.securityAns))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}

}
