package dd_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import dd_core.TestCore;
import dd_util.TestUtil;

public class TC_04 extends TestCore{//////////////Log Out Each App And SignIn Another
	
	@BeforeTest
	public void isSkip(){
		if (!TestUtil.isExecutable("TC_04 To verify that the user is able to Sign-in into all the Google apps (My Account, Search, Maps, YouTube, Play, News, Gmail, Drive, Calender, Google+, Translate, Photos)" )) {
			throw new SkipException("Skiping test as runmode to No");
		}
	}
	@Test(dataProvider="getData")
	public void loginApp(String id, String pass) throws IOException, InterruptedException{
		app_logs.debug("Executing SignIn to Google Apps Test");
		System.out.println("\n"+"TC_04");
		try{
		
		//For My Account
			Thread.sleep(2000);
				driver.findElement(By.xpath(object.getProperty("GoogleApps"))).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(object.getProperty("MyAccount"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				driver.findElement(By.xpath(object.getProperty("MyAccountSignIn"))).click();
				
				driver.findElement(By.xpath(object.getProperty("Email"))).sendKeys(id);
				driver.findElement(By.xpath(object.getProperty("NXTButton"))).click();
				driver.findElement(By.xpath(object.getProperty("Password"))).sendKeys(pass);
				Thread.sleep(1000);
				driver.findElement(By.xpath(object.getProperty("PassNXTButton"))).click();
				
				System.out.println(driver.findElement(By.xpath(object.getProperty("MyAccountUserName"))).getText());
				clickBackward();
				
				//for Google search
				driver.findElement(By.xpath(object.getProperty("Search"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				System.out.println(driver.findElement(By.xpath(object.getProperty("SignInUserName"))).getAttribute(object.getProperty("TitleName")));
				clickBackward();
				/*
				//for Gmap
				driver.findElement(By.xpath(object.getProperty("Maps"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				System.out.println(driver.findElement(By.xpath(object.getProperty("GmapUserName"))).getAttribute(object.getProperty("TitleName")));
				//clickBackward();
				//To log-out from google apps
				Thread.sleep(2000);
				driver.navigate().to(config.getProperty("testsite"));
				driver.findElement(By.xpath(object.getProperty("SignInUserName"))).click();
				System.out.println("click on profile");
				Thread.sleep(1500);
				driver.findElement(By.xpath(object.getProperty("Log_Out"))).click();
				System.out.println("logout");
				Thread.sleep(1500);
				
				//for Youtube
				driver.findElement(By.xpath(object.getProperty("YouTube"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				Thread.sleep(2000);
				driver.findElement(By.xpath(object.getProperty("YoutubeAccount"))).click();
				System.out.println(driver.findElement(By.xpath(object.getProperty("YoutubeAccName"))).getText());
				clickBackward();
				
				
				//Play Store
				driver.findElement(By.xpath(object.getProperty("Play"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				System.out.println(driver.findElement(By.xpath(object.getProperty("PlayStoreName"))).getAttribute(object.getProperty("TitleName")));
				clickBackward();
				
				//News
				driver.findElement(By.xpath(object.getProperty("News"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				System.out.println(driver.findElement(By.xpath(object.getProperty("NewsUserName"))).getAttribute(object.getProperty("LabelName")));
				clickBackward();
				
				//Gmail
				driver.findElement(By.xpath(object.getProperty("Gmail"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				System.out.println(driver.findElement(By.xpath(object.getProperty("PlayStoreName"))).getAttribute(object.getProperty("TitleName")));
				clickBackward();	
				
				//Drive
				driver.findElement(By.xpath(object.getProperty("Drive"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				System.out.println(driver.findElement(By.xpath(object.getProperty("DriveUserName"))).getAttribute(object.getProperty("LabelName")));
				clickBackward();
				//Google+
				driver.findElement(By.xpath(object.getProperty("Google+"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				System.out.println(driver.findElement(By.xpath(object.getProperty("Google+UserName"))).getAttribute(object.getProperty("TitleName")));
				clickBackward();
				
				//Translate
				driver.findElement(By.xpath(object.getProperty("Translate"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				System.out.println(driver.findElement(By.xpath(object.getProperty("TranslateUserName"))).getAttribute(object.getProperty("TitleName")));
				clickBackward();
				
				//Photos
				driver.findElement(By.xpath(object.getProperty("Photos"))).click();
				System.out.println("WebPage Title is: "+driver.getTitle());
				System.out.println(driver.findElement(By.xpath(object.getProperty("PhotosUserName"))).getAttribute(object.getProperty("TitleName")));
				clickBackward();
				System.out.println("TC_04 All the Google apps are launched properly and appropriate Browsers Title & Objects are present"+"\n");
		*/}
		catch (Throwable t){
			TestUtil.captureScreenshot();
			Assert.assertTrue(false, t.getMessage());
		}

	}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("TC_09");
		
	}

}
