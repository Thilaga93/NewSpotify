package com.test.springbdd.config;

import java.util.Collection;

import org.springframework.stereotype.Component;

import io.cucumber.core.api.Scenario;
import io.cucumber.core.event.Status;

@Component
public class InterceptableSceanario {
	
	Scenario currentscenario;

	public Scenario getCurrentscenario() {
		return currentscenario;
	}

	public void setCurrentscenario(Scenario currentscenario) {
		this.currentscenario = currentscenario;
	}
	
	public void write(String text)
	{
		this.currentscenario.write(text);
	}
	
	
	public Collection<String> getSourceTagNames() {
		
		return currentscenario.getSourceTagNames();
	}

	public Status getStatus() {
		// TODO Auto-generated method stub
		return currentscenario.getStatus();
	}

	public boolean isFailed() {
		// TODO Auto-generated method stub
		return currentscenario.isFailed();
	}

	public void embed(byte[] data, String mimeType) {
		
		currentscenario.embed(data, mimeType);
		
	}

	public void embed(byte[] data, String mimeType, String name) {

		currentscenario.embed(data, mimeType, name);
		
	}


	public String getName() {
		
		return currentscenario.getName();
	}

	public String getId() {
		
		return currentscenario.getId();
	}

	public String getUri() {
		
		return currentscenario.getUri();
	}

	public Integer getLine() {
		
		return currentscenario.getLine();
	}

}
