package com.loginportal.admin.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "active_user")
public class ActiveUsers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer active_userid;
	private String emailid;
	private String ip_address;
	private String location;
	private String user_agent;
	private LocalDateTime logged_in_time;
	private Integer userid;
	public Integer getActive_userid() {
		return active_userid;
	}
	public void setActive_userid(Integer active_userid) {
		this.active_userid = active_userid;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUser_agent() {
		return user_agent;
	}
	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}
	public LocalDateTime getLogged_in_time() {
		return logged_in_time;
	}
	public void setLogged_in_time(LocalDateTime logged_in_time) {
		this.logged_in_time = logged_in_time;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}
