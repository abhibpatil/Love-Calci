package com.jspiders.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculaterApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext arg0) throws ServletException {

		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculaterAppConfig.class);

		// create a dispatcher servlet object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

		// registered dispatcher servlet with servlet context
		ServletRegistration.Dynamic myCustamDispatcherServelt = arg0.addServlet("myDispatcherServlet",dispatcherServlet);

		myCustamDispatcherServelt.setLoadOnStartup(1);
		myCustamDispatcherServelt.addMapping("/mywebsite.com/*");

	}

}
