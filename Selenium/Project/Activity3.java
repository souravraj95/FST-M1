package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;

	@BeforeTest
	public void driverSetup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	@Test
	public void login() {
		WebElement username =driver.findElement(By.id("txtUsername"));
		WebElement password =driver.findElement(By.id("txtPassword"));
		WebElement loginButton =driver.findElement(By.id("btnLogin"));
		
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		loginButton.click();

		String welcomeText = driver.findElement(By.id("welcome")).getText();
		Assert.assertEquals(welcomeText, "Welcome Rancho");
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
