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

public class Activity5 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void driverSetup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}

	@Test
	public void addEmployee() throws InterruptedException {
		wait = new WebDriverWait(driver,30);
		String fstName = "Nikita";
		String lstName = "Sharma";
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnSave' and @value='Edit']")));
		driver.findElement(By.xpath("//input[@id='btnSave' and @value='Edit']")).click();
		driver.findElement(By.id("personal_txtEmpFirstName")).clear();
		driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys(fstName);
		driver.findElement(By.id("personal_txtEmpLastName")).clear();
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys(lstName);
		driver.findElement(By.id("personal_optGender_2")).click();
		Select nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
		nationality.selectByVisibleText("American");
		driver.findElement(By.id("personal_DOB")).clear();
		driver.findElement(By.id("personal_DOB")).sendKeys("1995-07-01");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnSave']")));
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();

	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
