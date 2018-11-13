package com.hi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.hi")

public class HiConfig{

	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
	InternalResourceViewResolver view=new InternalResourceViewResolver();
	view.setPrefix("/WEB-INF/");
	view.setSuffix(".jsp");
	return view;
	}
	
}

   

