package com.xworkz.userdata.configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebMvcConfigurer {

	Class[] getServletConfigClasses = { SpringConfiguration.class, DBConfiguration.class };
	String[] mapping = { "/" };

	public SpringMVCConfiguration() {
		System.out.println("created:" + this.getClass().getSimpleName());

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

	/*
	 * @Override protected void customizeRegistration(ServletRegistration.Dynamic
	 * registration) { System.out.println("Running customizeRegistration"); File
	 * uploadDirectory = new File("C:/Users/admin/Desktop/nandan");//E:\temp-files
	 * 
	 * // register a MultipartConfigElement MultipartConfigElement
	 * multipartConfigElement = new
	 * MultipartConfigElement(uploadDirectory.getAbsolutePath(), 10000000,
	 * 1000000000 * 2, 1000000000/ 2); // register a MultipartConfigElement
	 * registration.setMultipartConfig(multipartConfigElement); }
	 */
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		System.out.println("customizeRegistration");
		File file = new File("C:/Users/admin/Desktop/MANOJ");//C:\Users\admin\Desktop\MANOJ
		MultipartConfigElement element = new MultipartConfigElement(file.getAbsolutePath(), 100000000, 100000000 * 2,
				100000000 / 2);
		
		registration.setMultipartConfig(element);//C:/Users/admin/Desktop/nandan

	}
}