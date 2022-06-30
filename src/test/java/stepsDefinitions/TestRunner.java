package stepsDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
          //format = {"pretty", "html:target/cucumber"}
          features = "features"
        ,glue={"stepDefinition"}
)
public class TestRunner {

}

