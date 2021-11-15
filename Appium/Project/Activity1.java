package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

public class Activity1 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "OnePlusNord");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);
		// Instantiate Appium Driver
		driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 100);
	}

	@Test
	public void googleTasks() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<String> tasks = new ArrayList<String>();
		// Add the tasks to be added to a list
		String taskOne = "Complete Activity with Google Tasks";
		String taskTwo = "Complete Activity with Google Keep";
		String taskThree = "Complete the second Activity Google Keep";
		tasks.add(taskOne);
		tasks.add(taskTwo);
		tasks.add(taskThree);
		System.out.println("Added all task names to a list");
		// Iterate through the list and add all the 3 tasks
		for (String e : tasks) {
			// Clicks on + button
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")))
					.click();
			// Enters task name
			wait.until(ExpectedConditions
					.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")))
					.sendKeys(e);
			// Clicks Save
			driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
			System.out.println("New task " + e + " is added");
		}
		// Assertions - Verify all 3 tasks are added successfully
		List<MobileElement> addedTasks = driver.findElementsById("com.google.android.apps.tasks:id/task_name");
		for (MobileElement ele : addedTasks) {
			Assert.assertTrue(ele.isDisplayed());
			System.out.println("Task :" + ele.getText() + "is verified successfully");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}