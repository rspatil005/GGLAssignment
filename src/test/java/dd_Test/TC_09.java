package dd_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.ErrorCollector;
import dd_util.TestUtil;

public class TC_09 extends TestCore{
	@BeforeTest
	public void isSkip(){
		if (!TestUtil.isExecutable("TC_09 To verify that user is able to login to Gmail")) {
			throw new SkipException("Skiping test as runmode to No");
		}
		TestCore.clearHistory();
	}
	
	@Test(dataProvider="getData")
	public void loginGmail(String id, String pass) throws IOException{
		app_logs.debug("Executing Gmail Login Test");
		System.out.println("\n"+"TC_09");
		try{
			Thread.sleep(1000);
			driver.get(config.getProperty("testsite2"));
		//Login
		driver.findElement(By.xpath(object.getProperty("Email"))).sendKeys(id);
		driver.findElement(By.xpath(object.getProperty("NXTButton"))).click();
		driver.findElement(By.xpath(object.getProperty("Password"))).sendKeys(pass);
		Thread.sleep(1000);
		driver.findElement(By.xpath(object.getProperty("PassNXTButton"))).click();
		System.out.println("Sucessfully Login to Gmail");
		
		//Finding Elements
		elementpresent(object.getProperty("GmailName"),"Gmail Name");
		elementpresent(object.getProperty("ComposeInboxAndOther"),"ComposeMail Inbox And Other");
		elementpresent(object.getProperty("GmailName"),"Gmail Name");
		System.out.println(driver.findElement(By.xpath(object.getProperty("Account"))).getAttribute("title"));
		System.out.println("Gamil is Successfully Login In");
		}
		catch (Throwable t){
			TestUtil.captureScreenshot();
			ErrorCollector.addVerificationFailure(t);
		}
		}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("TC_09");
		
	}

}
