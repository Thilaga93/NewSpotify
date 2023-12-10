package com.test.springbdd;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.test.springbdd.config.Base;

@Component
@Scope("prototype")
public class LoginPage extends Base{
	
	@FindBy(xpath="//span[text()='Log in']")
	WebElement LoginButton;
	
	@FindBy(id="login-username")
	WebElement username;
	
	@FindBy(id="login-password")
	WebElement password;
	
	@FindBy(xpath="//div[@id='onetrust-close-btn-container']//button[@aria-label='Close']")
	WebElement close;
	
	public String logintospotify() 
	{
	
	
	LoginButton.click();
	wait.until((d)->this.username.isDisplayed());
	username.sendKeys("thilagaathivel@gmail.com");
	username.sendKeys(Keys.ENTER);
	password.sendKeys("Vinup@222");
	password.sendKeys(Keys.ENTER);
	waitandclick(close);
	return  driver.getTitle();
	}
}