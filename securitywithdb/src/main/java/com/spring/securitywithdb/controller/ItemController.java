package com.spring.securitywithdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.securitywithdb.model.Item;

@RestController
public class ItemController {
	
	@Autowired
    ItemController itemService;
	
	public static List<Item> items;
	
	static {
		items = new ArrayList<>();
		items.add(new Item(1,"Spring Boot in Action","Books"));
		items.add(new Item(2,"Java 8 in Action","Books"));
		items.add(new Item(3,"Data Structures","Books"));
		items.add(new Item(4,"Spring Boot Security","Books"));
		
	}
	
	@GetMapping("/hello")
	public String sayHello(){
		return "Hello Security";
	}

	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/getAllItems")
	public String getAllItems(){		
		
		return "Hey Secured";
	}
}
