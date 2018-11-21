package com.SpringBootHibernateBasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String validateCredentials(ModelMap mm,@RequestParam("username") String username,@RequestParam("password") String pwd) {
		
		boolean valid =adminService.validate(username, pwd);
		if(valid) {
			mm.addAttribute("successLogin","Login Successful");
			return "welcome";
		}
		else {
			 mm.addAttribute("errorMessage", "Invalid Credentials");
	            return "login";
		}
		
	}

}
