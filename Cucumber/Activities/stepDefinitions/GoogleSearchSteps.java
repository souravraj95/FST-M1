package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on Google Home Page$")
	public void givenHomePage() {
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);
		driver.get("https://www.google.com");
	}

	@When("^User types in Cheese and hits ENTER$")
	public void whenUserTypes() {
		
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
	}

	@Then("^Show how many search results were shown$")
	public void thenSearchResult() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
		String number = driver.findElement(By.id("result-stats")).getText();
		System.out.println("Result stats are shown "+number+"numbers");
		
	}
	
	@And("^Close the browser$")
	public void closeBrowser() {
		driver.close();
		
	}

}
