package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class Search_PO {
    WebDriver driver;
    ElementUtils elementUtils;
    public Search_PO(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils=new ElementUtils(driver);
    }
    @FindBy(xpath = "//div/input[@name='search']")
    private WebElement searchbox;
    @FindBy(xpath = "//h4/a")
    private WebElement validProducttext;
    @FindBy(xpath = "//span/button[@class='btn btn-default btn-lg']")
    private WebElement button;
    @FindBy(xpath = "//h2/following-sibling::p")
    private WebElement errorMessage;
    public void SendKeysSearchBox(String product){
        searchbox.sendKeys(product);
    }
    public void ClickButton(){
        elementUtils.clickOnElement(button,10);
    }
    public String errorMessageText(){
        return elementUtils.elementText(errorMessage,10);
    }
    public String ValidProductText(){
        return elementUtils.elementText(validProducttext,10);
    }
}
