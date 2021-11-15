package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertTesting {
	
	WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void navigateToPage() {
       
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);
        
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void simpleAlert() {
        driver.findElement(By.cssSelector("#simple")).click();
    }
    
    @When("^User clicks the Confirm Alert button$")
    public void confirmAlert() {
        driver.findElement(By.cssSelector("#confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void promptAlert() {
        driver.findElement(By.cssSelector("#prompt")).click();
    }
    
    @Then("^Alert opens$")
    public void alertOpen() {
        alert = driver.switchTo().alert();
    }
    
    @And("^Read the text from it and print it$")
    public void readAlert() {
        System.out.println("Alert message is : " + alert.getText());
    }
    
    @And("^Write a custom message in it$")
    public void writePrompt() {
        alert.sendKeys("Custom Message");
    }
    
    @And("^Close the alert$")
    public void closeAlert() {
        alert.accept();
    }
    
    @And("^Close the alert with Cancel$")
    public void alertCancel() {
        alert.dismiss();
    }
    
   /*
    @And("^Read the result text$")
    public void showResult() {
        System.out.println("Result is : "+driver.findElement(By.id("result")).getText());
    }
    
    */
    
    @And("^Close Browser$")
    public void closeBrowser() {
        driver.close();
    }
    
}