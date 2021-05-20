package com.loginportal.deregister.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

@AllArgsConstructor
@Entity
@Table(name = "review")
public class Review {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + (int) (reviewid ^ (reviewid >>> 32));
		result = prime * result + (int) (userid ^ (userid >>> 32));
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
		Review other = (Review) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
				return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
				return false;
		if (reviewid != other.reviewid)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long reviewid;
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "review")
	private String review;
	@Column(name = "userid")
	private long userid;

	@Override
	public String toString() {
		return "Reviews [reviewID=" + reviewid + ", firstName=" + firstName + ", review=" + review + ", uid=" + userid
				+ "]";
	}

}
