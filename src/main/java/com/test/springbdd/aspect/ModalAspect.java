package com.test.springbdd.aspect;


import javax.annotation.PostConstruct;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.test.springbdd.config.Base;

@Component
@Aspect
public class ModalAspect extends Base{
	
	//@Autowired
	//WebDriver driver;
	//@Pointcut("execution(* com.example.AOPDemo.Dao.*.*(..))")
	//@Pointcut("execution(* com.test.springbdd.*.())")

	@Pointcut("execution(* com.test.springbdd.*.navigate*())")//navigatetoaccountpage()
	public void fornavigation()
	{
		
	}
	
	@Before("com.test.springbdd.aspect.ModalAspect.fornavigation()")			
    public void changewindow()
	{
		
		System.out.println("From Aspect Class====>Navigating to desired window");
		String windowhandle=driver.getWindowHandle();

		for(String s:driver.getWindowHandles())
		{
			if(!s.equals(windowhandle))
				System.out.println(s);
			driver.switchTo().window(s);
		}
	}

}
