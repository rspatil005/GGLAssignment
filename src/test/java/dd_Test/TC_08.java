package dd_Test;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.ErrorCollector;
import dd_util.TestUtil;

public class TC_08 extends TestCore {
	@BeforeTest
	public void isSkip(){
		if (!TestUtil.isExecutable("TC_08 To verify the Google apps/products on Google products webpage" )) {
			throw new SkipException("Skiping test as runmode set to No");
		}
	}
	
	@Test
	public void Googleproducts() throws IOException{
		
		app_logs.debug("Executing Varify Google apps/products Test");
		System.out.println("\n"+"TC_08");
		try{
		driver.get(config.getProperty("testsite3"));
		
		WebElement products= driver.findElement(By.xpath(object.getProperty("Product")));
		List<WebElement> links=products.findElements(By.tagName(object.getProperty("tagname")));
		
		System.out.println("Google products are as below");
		Assert.assertTrue(TestUtil.products(links));
		
		System.out.println("All Products are Verified");
		}
		catch(Throwable t){
			TestUtil.captureScreenshot();
			ErrorCollector.addVerificationFailure(t);
		}
		
	}
}
