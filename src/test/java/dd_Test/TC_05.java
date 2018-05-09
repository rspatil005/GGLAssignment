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

public class TC_05 extends TestCore {
	@BeforeTest
	public void isSkip(){
	if(!TestUtil.isExecutable("TC_05 To verify that clicking on the language links (Hindi, Marathi etc) launches Google in respective language"))
	{
			throw new SkipException("Skiping test as runmode set to No");
	}
}
	@Test(dataProvider="getData")
	public void changeLanguage(String HindiLanguage, String signIn,String GoogleSearch, String FeelingLucky ) throws InterruptedException, IOException{
			
		app_logs.debug("Executing Google Language Changing Test");
		try{
			System.out.println("\n"+"TC_05");
			Thread.sleep(3000);
			driver.findElement(By.xpath(object.getProperty("HindiLanguage"))).click();
			
			System.out.println("Clicking on "+driver.findElement(By.xpath(object.getProperty("HindiLanguage"))).getText()+" Language link");
			Thread.sleep(3000);
			
			String Google_search=driver.findElement(By.xpath(object.getProperty("GoogleSearch"))).getAttribute("value");
			System.out.println(Google_search+" is present");
			
			String sign_In=driver.findElement(By.xpath(object.getProperty("SignIn"))).getText();
			System.out.println(sign_In +" is present");
			
			String feeling_Lucky=driver.findElement(By.xpath(object.getProperty("FeelingLucky"))).getAttribute("value");
			System.out.println(feeling_Lucky +" is present");
			
			Assert.assertTrue(TestUtil.lang(HindiLanguage, signIn, GoogleSearch, FeelingLucky, Google_search, sign_In,feeling_Lucky));
			
			driver.findElement(By.xpath(object.getProperty("HindiLanguage"))).click();
		}
		catch (Throwable t){
			TestUtil.captureScreenshot();
			ErrorCollector.addVerificationFailure(t);
		}
	}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("TC_05");
		
	}

}
