package dd_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.ErrorCollector;
import dd_util.TestUtil;

public class TC_01 extends TestCore{
	
	
	@BeforeTest
	public void isSkip(){
		if (!TestUtil.isExecutable("TC_01 To verify that the Google web page is launched successfully")) {
			throw new SkipException("Skiping test as runmode to No");
		}
	}
	
	@Test
	public void launch() throws IOException{
		
		app_logs.debug("Executing Launching Test");
		try{
		System.out.println("TC_01");
		
		System.out.println(driver.getTitle());
		elementpresent(object.getProperty("inputBox"),"Search Box");
		elementpresent(object.getProperty("searchButton"), "Search Button");
		elementpresent(object.getProperty("FeelingButton"), "Feeling Button");
		elementpresent(object.getProperty("signIn"), "SignIn Button");
		System.out.println("TC_01: Google Web Page is launched Successfully");
		
		}
		catch (Throwable t){
			TestUtil.captureScreenshot();
			ErrorCollector.addVerificationFailure(t);
		}
	}
}
