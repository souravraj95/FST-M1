package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;

	@BeforeTest
	public void driverSetup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	@Test
	public void headerUrl() {
		String headerURL = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).getAttribute("src");
		System.out.println("Header Image URL : " + headerURL);
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
