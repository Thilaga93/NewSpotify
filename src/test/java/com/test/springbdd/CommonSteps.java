package com.test.springbdd;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.springbdd.Entity.Spotify;
import com.test.springbdd.Service.SpotifyServiceImpl;
import com.test.springbdd.Util.ScreenshotUtil;
import com.test.springbdd.config.Base;
import com.test.springbdd.config.InterceptableSceanario;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps{

	@Autowired
	MenuPage cmp;
	@Autowired
	Playlistpage playlistpage;	
	@Autowired
	Base base;	
	@Autowired
	InterceptableSceanario scenario;
	@Autowired
	ScreenshotUtil takescreenshot;
	@Autowired 
	SpotifyServiceImpl db;



	@Given("click on {string} link")
	public void click_on_account(String link) 

	{

		cmp.clickonaccount(link);
		takescreenshot.takescreeshot();
		//log.info("Logger");


	}	
	@Given("click on {string} link in the account page")
	public void click_on_Support(String link)
	{

		cmp.navigatetoaccountpage();
		takescreenshot.takescreeshot();
	}

	@Then ("add song to playlist kathadikkuthu")
	public void add_Song_to_playlist(List<Map<String,String>> songs) throws InterruptedException 
	{
		System.out.println(songs);
		System.out.println("the song is"+songs.get(0).get("Song"));

		playlistpage.addsongtoplaylist(songs.get(0).get("Song")); 

		takescreenshot.takescreeshot();
	}
	@Then("display message")
	public void display()
	{
		Spotify obj=new Spotify("Marana Mass","Anirudh","SUPERHIT");
				db.save(obj);
		System.out.println(obj);
		System.out.println("Success");
	}

	@Then  ("search for song {string}")
	public void searchforsong(String str)
	{
		playlistpage.searchforsong(str);
		takescreenshot.takescreeshot();
	}
	@Then ("get the search result and save it in {string}")
	public void searchandsave(String str)
	{
		String topresult=playlistpage.gettheTopResult();
		String processedstring=str.substring(1);
		base.testcontext().set(processedstring, topresult);
		System.out.println(topresult);
		takescreenshot.takescreeshot();

	}

	@Then ("search for the song with keyword {string} and validate the result")
	public void validatesearchresults(String str)
	{
		String processedstring=str.substring(1);
		//base.testcontext().get(processedstring);
		System.out.println("The achieved result is" +base.testcontext().get(processedstring) );
		//playlistpage.checkforbrokenlinks();
		takescreenshot.takescreeshot();

	}
}
