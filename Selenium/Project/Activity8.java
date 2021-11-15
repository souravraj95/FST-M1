package activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity8 {
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
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Apply Leave')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_txtLeaveType")));
		Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
		leaveType.selectByValue("1");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='applyleave_txtFromDate']")));
		driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']")).clear();
		driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']")).sendKeys("2021-10-20");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='applyleave_txtToDate']")));
		driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).clear();
		driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).sendKeys("2021-10-20");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='applyBtn']")));
		driver.findElement(By.xpath("//input[@id='applyBtn']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_leave_viewMyLeaveList']")));
		driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']")).click();
		
		
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
