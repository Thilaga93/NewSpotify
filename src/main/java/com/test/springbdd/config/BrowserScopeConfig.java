package com.test.springbdd.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrowserScopeConfig {
	
	
	@Bean
	public static BeanFactoryPostProcessor beanFactoryPostProcessor()
	{
		
		System.out.println("This is config file of beanfactory");
		return new BrowserScopePostProcessor();
	
		
	}

}
