package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefinition"},
    // Below tags will run Activity1 to Activity 5 at once
    tags = "@activity1_1 or @activity1_2 or @activity1_3 or @activity2_4 or @activity2_5",
    //tags = "@SmokeTest", // Run separately for Activity 6
    plugin = {"pretty"},
    //plugin = {"html: test-reports"}, // Run separately for Activity 6
    monochrome = true
)

public class ActivitiesRunner {

}