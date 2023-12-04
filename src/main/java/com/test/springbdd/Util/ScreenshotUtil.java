package com.test.springbdd.Util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.test.springbdd.config.Base;
import com.test.springbdd.config.InterceptableSceanario;
@Scope("prototype")
@Component
public class ScreenshotUtil extends Base {
	
	@Autowired
	InterceptableSceanario scenario;
	
	public void takescreeshot()
	{
		scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
	}
	
	

}
