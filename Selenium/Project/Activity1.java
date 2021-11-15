package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Activity1 {
	WebDriver driver;

	@BeforeTest
	public void driverSetup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	@Test
	public void verifyTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
