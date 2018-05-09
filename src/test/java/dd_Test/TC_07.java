package dd_Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.ErrorCollector;
import dd_util.TestUtil;

public class TC_07 extends TestCore{
	@BeforeTest
	public void isSkip(){
		if (!TestUtil.isExecutable("TC_07 To validate that the Google performs the search operation properly")) {
			throw new SkipException("Skiping test as runmode to No");
		}
	}
	@Test
	public void ValidateSearchOperation() throws InterruptedException, IOException{
		app_logs.debug("Executing Varify Google Search Operation Test");
		System.out.println("\n"+"TC_07");
		try{
		//For Amitabh Bachchan
		System.out.println("****Amitabh Bachchan****");
		Thread.sleep(3000);
		driver.findElement(By.xpath(object.getProperty("inputBox"))).sendKeys(SearchInput1);
		Thread.sleep(1000);
		driver.findElement(By.xpath(object.getProperty("inputBox"))).sendKeys(Keys.ENTER);
		
		searchInput(object.getProperty("links"),SearchInput1,verifyInput1);
		driver.navigate().back();
		
		//For Abdul Kalam
		System.out.println("\n"+"****Abdul Kalam****");
		Thread.sleep(3000);
		driver.findElement(By.xpath(object.getProperty("inputBox"))).sendKeys(SearchInput2);
		Thread.sleep(1000);
		driver.findElement(By.xpath(object.getProperty("inputBox"))).sendKeys(Keys.ENTER);
		searchInput(object.getProperty("links"),SearchInput2,verifyInput2);
		System.out.println("\n"+"Google Performs Search Operation");
		}
		catch (Throwable t){
		TestUtil.captureScreenshot();
		ErrorCollector.addVerificationFailure(t);
		}
	}
}
