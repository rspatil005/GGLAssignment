package dd_Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.TestUtil;

public class TC_06 extends TestCore{
	@BeforeTest
	public void isSkip(){
		if (!TestUtil.isExecutable("TC_06 To open and close the browser")) {
			throw new SkipException("Skiping test as runmode to No");
		}
	}
	
	@Test
	public void OpenAndCloseBrowser() throws IOException{
		app_logs.debug("Executing Open And Close Browser Test");
		System.out.println("\n"+"TC_06");
		try{
			openAnotherBrowser();
			Thread.sleep(2000L);
		    driver2.quit();
		    System.out.println("Open and Close Browser Successfully");
		}
		catch (Throwable t){
			TestUtil.captureScreenshot();
			Assert.assertTrue(false, t.getMessage());
			}
	}
}
