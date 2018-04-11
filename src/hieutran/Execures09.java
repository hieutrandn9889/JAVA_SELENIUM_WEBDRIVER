package hieutran;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Execures09 {
	WebDriver driver;

	@BeforeTest()
	public void beforeTest() {
		driver = new FirefoxDriver();
		// run chrome
//		 System.setProperty("webdriver.chrome.driver",
//		 "..//JAVA_SELENIUM_WEBDRIVER/driver/chromedriver.exe");
//		 driver = new ChromeDriver();

	}

	@Test
	public void TC_001_Upload_file_by_sendkeys() {
		driver.get("http://www.helloselenium.com/2015/03/how-to-upload-file-using-sendkeys.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement fileInput = driver.findElement(By.xpath("//input[@name='uploadFileInput']"));
		fileInput.sendKeys("C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");
		WebElement fileButton = driver.findElement(By.name("uploadFileButton"));
		fileButton.click();
	}
	
	@Test
	public void TC_002_Upload_file_by_AutoIT() throws IOException, InterruptedException {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//input[@name='files[]']")).click();

		WebElement mobilePage = driver.findElement(By.xpath("//input[@name='files[]']"));
		executeJavaScriptToElement(driver,"arguments[0].click();", mobilePage);
		Thread.sleep(3000);
		 Runtime.getRuntime().exec(new String[]{"D:\\selenium\\001\\Selenium IDE\\FileUpload_Firefox.exe", "\"C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG"});
		 boolean result = (new WebDriverWait(driver, 30)).until(new
		 ExpectedCondition<Boolean>() {
		 public Boolean apply(WebDriver _driver) {
		 return _driver.findElement(By.xpath("//table[@role='presentation']//p[@class='name' and contains(text(),'1.JPG')]")).isDisplayed();}
		 });
		 Assert.assertTrue(result);
	}

	@Test
	public void TC_003_Upload_file_by_Robot_class() throws InterruptedException, AWTException {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Specify the file location with extension
		StringSelection select = new StringSelection("C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG");

		//Copy to clipboard ==> copy C:\\Users\\MyPC\\Desktop\\hinhanh\\1.JPG vao input
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		//Click
		driver.findElement(By.className("fileinput-button")).click();

		Robot robot = new Robot();
		Thread.sleep(1000);
		// keyPress : nhan phim
		// keyRelease : nha phim
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@Test
	public void TC_004_Upload_file_on_PRES() throws InterruptedException, IOException{
		driver.get("http://staging.preciseres.com/WAFForm.aspx?_act=Open&_tab=LoanApplication&_for=CBRLoanStatisticDetails&_pky=733");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Input userName and passWord
		driver.findElement(By.xpath("//input[@id='__uid']")).sendKeys("auto_test");
		driver.findElement(By.xpath("//input[@id='__pwd']")).sendKeys("auto_test");
		driver.findElement(By.xpath("//button[@class='btn btn-large btn-primary']")).click();
		driver.findElement(By.xpath("//a[@id='CBRPropertyTB']//span[contains(text(),'Properties')]")).click();
		
		// index
		driver.findElement(By.xpath("//div[@class='MenuActions menu-actions'][1]//a[@id='Search']")).click();
		driver.findElement(By.xpath("//input[@id='AddressLine1']")).sendKeys("64647 DANANG VN");
		
		//click search
		driver.findElement(By.xpath("//input[@class='SearchAction btn btn-info btn-sm']")).click();
		
		//click 64647 DANANG VN
		driver.findElement(By.xpath("//a[contains(text(),'64647 DANANG VN')]")).click();
		Thread.sleep(3000);
		
		//scroll to element
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'New')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		//click new button
		driver.findElement(By.xpath("//a[contains(text(),'New')]")).click();
		
		// Send key //input[@id='CBRDocumentLADetails_R1_OtherFormType']
		driver.findElement(By.xpath("//input[@id='CBRDocumentLADetails_R1_OtherFormType']")).sendKeys("HieuTran");
		
		//upload file
		driver.findElement(By.xpath("//input[@id='CBRDocumentLADetails_R1_DocumentFile']")).click();
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Firefox.exe");
		
		//click save button
		driver.findElement(By.xpath("//a[@id='Save']")).click();
		
		//verify record		
		WebElement recordXpath = driver.findElement(By.xpath("//span[contains(text(),'Record saved')]"));
		boolean recordElement = recordXpath.isDisplayed();
		Assert.assertTrue(recordElement);
		
		// verify table
		WebElement xpathTable= driver.findElement(By.xpath("//a[contains(text(),'1.JPG')]"));
		boolean tableElement = xpathTable.isDisplayed();
		Assert.assertTrue(tableElement);
		
		// click Property
		driver.findElement(By.xpath("//a[@id='GotoLAProp']")).click();
		
		//scroll end page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); 
		
		//verify
		WebElement xpathDocumentType = driver.findElement(By.xpath("//td[a[span[contains(.,'HieuTran')]]]"));
		String textDocumentType = xpathDocumentType.getText();
		Assert.assertEquals(textDocumentType, "HieuTran");
		
		WebElement xpathDocumentFile = driver.findElement(By.xpath("//td[a[span[contains(.,'HieuTran')]]]/following-sibling::td[@class='FieldTypeFile']/a[@title='1.JPG']"));
		boolean DocumentFile = xpathDocumentFile.isDisplayed();
		Assert.assertTrue(DocumentFile);
		
	}
	
	@Test
	public void TC_005_test() throws IOException{
		driver.get("http://www.helloselenium.com/2015/03/how-to-upload-file-using-sendkeys.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement fileInput = driver.findElement(By.xpath("//input[@name='uploadFileInput']"));
		fileInput.click();
		// Input userName and passWord
		Runtime.getRuntime().exec("D:\\selenium\\001\\Selenium IDE\\FileUpload_Firefox.exe");		
	}
	
	public Object executeJavaScriptToElement(WebDriver driver, String javaSript, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript, element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
		
	@AfterTest()
	public void afterTest() {
		try {
//			 driver.quit();
			System.gc();
			if (driver.toString().toLowerCase().contains("chrome")) {
				String cmd = "taskkill /IM chromedriver.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				String cmd = "taskkill /IM IEDriverServer.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
