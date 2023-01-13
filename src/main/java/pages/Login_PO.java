package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class Login_PO {
    WebDriver driver;
    ElementUtils elementUtils;
    public Login_PO(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils=new ElementUtils(driver);
    }
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement MyAccount;
    @FindBy(xpath = "//li/a[contains(text(),'Login')]")
    private WebElement login;
    @FindBy(id="input-email")
    private WebElement email;
    @FindBy(id="input-password")
    private WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginbtn;
    @FindBy(xpath = "(//div[@id=\"content\"]/h2)[1]")
    private  WebElement loginSuccessTxt;
    @FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
    private WebElement invalidMessage;
    public void ClickMyAccount(){
        elementUtils.clickOnElement(MyAccount,10);
    }
    public void clickOnLogin(){
        elementUtils.clickOnElement(login,10);
    }
    public void sendKeysEmail(String emailKeys){
       elementUtils.typeTextIntoElement(email,emailKeys,10);
    }
    public void sendPassword(String pass){
        elementUtils.typeTextIntoElement(password,pass,10);
    }
    public void clickLoginButton(){
        elementUtils.clickOnElement(loginbtn,10);
    }
    public WebElement getLoginSuccessTxt(){
        return loginSuccessTxt;
    }
    public WebElement getInvalidMessage(){
        return invalidMessage;
    }
}
