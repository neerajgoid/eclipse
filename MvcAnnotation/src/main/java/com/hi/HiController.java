package com.hi;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/Hi")
public class HiController {

		@RequestMapping(method = RequestMethod.GET ,value="/hi")
		public String doMethod(ModelMap mm)
		{
			Customer c = new Customer();
			
			try {
			List<Customer> cl =	c.customerList();
			mm.addAttribute("CustomerList", cl);
			} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//mm.addAttribute("msg", "Hi there");
			
			
			return "index"; //name of .jsp here. basically name of view here.
			
	
		}
		
}
