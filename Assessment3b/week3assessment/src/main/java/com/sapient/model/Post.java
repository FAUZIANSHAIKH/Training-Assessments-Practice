//package com.sapient.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.xml.bind.annotation.*;
//
//import org.hibernate.validator.constraints.NotEmpty;
//import org.hibernate.validator.constraints.Range;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import lombok.Data;
//
//@Data
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
//@Entity
//@Table(name = "Post")
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class Post {
//
//		
//		
//			@Id
//			@GeneratedValue(strategy = GenerationType.AUTO)
//			@XmlElement
//			@JsonProperty
//			private int pid;
//			
//			@NotNull
//			@XmlElement
//			@Column(name = "userid")
//			private int userid;
//			
//			@XmlElement
//			@Column(name = "title")
//			private String title;
//
//			@NotNull
//			@XmlElement
//			@Column(name = "body")
//			private String body;
//			
//			
//			public Post() {
//			}
//
//			public Post(int int1,int userid, String string, String double1) {
//				this.pid = int1;
//				this.userid=userid;
//				this.title = string;
//				this.body = double1;
//				
//			}
//
//			public int getPid() {
//				return pid;
//			}
//
//			public void setPid(int pid) {
//				this.pid = pid;
//			}
//
//			public int getUserid() {
//				return userid;
//			}
//
//			public void setUserid(int userid) {
//				this.userid = userid;
//			}
//
//			public String getTitle() {
//				return title;
//			}
//
//			public void setTitle(String title) {
//				this.title = title;
//			}
//
//			public String getBody() {
//				return body;
//			}
//
//			public void setBody(String body) {
//				this.body = body;
//			}
//
//			@Override
//			public String toString() {
//				return "Address [pid=" + pid + ", userid=" + userid + ", title=" + title + ", body=" + body + "]";
//			}
//
//		/*
//		 * public Post(String state, String city,int pin) { this.state = state;
//		 * this.city = city; this.pin=pin; }
//		 */
//
//			
//
//			
//		}
//
//
//
package com.sapient.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Post")
@Data

public class Post implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String body;
	public Post()
	{}
	
	public Post(String title, String body)
	{
		this.title = title;
		this.body = body;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}