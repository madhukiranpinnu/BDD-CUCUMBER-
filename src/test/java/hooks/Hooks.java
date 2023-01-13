package hooks;

import factory.DriverExecutables;
import factory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setup(){
        DriverExecutables.initDriver();
    }
    @After
    public void teardown(Scenario scenario){
        String scenarioName=scenario.getName().replace(" ","_");
        if(scenario.isFailed()){
            byte[] screenshotAs=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotAs,"image/png",scenarioName);
        }
        DriverExecutables.quitDriver();
    }
}
