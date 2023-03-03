package com.masai;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/callHello")
	public String getHelloHandler() {
		
		String url = "http://localhost:8080/hello";
		
		ResponseEntity<String> re = restTemplate.getForEntity(url, String.class);
		
		//with this responseEntity we can extract the body, headers or status code also
		
		String result= re.getBody();
		
		return result;
		
	}
	
	@PostMapping("/registerStudent")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student){
		
		String url = "http://localhost:8080/students";
		
		ResponseEntity<Student> re= restTemplate.postForEntity(url, student , Student.class);
		
		
		return re;
		
		
	}
	
	@GetMapping("/getstudent/{roll}")
	public ResponseEntity<Student> getStudentHandler(@PathVariable("roll") Integer rollnumber){
		
		
		String url = "http://localhost:8080/students/{roll}";
		
		//resolving the path variable
		Map<String, Object> map = new HashMap<>();
		map.put("roll", rollnumber);
		
		ResponseEntity<Student> re= restTemplate.getForEntity(url,Student.class, map);
		
		return re;
		
	}
	
	
	
	
	
	
	
	
	
}
