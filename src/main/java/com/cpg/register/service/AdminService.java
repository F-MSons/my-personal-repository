package com.cpg.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpg.register.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;
	
	public void removeStudent(long id) {
		repository.deleteById(id);
	}

}
