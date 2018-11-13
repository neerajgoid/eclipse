package com.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/hello")  // should we /hello
public class HelloController {
	
	@RequestMapping  (method = RequestMethod.GET, value="/sayHello")
		public ModelAndView printHello() 
	{
		ModelAndView model=new ModelAndView("Display");
		model.addObject("message", "Hello Spring MVC");
		return model;
		
	}
}