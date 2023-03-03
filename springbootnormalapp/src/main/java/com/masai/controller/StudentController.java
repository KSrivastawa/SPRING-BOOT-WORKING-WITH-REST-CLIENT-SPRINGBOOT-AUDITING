package com.masai.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;

@RestController
public class StudentController {

	
	@GetMapping("/hello")
	public String sayHello() {
		
		return "Welcome to Spring Boot";
	}
	
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentHandler(@PathVariable("roll") Integer roll){
		
		Student s = new Student();
		s.setRoll(roll);
		s.setName("Ram");
		s.setAddress("Delhi");
		s.setMarks(800);
		
		HttpHeaders headers= new HttpHeaders();
		headers.add("header1", "header1Value");
		headers.add("header2", "header2Value");
		
		return new ResponseEntity<>(s,headers ,HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentsHandler(){
		
		List<Student> students = List.of(
				
				new Student(10, "Ram", "Delhi", 800),
				new Student(12, "Ramesh", "Mumbai", 820),
				new Student(13, "Amit", "Chennai", 810),
				new Student(14, "Dinesh", "Patna", 850)
				);
		
		return new ResponseEntity<>(students,HttpStatus.OK);
		
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student){
		
		student.setRoll(100);
		return new ResponseEntity<>(student, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
}
