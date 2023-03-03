package com.masai;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//it is a normal Java Bean class which will act as a DTO class
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private Integer roll;
	private String name;
	private String address;
	private Integer marks;
	
	

}