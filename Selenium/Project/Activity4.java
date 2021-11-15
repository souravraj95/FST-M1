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

public class Activity4 {
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
		String fstName = "Sourav";
		String lstName = "Sharma";
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));

		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		loginButton.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_pim_viewPimModule']")));
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd")));
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys(fstName);
		driver.findElement(By.id("lastName")).sendKeys(lstName);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
		driver.findElement(By.id("btnSave")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewEmployeeList")));
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("empsearch_employee_name_empName")));
		driver.findElement(By.id("empsearch_employee_name_empName")).clear();
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Sourav Sharma");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn")));
		driver.findElement(By.id("searchBtn")).click();
		List<WebElement> searchResult = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr"));
		for (int a = 0; a < searchResult.size(); a++) {
			String firstname = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr['"+a+"']/td[3]"))
					.getText();
			String lastname = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr['"+a+"']/td[4]"))
					.getText();
			if ((firstname + " " + lastname).equalsIgnoreCase(fstName + " " + lstName)) {
				System.out.println("Employee: " + fstName + " " + lstName + " " + "added succesfully");
			} else {
				System.out.println("Employee: " + fstName + " " + lstName + " " + "not added");
			}
		}
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
