package hieutran;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Execures08_002 {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window();
	}
	@Test
	public void TC_001() throws InterruptedException{
		// get domain
		String domainHomepage = (String) executeJavaScriptToJS(driver, "return document.domain");
		Assert.assertEquals(domainHomepage, "live.guru99.com");
		
		//get url
		String urlHomepage = (String) executeJavaScriptToJS(driver, "return document.URL");
		Assert.assertEquals(urlHomepage, "http://live.guru99.com/");
		
		//click mobile
		WebElement mobilePage = driver.findElement(By.xpath("//a[text()='Mobile']"));
		executeJavaScriptToElement(driver,"arguments[0].click();", mobilePage);
		Thread.sleep(3000);
		
		// click samsungAddToCart
		WebElement samsungAddToCart = driver.findElement(By.xpath("//h2[@class='product-name' and contains(.,'Samsung Galaxy')]/following-sibling::div[@class='actions']/button"));
		executeJavaScriptToElement(driver, "arguments[0].click();", samsungAddToCart);
		Thread.sleep(3000);
		
		// scan text
		String innerText = (String) executeJavaScriptToJS(driver, "return document.documentElement.innerText;");
		Assert.assertTrue(innerText.contains("Samsung Galaxy was added to your shopping cart."));
		
		//click privacyPage
		WebElement privacyPage = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
		executeJavaScriptToElement(driver, "arguments[0].click();", privacyPage);
		Thread.sleep(3000);
		
		//get title
		String privacyTitle = (String) executeJavaScriptToJS(driver, "return document.title");
		Assert.assertEquals(privacyTitle, "Privacy Policy");
		
		//wishisText
		executeJavaScriptToJS(driver, "window.scrollBy(0,document.body.scrollHeight)");
		WebElement wishisText = driver.findElement(By.xpath("//th[text()='WISHLIST_CNT']/following-sibling::td[text()='The number of items in your Wishlist.']"));
		Assert.assertTrue(wishisText.isDisplayed());
		
		//chuyen huong
		executeJavaScriptToJS(driver, "window.location ='http://demo.guru99.com/v4/'");
		//guru99Domain
		String guru99Domain = (String) executeJavaScriptToJS(driver, "return document.domain");
		Assert.assertEquals(guru99Domain, "demo.guru99.com");
	}
	
	public static void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px groove red'", element);
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

	public Object executeJavaScriptToJS(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	@AfterTest()
	public void afterTest() {
		try {
			driver.quit();
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
