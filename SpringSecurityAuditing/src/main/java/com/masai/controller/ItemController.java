package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Item;
import com.masai.repository.ItemRepository;

@RestController
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;

	
	@PostMapping("/items")
	public ResponseEntity<Item> createItemHandler(@RequestBody Item item){
		
		Item savedItem= itemRepository.save(item);
		
		return new ResponseEntity<>(savedItem,HttpStatus.OK);
		
		
	}
	
	
	@PutMapping("/items")
	public ResponseEntity<Item> updateItemHandler(@RequestBody Item item){
		
		itemRepository.findById(item.getItemId()).orElseThrow(() -> new IllegalArgumentException("Invalid Item is supplied"));
		
		Item updatedItem= itemRepository.save(item);
		
		return new ResponseEntity<>(updatedItem,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
