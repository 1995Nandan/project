package com.xworkz.userdata.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz")
public class SpringConfiguration {

	public SpringConfiguration() {
		System.out.println("SpringConfiguration:" + this.getClass().getSimpleName());
	}

	@Bean
	public ViewResolver viewResolver() {
		System.out.println("Created:" + this.getClass().getSimpleName());
		return new InternalResourceViewResolver("/", ".jsp");
	}

	/*public MultipartResolver multipartResolver() {
		System.out.println("Created:" + this.getClass().getSimpleName());
		re@Bean
	turn new StandardServletMultipartResolver();
	}*/

	@Bean
	MultipartResolver multipartResolver() {
		System.out.println("multipartResolver");
		
		return new  StandardServletMultipartResolver(); 
		
	}
}
