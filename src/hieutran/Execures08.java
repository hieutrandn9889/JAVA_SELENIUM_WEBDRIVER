package hieutran;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Execures08 {
	WebDriver driver;
	@BeforeTest()
	public void beforeTest(){
//		 driver = new FirefoxDriver();
		// run IE
				 System.setProperty("webdriver.ie.driver",
				 "..//JAVA_SELENIUM_WEBDRIVER/driver/IEDriverServer.exe");
				 driver = new InternetExplorerDriver();
	}
	@Test
	public void TC_001(){
		driver.get("http://live.guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//JE để get domain của page
		JavascriptExecutor js_00 = (JavascriptExecutor) driver;
		String domain = (String) js_00.executeScript("return document.domain");
		System.out.println(domain);
		Assert.assertEquals(domain, "live.guru99.com");
		
		//JE để get URL của page
		JavascriptExecutor js_01 = (JavascriptExecutor) driver;
		String URL = (String) js_01.executeScript("return document.URL");
		// get URL của page
		String getUrl =  driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://live.guru99.com/");
		Assert.assertEquals(getUrl, "http://live.guru99.com/");
		
		//Open MOBILE page (Sử dụng JE)
		WebElement element_00 = driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element_00);
		
		//Add sản phẩm SAMSUNG GALAXY vào Cart
		WebElement element_01 = driver.findElement(By.xpath("//h2[@class='product-name' and contains(.,'Samsung Galaxy')]/following-sibling::div[@class='actions']/button"));
		JavascriptExecutor js01 = (JavascriptExecutor)driver;
		js01.executeScript("arguments[0].click();", element_01);
		
		//Verify message được hiển thị
		JavascriptExecutor js02 = (JavascriptExecutor)driver;
		String sText = js02.executeScript("return document.documentElement.innerText;").toString();
		Assert.assertTrue(sText.contains("Samsung Galaxy was added to your shopping cart."));
		
		//Open PRIVACY POLICY page
		WebElement element_02 = driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]"));
		JavascriptExecutor js03 = (JavascriptExecutor)driver;
		js03.executeScript("arguments[0].click();", element_02);
		// get title
		JavascriptExecutor js04 = (JavascriptExecutor)driver;
		String sText_01 =  js04.executeScript("return document.title;").toString();
		Assert.assertTrue(sText_01.contains("Privacy Policy"));
		
		//scroll end page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		// Verify dữ liệu có hiển thị với chỉ 1 xpath: 
		JavascriptExecutor js05 = (JavascriptExecutor)driver;
		String sText_02 = js05.executeScript("return document.documentElement.innerText;").toString();
		Assert.assertTrue(sText_02.contains("The number of items in your Wishlist."));
		WebElement xpathText = driver.findElement(By.xpath("//th[contains(text(),'WISHLIST_CNT')]/following-sibling::td[contains(text(),'The number of items in your Wishlist.')]"));
		Assert.assertTrue(xpathText.isDisplayed());
		
		// Navigate tới domain
		JavascriptExecutor js06 = (JavascriptExecutor)driver;
		js06.executeScript("window.location = 'http://demo.guru99.com/v4/'");
		JavascriptExecutor js_07 = (JavascriptExecutor) driver;
		String domain_01 = (String) js_07.executeScript("return document.domain");
		Assert.assertEquals(domain_01, "demo.guru99.com");
		
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
