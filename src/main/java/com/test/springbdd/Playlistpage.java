package com.test.springbdd;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.test.springbdd.config.Base;

@Scope("prototype")
@Component
public class Playlistpage extends Base{



	@FindBy(xpath="//div[@aria-labelledby='listrow-title-spotify:playlist:6hzaVcNtcCUR9LA47yE4Me']")
	WebElement playlistname; //specific to Gaana2 now..other ones are not working has to be changed	
	@FindBy(xpath="//div[@class='YAYCVnYpPvmYV4JyTmn5']//input[@role='searchbox']")
	WebElement searchbox;		
	@FindBy(xpath="//div[text()='Kathadikkuthu Kathadikkuthu']/ancestor::div/div[@aria-colindex='4']//button[text()='Add']")
	WebElement desiredsongaddbutton;	
	
	////div[text()='Anna Nagar Aandalu']/ancestor::div/div[@aria-colindex='4']//button[text()='Add']
	@FindBy(xpath="//div[@data-testid='tracklist-row' and @class='h4HgbO_Uu1JYg5UGANeQ wTUruPetkKdWAR1dd6w4']//div[@aria-colindex='2']//div//a//div")	
	WebElement addedsongsname;

	@FindBy(xpath="//a[@aria-label='Search']")
	WebElement Homesearchbutton;
	@FindBy(xpath="//input[@class='Type__TypeElement-sc-goli3j-0 ieTwfQ QO9loc33XC50mMRUCIvf']")
	WebElement Homesearchbox;
	@FindBy(xpath="//div[@class='Type__TypeElement-sc-goli3j-0 kjfRyT nk6UgB4GUYNoAcPtAQaG']")
	WebElement Topresult;

	@FindBy(xpath="//div[@class='Type__TypeElement-sc-goli3j-0 eoWRdH']")
	WebElement FindMore;

	public void addsongtoplaylist(String songs) throws InterruptedException 
	{

		waitandclick(playlistname);
		Thread.sleep(6000);
		System.out.println("clicked on playlist");		
		try
		{
			searchbox.sendKeys(songs);	
		}
		catch(Exception e)
		{
			waitandclick(FindMore);
			searchbox.sendKeys(songs);		
		}
		System.out.println("entered keyword");
		waitandclick(desiredsongaddbutton);
		System.out.println("clicked on Add button");
	}
	public void searchforsong(String str) 
	{

		waitandclick(Homesearchbutton);
		waitandclick(Homesearchbox);
		Homesearchbox.sendKeys(str);



	}

	public String gettheTopResult() 
	{

		waitandclick(Topresult);
		return Topresult.getText();	


	}

	public void checkforbrokenlinks()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			verifyLink(url);
		}		
	}

	public static void verifyLink(String url) {
		try {
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();


			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} else {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
		} catch (Exception e) {
			System.out.println(url + " - " + "is a broken link");
		}
	}
}

