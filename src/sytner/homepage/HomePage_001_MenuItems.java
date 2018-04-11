package sytner.homepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage_001_MenuItems {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void MenuItems_001_AboutUs() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		// 2. Click on About us menu item""
		driver.findElement(By.xpath("//a[@title='About Us']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_002_News() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on News menu item"
		driver.findElement(By.xpath("//a[@title='News']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_003_CustomerService() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on customer Service menu item"
		driver.findElement(By.xpath("//a[@title='Customer Service']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_004_Careers() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Careers menu item"
		driver.findElement(By.xpath("//a[@title='Careers']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_005_Finance() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Finance menu item"
		driver.findElement(By.xpath("//a[@title='Finance']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_006_SavedVehicles() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Saved vehicles menu item"
		driver.findElement(By.xpath("//a[@title='Saved Vehicles']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_007_UsedCarSearch() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Used Car Search menu item"
		driver.findElement(By.xpath("//span[contains(text(),'Used Car Search')]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_008_NewCars() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on New Cars menu item"
		driver.findElement(By.xpath("//span[contains(text(),'New Cars')]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_009_CarMaintenance() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Car Maintenance menu item"
		driver.findElement(By.xpath("//span[contains(text(),'Car Maintenance')]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_010_Promotions() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Car Maintenance menu item"
		driver.findElement(By.xpath("//span[contains(text(),'Promotions')]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_011_BusinessUsers() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Car Maintenance menu item"
		driver.findElement(By.xpath("//span[contains(text(),'Business Users')]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_012_SellYourCar() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Car Maintenance menu item"
		driver.findElement(By.xpath("//span[contains(text(),'Sell your car')]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void MenuItems_013_DealerLocator() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Car Maintenance menu item"
		driver.findElement(By.xpath("//span[contains(text(),'Dealer Locator')]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void MenuItems_014_HomeIcon() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Car Maintenance menu item"
		driver.findElement(By.xpath("//span[contains(text(),'Dealer Locator')]")).click();
		// 3. Click on Home Icon menu item"
		driver.findElement(By.xpath("//a[@title='Home']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void MenuItems_015_SytnerGroupLogo() {
		// 1. Open Sytner site
		driver.navigate().to("http://www.sytner.co.uk/");
		// 2. Click on Car Maintenance menu item"
		driver.findElement(By.xpath("//span[contains(text(),'Dealer Locator')]")).click();
		// 3. Click on Home Icon menu item"
		driver.findElement(By.xpath("//a[@title='Sytner Group Limited']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

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

}
