package sytner.homepage;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage_003_JumpPoints {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
	}

	@Ignore
	public void JumpPoints_001_Alpina() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_001 = driver.findElement(By.xpath("//a[@title='ALPINA']"));
		builder.moveToElement(xpath_001).perform();
		builder.click(xpath_001).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Ignore
	public void JumpPoints_002_Audi() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_002 = driver.findElement(By.xpath("//a[@title='Audi']"));
		builder.moveToElement(xpath_002).perform();
		builder.click(xpath_002).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Ignore
	public void JumpPoints_003_Bentley() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_003 = driver.findElement(By.xpath("//a[@title='Bentley']"));
		builder.moveToElement(xpath_003).perform();
		builder.click(xpath_003).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Ignore
	public void JumpPoints_004_BMW() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_004 = driver.findElement(By.xpath("//a[@title='BMW']"));
		builder.moveToElement(xpath_004).perform();
		builder.click(xpath_004).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Ignore
	public void JumpPoints_005_Ferrari() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_005 = driver.findElement(By.xpath("//a[@title=' Ferrari']"));
		builder.moveToElement(xpath_005).perform();
		builder.click(xpath_005).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_006_Jaguar() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_006 = driver.findElement(By.xpath("//a[@title='Jaguar']"));
		builder.moveToElement(xpath_006).perform();
		builder.click(xpath_006).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_007_LandRover() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_007 = driver.findElement(By.xpath("//a[@title='Land Rover']"));
		builder.moveToElement(xpath_007).perform();
		builder.click(xpath_007).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_008_Lamborghini() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_008 = driver.findElement(By.xpath("//a[@title=' Lamborghini']"));
		builder.moveToElement(xpath_008).perform();
		builder.click(xpath_008).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void JumpPoints_009_Lexus() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_009 = driver.findElement(By.xpath("//a[@title=' Lexus']"));
		builder.moveToElement(xpath_009).perform();
		builder.click(xpath_009).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_010_Maserati() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_010 = driver.findElement(By.xpath("//a[@title='Maserati']"));
		builder.moveToElement(xpath_010).perform();
		builder.click(xpath_010).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Ignore
	public void JumpPoints_011_McLaren() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_011 = driver.findElement(By.xpath("//a[@title='Mclaren']"));
		builder.moveToElement(xpath_011).perform();
		builder.click(xpath_011).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_012_MercedesBenz() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_012 = driver.findElement(By.xpath("//a[@title='Mercedes Benz']"));
		builder.moveToElement(xpath_012).perform();
		builder.click(xpath_012).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_013_Mini() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_013 = driver.findElement(By.xpath("//a[@title='MINI']"));
		builder.moveToElement(xpath_013).perform();
		builder.click(xpath_013).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_014_Porsche() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_014 = driver.findElement(By.xpath("//a[@title='Porsche']"));
		builder.moveToElement(xpath_014).perform();
		builder.click(xpath_014).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_015_RollsRoyce() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_015 = driver.findElement(By.xpath("//a[@title='Rolls Royce']"));
		builder.moveToElement(xpath_015).perform();
		builder.click(xpath_015).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_016_Seat() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_016 = driver.findElement(By.xpath("//a[@title='SEAT']"));
		builder.moveToElement(xpath_016).perform();
		builder.click(xpath_016).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_017_ŠKODA() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_017 = driver.findElement(By.xpath("//a[@title='ŠKODA']"));
		builder.moveToElement(xpath_017).perform();
		builder.click(xpath_017).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_018_Smart() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_018 = driver.findElement(By.xpath("//a[@title='Smart']"));
		builder.moveToElement(xpath_018).perform();
		builder.click(xpath_018).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Ignore
	public void JumpPoints_019_Volkswagen() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_019 = driver.findElement(By.xpath("//a[@title='Volkswagen']"));
		builder.moveToElement(xpath_019).perform();
		builder.click(xpath_019).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Ignore
	public void JumpPoints_020_Volvo() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_020 = driver.findElement(By.xpath("//a[@title='Volvo']"));
		builder.moveToElement(xpath_020).perform();
		builder.click(xpath_020).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_021_SytnerSelect() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_021 = driver.findElement(By.xpath("//a[@title='Sytner Select']"));
		builder.moveToElement(xpath_021).perform();
		builder.click(xpath_021).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Ignore
	public void JumpPoints_022_GraypaulClassicCars() {
		// 1. Open Sytner site
		driver.get("http://www.sytner.co.uk/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// hover and click"
		Actions builder = new Actions(driver);
		WebElement xpath_022 = driver.findElement(By.xpath("//span[contains(text(),'Graypaul Classic Cars')]"));
		builder.moveToElement(xpath_022).perform();
//		builder.click(xpath_022).perform();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() {
		try {
//			driver.quit();
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
