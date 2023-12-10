package com.test.springbdd.config;




import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
public class WebDriverConfig {

	@Value("${remote.url}")
	String remoteurl;

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
	@ConditionalOnProperty(value = "browser", havingValue = "remote") 
	@Bean
	@Scope("browserscope")
	public  WebDriver getdriver3() throws MalformedURLException
	{		
		System.out.println("Remote driver   bean created");
		URL url=new URL(remoteurl);
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.addArguments("--headless=new");
		return new RemoteWebDriver(url,options);
	}


	@Bean
	public WebDriverWait getwait() throws MalformedURLException
	{	

		return new WebDriverWait(getdriver(),30);
	}




}
