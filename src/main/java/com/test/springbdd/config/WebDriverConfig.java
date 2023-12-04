package com.test.springbdd.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
public class WebDriverConfig {
	
	
	@ConditionalOnProperty(value = "browser", havingValue = "chrome") 
	@Bean
	@Scope("browserscope")
	public  WebDriver getdriver()
	{		
		WebDriverManager.chromedriver().setup();		
		System.out.println("WebDriver bean created");
		return new ChromeDriver();
		
	}
	
	@ConditionalOnProperty(value = "browser", havingValue = "firefox") 
	@Bean
	@Scope("browserscope")
	public  WebDriver getdriver2()
	{		
		System.out.println("Firefox  bean created");
		WebDriverManager.firefoxdriver().setup();	
		return new FirefoxDriver();
	}

	
	@Bean
	public WebDriverWait getwait()
	{	
	
		return new WebDriverWait(getdriver(),30);
	}
	
	@Lazy
	@Bean(name="sayhi")
	public Sample getsample() {
		System.out.println("Helllo=======>");
		return new Sample();
	}

	
}
