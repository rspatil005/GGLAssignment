package dd_core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import dd_util.ErrorCollector;
import dd_util.ExcelReader;
import dd_util.TestConfig;
import dd_util.TestUtil;
import dd_util.monitoringMail;

public class TestCore {
	public static Properties config= new Properties();
	public static Properties object= new Properties();
	public static ExcelReader excel=null;
	public static WebDriver driver=null;
	public static String mailscreenshotpath;
	public static WebDriver driver2=null;
	public static FileInputStream fis;
	public static Logger app_logs= Logger.getLogger("devpinoyLogger");
	//For TC_07
	public static String SearchInput1="Amitabh Bachchan";
	public static String verifyInput1="Amitabh Bachchan";
	public static String SearchInput2="Abdul Kalam";
	public static String verifyInput2="Abdul Kalam";
	//For TC_10
	public static int mails=0;
	public static boolean OldermailButton=true;

	@BeforeSuite
	public void init() throws IOException{
		if (driver==null) {
			
			//loading config property file
			fis= new FileInputStream (System.getProperty("user.dir")+"\\src\\test\\java\\dd_properties\\config.properties");
			config.load(fis);
			app_logs.debug("Loading the config property file");
			
			//loading object prop file
			
			fis=new FileInputStream (System.getProperty("user.dir")+"\\src\\test\\java\\dd_properties\\object.properties");
			object.load(fis);
			app_logs.debug("Loading the object property file");
			
			//loading excel file
			
			excel= new ExcelReader (System.getProperty("user.dir")+"\\src\\test\\java\\dd_properties\\testData.xlsx");
			app_logs.debug("Loading the excel property file");
			
			if (config.getProperty("browser").equals("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver-v0.16.1-win32\\geckodriver.exe");

				driver = new FirefoxDriver();
				
			}
			else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver", "D:\\Library\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
				
				driver = new  InternetExplorerDriver();
				
			}
			else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","D:\\Library\\chromedriver_win32\\chromedriver.exe");
				
				driver = new ChromeDriver();
				
			}
			//Implicite wait
			driver.manage().timeouts().implicitlyWait(120L, TimeUnit.SECONDS);
			driver.get(config.getProperty("testsite"));
			
		}
	}
	//(Method-01) Error Handling for Element present/Not (isElementPresent) 
		public static void elementpresent(String locator,String string) throws IOException{
			try{
			Assert.assertTrue(TestCore.ElementPresent(locator));
			
			System.out.println(string+" Element: Present");
			}catch (Throwable t){
				System.out.println(string+ " Element: Not Present");
				TestUtil.captureScreenshot();
				ErrorCollector.addVerificationFailure(t);
			}
		}
		// (Method-02) for Element present/Not (isElementPresent)
		public static boolean ElementPresent(String locator){
			try {
				driver.findElement(By.xpath(locator));
				return true;
			} catch (Throwable t) {
				return false;
			}
		}
		
		//Error Handling for Checking WebPage Title is correct/Not TC_03
		public static void CheckTitle(String actualTitle) throws IOException{
			try{
			Thread.sleep(1500);
			Assert.assertTrue(TestUtil.testTitle(actualTitle));
			
			}catch (Throwable t){
				TestUtil.captureScreenshot();
				ErrorCollector.addVerificationFailure(t);
			}
		}
	
		//Move to backward page TC_03/04
		public static void clickBackward() throws InterruptedException{
			driver.navigate().to(config.getProperty("testsite"));
			Thread.sleep(1000);
			driver.findElement(By.xpath(object.getProperty("GoogleApps"))).click();
			Thread.sleep(2000);
		}
		
	// Open Second Browser TC_06
	public static void openAnotherBrowser(){
		if (driver2==null) {
			
		if (config.getProperty("browser2").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Library\\chromedriver_win32\\chromedriver.exe");
			driver2 = new ChromeDriver();
		}
		}
	}
	//Error Handling to Check SearchOperation TC_07
			public static void searchInput(String links, String searchinput, String verifySearch) throws IOException{
				try{
					WebElement block=driver.findElement(By.xpath(links));
					List<WebElement> name=block.findElements(By.partialLinkText(searchinput));
					
					Assert.assertTrue(TestUtil.search(name,verifySearch));
				}
				catch (Throwable t){
					System.out.println("Search Operation is Failed");
					TestUtil.captureScreenshot();
					ErrorCollector.addVerificationFailure(t);
				}
			}
	
	//Clear Browser History
	public static void clearHistory(){
		driver.get(config.getProperty("browserHistory"));
		driver.findElement(By.cssSelector(config.getProperty("clearHistory"))).click();
		
	}
	
	@AfterSuite
	public void QuiteDriver() throws InterruptedException, AddressException, MessagingException{
				Thread.sleep(10000L);
				driver.quit();
			//Make Zip File of Reports
				TestUtil.zip(System.getProperty("user.dir")+"\\screenshot");
			//send mail
				//monitoringMail mail= new monitoringMail();
				//mail.sendMail(TestConfig.server,TestConfig.from , TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
			
	}	
}
