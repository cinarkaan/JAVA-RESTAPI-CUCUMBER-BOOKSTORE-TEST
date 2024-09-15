package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/User/AddUser.feature",
        glue = "StepDefinitions",
        tags = "@USERs"
)
public class UserRunner {

}