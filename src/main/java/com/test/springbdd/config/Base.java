package com.test.springbdd.config;

import static com.test.springbdd.config.TestContext2.CONTEXT;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Base {
	
	
	
	@Autowired
	protected WebDriver driver;
	
	@Autowired
	protected WebDriverWait wait;

	
	@PostConstruct
	public void init()
	{
		System.out.println("\"POST CONSTRUCT=====>Initializing All page elements");
		PageFactory.initElements(driver, this);
	}

	public TestContext2 testcontext()
	{
		return CONTEXT;
		
	}
	
	public void waitandclick(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
}
