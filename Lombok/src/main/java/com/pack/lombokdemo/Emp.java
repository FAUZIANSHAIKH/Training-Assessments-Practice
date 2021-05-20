package com.pack.lombokdemo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
//@Data
@Value
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor

public class Emp {
	private final String name;
	private int age;
	private float salary;
	private String designation;
}
