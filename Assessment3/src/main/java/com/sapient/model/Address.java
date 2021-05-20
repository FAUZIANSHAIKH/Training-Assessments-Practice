//package com.sapient.model;
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
//@Table(name = "Address")
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class Address {
//	
//	
//		@Id
//		@GeneratedValue(strategy = GenerationType.AUTO)
//		@XmlElement
//		@JsonProperty
//		private int id;
//
//		
//		@XmlElement
//		@Column(name = "state")
//		private String state;
//
//		@NotNull
//		@XmlElement
//		@Column(name = "city")
//		private String city;
//		
//		@NotNull
//		@XmlElement
//		@Column(name = "pin")
//		private int pin;
//		public Address() {
//		}
//
//		public Address(int int1, String string, String double1,int pin) {
//			this.id = int1;
//			this.state = string;
//			this.city = double1;
//			this.pin=pin;
//		}
//
//		public Address(String state, String city,int pin) {
//			this.state = state;
//			this.city = city;
//			this.pin=pin;
//		}
//
//		public int getId() {
//			return id;
//		}
//
//		public void setId(int id) {
//			this.id = id;
//		}
//
//		public String getState() {
//			return state;
//		}
//
//		public void setState(String state) {
//			this.state = state;
//		}
//
//		public String getCity() {
//			return city;
//		}
//
//		public void setCity(String city) {
//			this.city = city;
//		}
//
//		public int getPin() {
//			return pin;
//		}
//
//		public void setPin(int pin) {
//			this.pin = pin;
//		}
//
//		@Override
//		public String toString() {
//			return "Address [id=" + id + ", state=" + state + ", city=" + city + ", pin=" + pin + "]";
//		}
//
//		
//	}
//
package com.sapient.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "Address")
public class Address implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String city;
    private String state;
    private int pin;
    public Address()
    {}
    public Address(String city, String state, int pin)
    {
    	this.city = city;
    	this.state = state;
    	this.pin = pin;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", pin=" + pin + "]";
	}


    
}
