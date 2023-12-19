package com.test.springbdd;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/test/springbdd/features/AccountPage.feature",
plugin = { "json:target/cucumber.json", "pretty",
		"html:target/cucumber-reports" })
public class CucumberTest {
	

	}

