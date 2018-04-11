package hieutran;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ECommerceTestCases {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com");
		firstName = "Automation";
		lastName = "testing";
		email = "auto_testing" + radomEmail() + "@gmail.com";
		passWord = "123456789";
	}

	@Test
	public void TC_001() {
		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		String Sonyxperia = "//a[@title='Sony Xperia']/../../div[@class='price-box']/span[@id='product-price-1']/span[@class='price']";
		WebElement getTextSonyxperia = driver.findElement(By.xpath(Sonyxperia));
		String getTextRealSonyxperia = getTextSonyxperia.getText();
		driver.findElement(By.xpath("//img[@id='product-collection-image-1']")).click();
		String Verify = "//span[@id='product-price-1']/span[@class='price']";
		WebElement getText = driver.findElement(By.xpath(Verify));
		String getTextVerify = getText.getText();
		Assert.assertEquals(getTextRealSonyxperia, getTextVerify);
		System.out.println(getTextRealSonyxperia);
		System.out.println(getTextVerify);
	}

	@Test
	public void TC_002() {
		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		driver.findElement(By
				.xpath("//h2[@class='product-name']/a[@title='IPhone']/../..//div[@class='actions']/button[@class='button btn-cart']"))
				.click();
		driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("GURU50");
		driver.findElement(By.xpath("//button[@title='Apply']")).click();
		driver.findElement(By.xpath("//td[contains(text(),' Discount (GURU50)')]//following-sibling::td")).getText();
	}

	@Test
	public void TC_003() {
		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		driver.findElement(By
				.xpath("//h2[@class='product-name']/a[@title='Sony Xperia']/../..//div[@class='actions']/button[@class='button btn-cart']"))
				.click();
		driver.findElement(By.xpath("//input[@class='input-text qty']")).sendKeys("1000");
		driver.findElement(By.xpath("//button[@class='button btn-update']")).click();
		WebElement getError = driver.findElement(
				By.xpath("//span[contains(text(),'Some of the products cannot be ordered in requested quantity.')]"));
		String verifyError = getError.getText();
		Assert.assertEquals(verifyError, "Some of the products cannot be ordered in requested quantity.");
		driver.findElement(By.xpath("//button[@id='empty_cart_button']")).click();
		WebElement getEmty = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart is Empty')]"));
		String verifyEmty = getEmty.getText();
		Assert.assertEquals(verifyEmty, "SHOPPING CART IS EMPTY");

	}

	@Test
	public void TC_004() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		driver.findElement(
				By.xpath("//h2[@class='product-name']/a[@title='Sony Xperia']/../..//a[@class='link-compare']"))
				.click();
		driver.findElement(By.xpath("//h2[@class='product-name']/a[@title='IPhone']/../..//a[@class='link-compare']"))
				.click();
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		Thread.sleep(5000);
		String parentWindowHandler = driver.getWindowHandle(); // Store your
		// parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window
		// handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		 WebElement switchWindow = driver.findElement(By.xpath("//h1[contains(text(),'Compare Products')]"));
		 String verifyTitle = switchWindow.getText();
		 Assert.assertEquals(verifyTitle, "COMPARE PRODUCTS");
		 driver.findElement(By.xpath("//button[@title='Close Window']")).click();
		 driver.switchTo().window(parentWindowHandler);
	}
	
	@Test
	public void TC_005(){
		// Click My account and Create account
		driver.findElement(By.xpath("//div[@class='footer-container']//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	
		// Input to firstname
		driver.findElement(By.id("firstname")).sendKeys("hieu");
	
		// Input to lastname
		driver.findElement(By.id("lastname")).sendKeys("tran");
	
		// Random email
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		driver.findElement(By.id("email_address")).sendKeys("hieutran" + randomInt + "@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456789");
		driver.findElement(By.id("confirmation")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		String successMessage = driver.findElement(By.xpath("//div[@class='col-main']//span[contains(text(),'Thank you for registering with Main Website Store.')]")).getText();
		Assert.assertEquals(successMessage, "Thank you for registering with Main Website Store.");
		driver.findElement(By.xpath("//a[contains(text(),'TV')]")).click();
		driver.findElement(By.xpath("//h2[@class='product-name']//a[@title='LG LCD']/../..//a[@class='link-wishlist']")).click();
		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		driver.findElement(By.xpath("//textarea[@id='email_address']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("hello");
		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		WebElement XpathShared = driver.findElement(By.xpath("//span[contains(text(),'Your Wishlist has been shared.')]"));
		String getShare =  XpathShared.getText();
		Assert.assertEquals(getShare, "Your Wishlist has been shared.");			
	}
	@Test
	public void TC_006(){
		// Click My account and Create account
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//div[@class='main']//a[contains(text(),'My Wishlist')]")).click();
		driver.findElement(By.xpath("//button[@class='button btn-cart']")).click();
		String selectXpath = "//select[@id='country']";
		Select select = new Select(driver.findElement(By.xpath(selectXpath)));
		select.selectByVisibleText("United States");
		String selectXpath1 = "//select[@id='region_id']";
		Select select1 = new Select(driver.findElement(By.xpath(selectXpath1)));
		select1.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("543432");
		driver.findElement(By.xpath("//button[@title='Estimate']")).click();		
		// verify $5.00
		WebElement XpathCost = driver.findElement(By.xpath("//label/span[@class='price']"));
		String verifyCost =  XpathCost.getText();
		Assert.assertEquals(verifyCost, "$5.00");
		driver.findElement(By.xpath("//input[@id='s_method_flatrate_flatrate']")).click();
		driver.findElement(By.xpath("//button[@title='Update Total']")).click();
		// verify $5.00 for total
		WebElement XpathCost1 = driver.findElement(By.xpath("//td/span[contains(text(),'$5.00')]"));
		String verifyCost1 =  XpathCost1.getText();
		Assert.assertEquals(verifyCost1, "$5.00");
		driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();
		//billing information
		driver.findElement(By.xpath("//input[@id='billing:street1']")).sendKeys("ABC");
		driver.findElement(By.xpath("//input[@title='City']")).sendKeys("Da Nang");
		String selectXpath2 = "//select[@id='billing:region_id']";
		Select select2 = new Select(driver.findElement(By.xpath(selectXpath2)));
		select2.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@title='Zip']")).sendKeys("543432");
		driver.findElement(By.xpath("//input[@title='Telephone']")).sendKeys("123123123");
		
		driver.findElement(By.xpath("//div[@id='billing-buttons-container']//button[@title='Continue']")).click();
		// shipping method
		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/button")).click();
		driver.findElement(By.xpath("//input[@id='p_method_checkmo']")).click();
		driver.findElement(By.xpath("//div[@id='payment-buttons-container']//button[@class='button']")).click();
		driver.findElement(By.xpath("//button[@title='Place Order']")).click();
		
		//verify purchase
		WebElement XpathPurchase = driver.findElement(By.xpath("//h2[@class='sub-title']"));
		String verifyPurchase =  XpathPurchase.getText();
		Assert.assertEquals(verifyPurchase, "THANK YOU FOR YOUR PURCHASE!");
		//verify order
		WebElement XpathOrder = driver.findElement(By.xpath("//div[@class='col-main']/p[contains(text(),'Your order # is:')]/a"));
		String verifyOrder =  XpathOrder.getText();
		System.out.println(verifyOrder);
				
	}
	
	public int radomEmail() {
		Random rand = new Random();
		int number = rand.nextInt(99999) + 1;
		return number;

	}

	@AfterTest
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
	private String firstName, lastName, email, passWord;

}
