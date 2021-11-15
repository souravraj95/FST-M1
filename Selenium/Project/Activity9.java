package activities;

import java.util.List;
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

public class Activity9 {
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
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Emergency Contacts')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Emergency Contacts')]")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr"));
		for(int i=1; i<=rows.size(); i++) {
		    WebElement row = driver.findElement(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr["+i+"]"));
		    System.out.println("Row " + i + ": " + row.getText());
		}
		
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
