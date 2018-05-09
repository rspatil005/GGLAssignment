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

public class TC_02 extends TestCore{
	@BeforeTest
	public void isSkip(){
		if (!TestUtil.isExecutable("TC_02 To verify all the Google apps (My Account, Search, Maps, YouTube, Play, News, Gmail, Drive, Google+, Translate, Photos) in the dialog box")) {
			throw new SkipException("Skiping test as runmode set to No");
		}
	}
	
	@Test
	public void verifyGoogleApps() throws IOException{
		app_logs.debug("Executing Varify google Apps Test");
		System.out.println("\n"+"TC_02");
		
		try{
		driver.findElement(By.xpath(object.getProperty("GoogleApps"))).click();
		
		elementpresent(object.getProperty("MyAccount"), "MyAccount App");
		elementpresent(object.getProperty("Search"),"Search App");
		elementpresent(object.getProperty("Maps"),"Map");
		elementpresent(object.getProperty("YouTube"),"YouTube");
		elementpresent(object.getProperty("Play"),"PlayStore");
		elementpresent(object.getProperty("News"),"News");
		elementpresent(object.getProperty("Gmail"),"Gmail");
		elementpresent(object.getProperty("Drive"),"Drive");
		elementpresent(object.getProperty("Calendar"),"Calendar");
		elementpresent(object.getProperty("Google+"),"Google+");
		elementpresent(object.getProperty("Translate"),"Translate");
		elementpresent(object.getProperty("Photos"),"Photos");
		
		System.out.println("TC_02: All Google App in DialogBox are present"+"\n");
	}
		catch (Throwable t){
			TestUtil.captureScreenshot();
			ErrorCollector.addVerificationFailure(t);
			}
	}
}
