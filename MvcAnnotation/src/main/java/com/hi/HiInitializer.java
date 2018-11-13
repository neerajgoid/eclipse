package com.hi;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HiInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		// Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        //AppContext is super of BeanFactory. Used to create and manage lifecycle of beans.
        // BeanFactory needs a configuration file which has bean definitions. So doesn App Context.
        root.register(HiConfig.class); // name of the config class ie the appname-servlet.xml
        root.setServletContext(servletContext);
        
     // Register and map the dispatcher servlet. The dispatcher servlet is in the form of an object.
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(root));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    
	}
	
	


