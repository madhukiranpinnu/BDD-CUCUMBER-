package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {
    WebDriver driver;
    public ElementUtils(WebDriver driver){
       this.driver=driver;
    }
    private WebElement waitForElementToBeClickable(WebElement element,long durationInSeconds){
        WebElement webElement=null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return webElement;
    }
    private WebElement waitForElementToBePresent(WebElement element,long durationInSeconds){
        WebElement webElement=null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return webElement;
    }
    private Alert waitForalert(long durationInSeconds){
        Alert alert=null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return alert;
    }
    public void clickOnElement(WebElement element,long durationInSeconds){
        waitForElementToBeClickable(element,durationInSeconds).click();
    }
    public void typeTextIntoElement(WebElement element,String keys,long durationinSeconds){
        waitForElementToBeClickable(element,durationinSeconds).sendKeys(keys);
    }
    public void selectOptionInDropdown(WebElement element,long durationInSeconds,String option){
        WebElement webElement=waitForElementToBePresent(element,durationInSeconds);
        Select select=new Select(element);
        select.deselectByVisibleText(option);
    }
    public void acceptAlert(long durationinSeconds){
        waitForalert(durationinSeconds).accept();
    }
    public void dismissAlert(long durationinSeconds){
        waitForalert(durationinSeconds).dismiss();
    }
    public void sendKeysToAlert(String keys,long durationinSeconds){
        waitForalert(durationinSeconds).sendKeys(keys);
    }
    public String getTextOfAlert(String keys,long durationinSeconds){
        return waitForalert(durationinSeconds).getText();
    }
    public void mouseHoverAndClick(WebElement element,long durationinSeconds){
        Actions actions=new Actions(driver);
        WebElement webElement=waitForElementToBePresent(element, durationinSeconds);
        actions.moveToElement(element).click(element).build().perform();
    }
    public void contextClick(WebElement element,long durationinSeconds){
        Actions actions=new Actions(driver);
        WebElement webElement=waitForElementToBePresent(element, durationinSeconds);
        actions.contextClick(element).perform();
    }
    public void doubleClick(WebElement element,long durationinSeconds){
        Actions actions=new Actions(driver);
        WebElement webElement=waitForElementToBePresent(element, durationinSeconds);
        actions.doubleClick(element).perform();
    }
    public void javaScriptClick(WebElement element,long durationinSeconds){
        WebElement webElement=waitForElementToBePresent(element, durationinSeconds);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",webElement);
    }
    public void javaScriptSendKeys(WebElement element,String keys,long durationinSeconds){
        WebElement webElement=waitForElementToBePresent(element, durationinSeconds);
        ((JavascriptExecutor)driver).executeScript("arguments[0].value='"+keys+"'",webElement);
    }
    public String elementText(WebElement element,long durationinSeconds){
        WebElement webElement=waitForElementToBePresent(element, durationinSeconds);
        return webElement.getText();
    }
}
