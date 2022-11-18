package com.xworkz.userdata.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {

	Class[] getServletConfigClasses = { SpringConfiguration.class, DBConfiguration.class };
	String[] mapping = {"/"};
	
	
	public SpringMVCConfiguration() {
		System.out.println("created:"+this.getClass().getSimpleName());
		
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Calling getRootConfigClasses method");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Calling getServletConfigClasses method");
		return getServletConfigClasses;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Calling getServletMappings method");
		return mapping;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("calling configureDefaultServletHandling method");
		configurer.enable();
	}

}
