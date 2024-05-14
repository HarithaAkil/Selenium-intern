package org.classbase;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.seleniumhq.jetty9.server.LowResourceMonitor.MainThreadPoolLowResourceCheck;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	
	public static void launchBrowse () {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	public static void 	WindowMaximize() {
		driver.manage().window().maximize();
	}
	public static void launchUrl(String url) {
		driver.get(url);
		
	}
	public static String pageTitle() {
		String title =driver.getTitle();
		System.out.println(title);
		return title;
	}
	public static  String pageUrl () {
		String url =driver.getCurrentUrl();
		System.out.println(url);
		return url;
		
	}
	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}
	public static void closeEntireBrowser() {
		driver.quit();
	}
	public static void clickBtn(WebElement ele) {
		ele.click();		
	}
	public static void screenShot(String imgName)throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File image = ts.getScreenshotAs(OutputType.FILE);
	File f =new File("location+ imgName.png");
	FileUtils.copyFile(image, f); 
	}
	
	public static Actions a;
		public static void moveThecursor(WebElement targetWebElement) {
			a = new Actions(driver);
			a.moveToElement(targetWebElement).perform();
			
		}
		public static void dragDrop(WebElement targetWebElement,WebElement dropElement) {	
	a = new Actions (driver);
	a.dragAndDrop(dropElement, targetWebElement).perform();
		}
		
		public static	JavascriptExecutor js;	
		public static void scrollThePage(WebElement tarWebEle) {
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", tarWebEle);		
		}
		public static void scroll(WebElement element) {
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(false)", element);
		}
		
		public static void excelRead(String sheetName,int Row, int cellNum) throws IOException {
		File f = new File("C:\\Users\\kavin\\eclipse-workspace\\Datadriven\\excel\\inmakes.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook fb = new XSSFWorkbook(fis);
		Sheet mySheet = fb.getSheet("inmakes");	 
		Row r	=  mySheet.getRow(cellNum);
		Cell c = r.getCell(Row);
		int cellType = c.getCellType();
		
		String value =" ";
		if (cellType==1) {
			String value2 = c.getStringCellValue();
				
			}
				
			else if (DateUtil.isCellDateFormatted(c)) {
				Date datecell = c.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yy"); 
				String value2= s.format(datecell);
				System.out.println(value);
				
			}
			else {
				double d = c.getNumericCellValue();
				long l =(long)d;
				String valueof = String.valueOf(l);
				System.out.println(value);
			}
		
		}
		
		
			public static void createNewExcelFile(int getRow, int creCell,String newData) throws IOException {
				File  f = new File("C:\\Users\\kavin\\eclipse-workspace\\Datadriven5\\Excel\\newfile.xlsx");
				Workbook w = new XSSFWorkbook();
				Sheet newsheet = w.createSheet("datadriven5");
				Row newrow = newsheet.createRow(0);
				Cell newcell = newrow.createCell(0);
				newcell.setCellValue("Datas");
				FileOutputStream fos = new FileOutputStream(f);
			    w.write(fos);
			}
			public static void createRow(int getRow, int creCell,String newData) throws IOException {
				File  f = new File("C:\\Users\\kavin\\eclipse-workspace\\Datadriven5\\Excel\\newfile.xlsx");
				Workbook w = new XSSFWorkbook();
				Sheet newsheet = w.createSheet("datadriven5");
				Row newrow = newsheet.createRow(0);
				Cell newcell = newrow.createCell(0);
				newcell.setCellValue("newdata");
				FileOutputStream fos = new FileOutputStream(f);
			    w.write(fos);
			}
			
			public static void updateDataToPaticularCell(int getRow, int creCell,String newData, Object existingData) throws IOException {
				File  f = new File("C:\\Users\\kavin\\eclipse-workspace\\Datadriven5\\Excel\\newfile.xlsx");
				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fis); 
				Sheet s = wb.getSheet("datadriven5");
				Row r = s.getRow(getRow);
				Cell c= r.getCell(creCell);
				String str = c.getStringCellValue();
				if (str.equals(existingData)) {
					c.setCellValue(newData);
				}
				
				FileOutputStream fos = new FileOutputStream(f);
			    
				wb.write(fos);
			}
	
}


