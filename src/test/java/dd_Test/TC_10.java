package dd_Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.TestUtil;

public class TC_10 extends TestCore{
	@BeforeTest
	public void isSkip(){
		if (!TestUtil.isExecutable("TC_10 To verify the total no. of emails received by the user" )) {
			throw new SkipException("Skiping test as runmode to No");
		}
	}
	@Test
	public void countMails() throws IOException{
		app_logs.debug("Executing Varify Total Number of Received Emails Test");
		System.out.println("\n"+"TC_10");
		try{
			
		while(OldermailButton==true){
			String OlderMailsIsClickable=driver.findElement(By.xpath(object.getProperty("ClickOnOlderMails"))).getAttribute(object.getProperty("OlderMailsEnable/Disable"));
			
			WebElement element=driver.findElement(By.xpath(object.getProperty("mailTable")));
			List<WebElement> list= element.findElements(By.tagName(object.getProperty("mailTagName")));
			mails=mails+list.size();
			driver.findElement(By.xpath(object.getProperty("ClickOnOlderMails"))).click();
			
			if(OlderMailsIsClickable!=null){
				OldermailButton=false;
			}
		}
		System.out.println("Total Received Mails are: "+mails);
		}
		
		catch(Throwable t){
			TestUtil.captureScreenshot();
			Assert.assertTrue(false, t.getMessage());
		}
	}
}
