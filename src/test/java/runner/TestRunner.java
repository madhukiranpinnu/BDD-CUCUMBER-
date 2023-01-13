package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = {"pretty","html:target/CucumberReports/index.html"},
        features = {"D:/Projects/CucumberFramework/src/test/resources/features"},
        glue = {"stepDefinations","hooks"},
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
