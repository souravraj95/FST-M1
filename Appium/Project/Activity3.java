package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Activity3 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "OnePlusNord");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 50);
	}

	@Test
	public void googleTasks() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Clicks on + button
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("new_note_button"))).click();

		// Enters Note
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("edit_note_text")))
				.sendKeys("This is my plan");
		// Enters Title
		driver.findElementById("editable_title").sendKeys("My Trip Plan");
		// Clicks Reminder button
		driver.findElementById("menu_switch_to_list_view").click();
		// Clicks on 'Pick a date & time'
		driver.findElementByXPath("//android.widget.TextView[@text='Pick a date & time']").click();
		// Clicks on currently selected time dropdown
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(
				"//android.widget.LinearLayout[contains(@content-desc,'Time - Currently selected')]/android.widget.Spinner/android.widget.TextView")))
				.click();
		// Clicks on Afternoon
		driver.findElementByXPath("//android.widget.TextView[@text='Afternoon']").click();
		// Clicks Save button
		driver.findElementById("save").click();
		// Clicks Back button
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Open navigation drawer"))).click();

		// Assertions - Verify note is added successfully
		String noteName = driver.findElementById("index_note_title").getText();
		Assert.assertEquals(noteName, "My Trip Plan");
		System.out.println("Note with title :" + noteName + " is added successfully");
		// Verifies note is saved with reminder
		Assert.assertTrue(driver.findElementById("reminder_chip_text").isDisplayed());

		System.out.println("Note is set with reminder: " + driver.findElementById("reminder_chip_text").getText());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}