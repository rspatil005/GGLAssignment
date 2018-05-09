package dd_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.TestUtil;

public class TC_03 extends TestCore {
	@BeforeTest
	public void isSkip(){
		if (!TestUtil.isExecutable("TC_03 To verify that all the Google apps (My Account, Search, Maps, YouTube, Play, News, Gmail, Drive, Calender, Google+, Translate, Photos) are launched properly " )) {
			throw new SkipException("Skiping test as runmode to No");
		}
	}
	@Test
	public void launchGoogleApp() throws IOException{
		app_logs.debug("Executing Google Apps Launch Test");
		System.out.println("\n"+"TC_03");
		try{
		//For My Account
		driver.findElement(By.xpath(object.getProperty("MyAccount"))).click();
		Thread.sleep(2000);
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("MyAccountelement"), "MyAccount element");
		clickBackward();
		
		//for Search
		driver.findElement(By.xpath(object.getProperty("Search"))).click();
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("inputBox"), "SearchBox");
		elementpresent(object.getProperty("searchButton"), "Google search button");
		elementpresent(object.getProperty("FeelingButton"), "Feeling Button");
		clickBackward();
		/*
		//Google Map
		driver.findElement(By.xpath(object.getProperty("Maps"))).click();
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("GMapSearchBox"), "SearchBox in Map");
		Thread.sleep(1500);
		driver.navigate().to(config.getProperty("testsite"));
		//clickBackward();
		
		//YouTube
		driver.findElement(By.xpath(object.getProperty("YouTube"))).click();
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("YouTubeLogo"), "YouTubeLogo");
		elementpresent(object.getProperty("YouTubeSearchBox"), "SearchBox in YouTube");
		elementpresent(object.getProperty("Upload"), "Upload Button in YouTube");
		clickBackward();
		
		//Play Store
		driver.findElement(By.xpath(object.getProperty("Play"))).click();
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("PlayLogo"), "PlayLogo in GooglePlay");
		elementpresent(object.getProperty("Entertainment"), "Entertainment in GooglePlay");
		elementpresent(object.getProperty("PlaySearchBox"), "SearchBox in GooglePlay");
		clickBackward();
		
		//News
		driver.findElement(By.xpath(object.getProperty("News"))).click();
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("NewsLogo"), "NewsLogo in News");
		elementpresent(object.getProperty("TopStories"), "TopStories in News");
		clickBackward();
		
		//Gmail
		driver.findElement(By.xpath(object.getProperty("Gmail"))).click();
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("GmailLogo"), "GmailLogo in Gmail");
		elementpresent(object.getProperty("GmailSignInButton"), "Gmail SignIn Button");
		elementpresent(object.getProperty("GmailCreateAccount"), "Gmail Create Account");
		clickBackward();
		
		//Drive
		driver.findElement(By.xpath(object.getProperty("Drive"))).click();
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("GoogleDriveName"), "Google Drive Name");
		elementpresent(object.getProperty("DriveLogo"), "Drive Logo");
		elementpresent(object.getProperty("GoToGoogleDrive"), "GoTo GoogleDrive");
		elementpresent(object.getProperty("MeetDrive"), "Meet Drive");
		elementpresent(object.getProperty("UsingDrive"), "Using Drive");
		clickBackward();
		
		//Google+
		driver.findElement(By.xpath(object.getProperty("Google+"))).click();
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("Google+Logo"), "Google+Logo");
		elementpresent(object.getProperty("Google+Search"), "Google+ Search");
		clickBackward();
		
		//Translate
		driver.findElement(By.xpath(object.getProperty("Translate"))).click();
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("TranslateAppName"), "Translate App Name");
		elementpresent(object.getProperty("TranslateSubmitButton"), "Translate Submit Button");
		clickBackward();
		
		//Photos
		driver.findElement(By.xpath(object.getProperty("Photos"))).click();
		System.out.println("WebPage Title is: "+driver.getTitle());
		CheckTitle(driver.getTitle());
		elementpresent(object.getProperty("PhotosLogo"), "Photos Logo");
		elementpresent(object.getProperty("GoToPhotosButton"), "GoTo Photos Button");
		driver.navigate().back();
		System.out.println("All the Google apps are launched properly and appropriate Browsers Title & Objects are present"+"\n");
		*/
		}
		catch (Throwable t){
			TestUtil.captureScreenshot();
			Assert.assertTrue(false, t.getMessage());
		}
	}
}
