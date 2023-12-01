package com.test.springbdd.config;

import java.util.Objects;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

public class BrowserScope extends SimpleThreadScope
{

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		System.out.println("The name is"+name);
		System.out.println("The object factory is"+objectFactory);
		Object o= super.get(name, objectFactory);
		SessionId sessionId=((RemoteWebDriver)o).getSessionId();
		System.out.println("The session id is"+sessionId);
		if(Objects.isNull(sessionId))
		{
			System.out.println("OBJECT IS NULL NOW!!!!!!!");
			super.remove(name);
		 o=super.get(name,objectFactory);
		 System.out.println("The new session id is"+((RemoteWebDriver)o).getSessionId());
		}
		System.out.println("returning objects after checking null or not");
		System.out.println("The O now is"+o);
		return o;
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		
	}

}
