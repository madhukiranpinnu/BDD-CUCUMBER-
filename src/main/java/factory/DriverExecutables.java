package factory;

import org.openqa.selenium.WebDriver;
import utils.CommonUtils;
import utils.ConfigReader;

import java.time.Duration;

public class DriverExecutables {
    private DriverExecutables(){

    }
    public static void initDriver()  {
        String browserName= ConfigReader.initalizeProperties().getProperty("browser");
        if(DriverManager.getDriver()==null){
            WebDriver driver=DriverFactory.getDriver(browserName);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(ConfigReader.initalizeProperties().getProperty("url"));
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.EXPLICIT_TIMEOUT));
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_TIMEOUT));
        }
    }
    public static void quitDriver(){
        if (DriverManager.getDriver()!=null){
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}
