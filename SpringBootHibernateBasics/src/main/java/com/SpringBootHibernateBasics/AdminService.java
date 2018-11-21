package com.SpringBootHibernateBasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	private AdminRepo adminRepository;
	
	public boolean validate(String username,String pwd) {
		
		Iterable<Admin> adminIterator= adminRepository.findAll();
		
		for(Admin a: adminIterator) {
			
			if(a.getUsername().equals(username) && a.getPassword().equals(pwd)) {
				return true;
			}
			
				
		}
		return false;
		
	}
	
}
