package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//It can be an Entity class
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private Integer roll;
	private String name;
	private String address;
	private Integer marks;
	
	

}
