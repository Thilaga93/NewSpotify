package com.test.springbdd;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.test.springbdd.config.Base;

@Component
@Scope("prototype")
public class MenuPage extends Base{



	@FindBy(xpath="//div[@data-testid='placeholder-wrapper']")
	WebElement placeholder;

	@FindBy(xpath="//span[text()='Account']")
	WebElement account;	

	@FindBy(xpath="//a[@href='/in-en/account/subscription/receipt/']")
	WebElement orderhistory;
	
	
	@FindBy(xpath="//th[text()='Order Number']")
	WebElement ordernumber;
	
	@FindBy(xpath="//a[text()='Support']")
	WebElement Support;
	
	//@FindBy(xpath="//tr/td[*]")
	//List<WebElement> listoforders;

	


	public void clickonaccount(String ele)
	{
		System.out.println("the ele is"+ele);
		if(ele.equals("placeholder"))

		{
			placeholder.click();
		}
		else if(ele.equals("account"))
		{
			placeholder.click();
			account.click();
	
		}				

	}

	public void navigatetoaccountpage() {	
		waitandclick(Support);
		System.out.println("Support is clicked");
		
	}
	
}