package dd_util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dd_core.TestCore;

public class TestUtil extends TestCore {
	//Check testCase is skip or not
	public static boolean isExecutable(String tcid){
		
		for(int rowNum=2; rowNum<=excel.getRowCount("test_suite"); rowNum++){
			
			if(excel.getCellData("test_suite", "TCID", rowNum).equals(tcid)){
				if(excel.getCellData("test_suite", "runmode", rowNum).equalsIgnoreCase("Y")){
					
					return true;
				}
				else
					return false;
			}
		}
		return false;
	}
	

	//Read data from excel file
	public static Object[][] getData(String sheetName){
		
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		Object[][] data=new Object[rows-1][cols];
		
		for (int rowNum = 2; rowNum <=rows; rowNum++) {
			for (int colNum = 0; colNum <cols; colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
	
	
	//Capturing ScreenShots
	public static void captureScreenshot() throws IOException{
			
			Calendar cal = new GregorianCalendar();
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			int sec = cal.get(Calendar.SECOND);
			int min = cal.get(Calendar.MINUTE);
			int date = cal.get(Calendar.DATE);
			int day = cal.get(Calendar.HOUR_OF_DAY);
			
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    try {
		    	String mailscreenshotpath = System.getProperty("user.dir")+"\\screenshot\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
				FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
			} catch (IOException e) {
				e.printStackTrace();
		}
	}

// make zip of reports
	public static void zip(String filepath){
	 	try
	 	{
	 		File inFolder=new File(filepath);
	 		File outFolder=new File("Reports.zip");
	 		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
	 		BufferedInputStream in = null;
	 		byte[] data  = new byte[1000];
	 		String files[] = inFolder.list();
	 		for (int i=0; i<files.length; i++)
	 		{
	 			in = new BufferedInputStream(new FileInputStream
	 			(inFolder.getPath() + "/" + files[i]), 1000);  
	 			out.putNextEntry(new ZipEntry(files[i])); 
	 			int count;
	 			while((count = in.read(data,0,1000)) != -1)
	 			{
	 				out.write(data, 0, count);
	 			}
	 			out.closeEntry();
	 		}
	 		out.flush();
	 		out.close();
	 	
	 	}
	 	catch(Exception e)
	 	{
	  e.printStackTrace();
	 	} 
 }
	
	//TC_03 Check Title
	public static boolean testTitle(String actualTitle){
		int rows=excel.getRowCount("TC_03");
		int colNum=0;
		for (int rowNum = 2; rowNum <=rows; rowNum++) 
		{
				 if(excel.getCellData("TC_03",colNum , rowNum).equals(actualTitle))
			     return true;
	   }
		System.out.println("Browser Title Didnot Match");
		return false;
		}
	
	//TC_05 Checking Language changing
	public static boolean lang(String HindiLanguage, String signIn,String GoogleSearch, String FeelingLucky,String Google_search, String sign_In,String feeling_Lucky) throws InterruptedException{
		
		boolean b=true;
		//for objects marked red
		if (GoogleSearch.equals(Google_search) && FeelingLucky.equals(feeling_Lucky) && signIn.equals(sign_In)) {
			b=true;
		}
		else
			return false;
		
		//for loop to check language
		for (int i = 1; i <=9; i++) {
			String languages=driver.findElement(By.xpath(object.getProperty("Start")+i+object.getProperty("end"))).getText();
			
			if (HindiLanguage.equals(languages)) {
				b=false;
				System.out.println(HindiLanguage+" language link is not disappear");
				return b;
			}
		}
		return b;
	}
	
	/*//TC_07 (Method 1-> To print and check search List
	public static void search(List<WebElement> name){
		
		for (int i = 0; i<(name.size()/2); i++) {
		
			System.out.println(name.get(i).getText());
		
		}
	}
*/	
	//public static boolean compairSearchInput()
	public static boolean search(List<WebElement> name,String input){
		
		boolean b=true;
		
		for (int i = 0; i<(name.size()/2); i++) {
			System.out.println(name.get(i).getText());
			
			String str=name.get(i).getText();
		if (str.contains(input)) {
			b=true;
		}else{
			return false;
		}
	}
		return b;
}

	
	//TC_08 Products
	public static boolean products(List<WebElement> links){
		int rows=excel.getRowCount("TC_08");
		int colNum=0;
		
		
		for (int i = 0; i < links.size(); i++) {
		boolean bol=false;
		String prod=links.get(i).getText();
		
		
			for (int rowNum = 2; rowNum <=rows; rowNum++) {
				
				if(excel.getCellData("TC_08",colNum , rowNum).equals(prod)){
					System.out.println(prod);
					bol=true;
				 }
	   }
			if (bol==false) {
				System.out.println(prod+" is not found");
				return bol;
			}
	}
	return true;
	}

}
