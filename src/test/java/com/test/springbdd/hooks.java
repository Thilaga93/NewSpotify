package com.test.springbdd;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.springbdd.config.DestroyPrototypeBeansPostProcessor;
import com.test.springbdd.config.InterceptableSceanario;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	@Autowired
	WebDriver driver;

	@Autowired
	InterceptableSceanario scenario;
	
	@Autowired
	
	DestroyPrototypeBeansPostProcessor obj;


	@Before
	public void initializedriver()
	{
		System.out.println("Inside hooks------>navigating to spotify");
		driver.get("https://open.spotify.com/"); 
		driver.manage().window().maximize();
	}

	@Before
	public void before(Scenario scenario)
	{

		this.scenario.setCurrentscenario(scenario);
	}
	@After
	public void closedriver() throws Exception
	{
		System.out.println("closing driver");
		driver.quit();
		obj.destroy();
	}

}
