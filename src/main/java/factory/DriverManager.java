package factory;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private DriverManager(){

    }
    private static final ThreadLocal<WebDriver> ThreadLocal=new ThreadLocal<>();
    public static WebDriver getDriver(){
        return ThreadLocal.get();
    }
    public static void setDriver(WebDriver driver){
        ThreadLocal.set(driver);
    }

}
