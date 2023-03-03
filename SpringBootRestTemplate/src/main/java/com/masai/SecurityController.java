package com.masai;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SecurityController {

	
	
	
	@PostMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(@RequestBody LoginDTO dto){
		
		RestTemplateBuilder builder = new RestTemplateBuilder();
		
		RestTemplate restTemplate= builder.basicAuthentication(dto.getUsername(), dto.getPassword()).build();
		
		String signInUrl= "http://localhost:8080/signIn";
		
		ResponseEntity<Customer> re= restTemplate.getForEntity(signInUrl, Customer.class);
		
		
		HttpHeaders headers= re.getHeaders();
		
		String jwtToken= headers.getFirst("Authorization");
		
		
		
		HttpHeaders headers2 = new HttpHeaders();
		
		headers2.setBearerAuth(jwtToken);
		
		RestTemplate restTemplate2 = new RestTemplate();
		
		
		String getCustomersUrl= "http://localhost:8080/customers";
		
		HttpEntity<String> entity = new HttpEntity<String>(headers2);
		
		//ResponseEntity<List> re2= restTemplate.exchange(getCustomersUrl, HttpMethod.GET, entity, List.class);
		
		
		ResponseEntity<List<Customer>> re2= restTemplate2.exchange(getCustomersUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Customer>>() {});	
		
		
		return re2;
		
		
		
		
	}
	
	
}
