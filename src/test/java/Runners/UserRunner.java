package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/User/User.feature",
        glue = "StepDefinitions",
        tags = "@USER"
)
public class UserRunner {

}