package activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void driverSetup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}

	@Test
	public void addQualification() throws InterruptedException {
		wait = new WebDriverWait(driver,30);
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));

		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		loginButton.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_pim_viewMyDetails']")));
		driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Qualifications')])[2]")));
		driver.findElement(By.xpath("(//a[contains(text(),'Qualifications')])[2]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='addWorkExperience']")));
		driver.findElement(By.xpath("//input[@id='addWorkExperience']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='experience_employer']")));
		driver.findElement(By.xpath("//input[@id='experience_employer']")).sendKeys("Wells Fargo India PVT. LTD.");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='experience_jobtitle']")));
		driver.findElement(By.xpath("//input[@id='experience_jobtitle']")).sendKeys("Senior Development Engineer In Test (SDET)");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='experience_from_date']")));
		driver.findElement(By.xpath("//input[@id='experience_from_date']")).clear();
		driver.findElement(By.xpath("//input[@id='experience_from_date']")).sendKeys("2010-08-20");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='experience_to_date']")));
		driver.findElement(By.xpath("//input[@id='experience_to_date']")).clear();
		driver.findElement(By.xpath("//input[@id='experience_to_date']")).sendKeys("2021-08-20");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnWorkExpSave']")));
		driver.findElement(By.xpath("//input[@id='btnWorkExpSave']")).click();
		
		
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
