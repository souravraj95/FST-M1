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

public class Activity2 {
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
		wait = new WebDriverWait(driver, 100);
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
		driver.findElementById("editable_title").click();
		driver.findElementById("editable_title").sendKeys("My Trip Plan");

		// Clicks Back button
		driver.findElementByAccessibilityId("Open navigation drawer").click();

		// Assertions - Verify note is added successfully
		String noteName = driver.findElementById("index_note_title").getText();
		Assert.assertEquals(noteName, "My Trip Plan");
		System.out.println("Note with title :" + noteName + " is added successfully");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}