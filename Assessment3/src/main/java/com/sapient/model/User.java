//@Data
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
//@Entity
//@Table(name = "User")
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class User implements Serializable {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@XmlElement
//	@JsonProperty
//	private int id;
//
//	
//	@XmlElement
//	@Column(name = "name")
//	private String name;
//
//	@NotNull
//	@XmlElement
//	@Column(name = "post")
//	private String post;
//	private Address adr;
//	private List<Post> posts;
//	public User() {
//	}
//
//	public User(int int1, String string, String double1,Address adr,List<Post> posts) {
//		this.id = int1;
//		this.name = string;
//		this.post = double1;
//		this.adr=adr;
//	}
//
//	public User(String name, String post) {
//		this.name = name;
//		this.post = post;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPost() {
//		return post;
//	}
//
//	public void setPost(String post) {
//		this.post = post;
//	}
//
//	public Address getAdr() {
//		return adr;
//	}
//
//	public void setAdr(Address adr) {
//		this.adr = adr;
//	}
//
//	public List<Post> getPosts() {
//		return posts;
//	}
//
//	public void setPosts(List<Post> posts) {
//		this.posts = posts;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", post=" + post + ", adr=" + adr + ", posts=" + posts + "]";
//	}
//
//}

package com.sapient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "User")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private  int id;

    @NotEmpty
    @XmlElement
    @Column(name="name")
    private  String name;
    
    @NotNull 
    @XmlElement
    @Column(name="emp_age")
    private  int age;


    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    @XmlElement
    private List<Post> post;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Address address;

    public User(){

    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address employeeDetails) {
		this.address = employeeDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", post=" + post + ", employeeDetails="
				+ address + "]";
	}

   
}
