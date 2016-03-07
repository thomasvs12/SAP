package com.penninkhof.odata;

import org.springframework.beans.factory.annotation.Autowired;

import com.penninkhof.odata.repository.ShoeboxRepository;

public class MyFactory {

	@Autowired
	ShoeboxRepository repo;
	
	public ShoeboxRepository getRepo() {
		return repo; 
	}
	
}
