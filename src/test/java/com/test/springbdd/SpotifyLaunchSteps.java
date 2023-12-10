package com.test.springbdd;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.springbdd.Util.ScreenshotUtil;
import com.test.springbdd.config.Base;
import com.test.springbdd.config.InterceptableSceanario;

import io.cucumber.java.en.Given;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestConfiguration.class)
public class SpotifyLaunchSteps extends Base{

	@Autowired
	InterceptableSceanario scenario;
	@Autowired
	LoginPage loginpage;
	@Autowired
	MenuPage menupage;
	@Autowired
	ScreenshotUtil takescreenshot;




	@Given("Login to spotify")
	public void login_to_spotify() {
		String actualtitle=loginpage.logintospotify();
		Assert.assertEquals(actualtitle, "Spotify - Web Player: Music for everyone");
		scenario.write("Home Page loaded");
		System.out.println("The status is "+scenario.getStatus());
		takescreenshot.takescreeshot();
			
		

	}

}
