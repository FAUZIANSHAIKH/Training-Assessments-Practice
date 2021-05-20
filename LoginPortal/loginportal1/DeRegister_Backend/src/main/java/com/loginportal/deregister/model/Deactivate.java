package com.loginportal.deregister.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="deactivate")
public class Deactivate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="deactivate_id")
	private Long deactivateId;
	
	@Column(name="userid")
	private Long userID;
	
	@Override
	public String toString() {
		return "Deactivate [deactivateId=" + deactivateId + ", userID=" + userID 
				+ ", deactivateTime=" + deactivateTime + "]";
	}
	public Long getUserId() {
		return userID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (deactivateId ^ (deactivateId >>> 32));
		result = prime * result + ((deactivateTime == null) ? 0 : deactivateTime.hashCode());
		result = prime * result + (int) (userID ^ (userID >>> 32));
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
		Deactivate other = (Deactivate) obj;
		if (deactivateId != other.deactivateId)
			return false;
		if (deactivateTime == null) {
			if (other.deactivateTime != null)
				return false;
		} else if (!deactivateTime.equals(other.deactivateTime))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	public void setUserId(Long userId) {
		this.userID = userId;
	}
	@Transient
    private Timestamp deactivateTime ;
	

}
