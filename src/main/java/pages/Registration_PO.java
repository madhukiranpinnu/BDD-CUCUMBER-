package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class Registration_PO {
    WebDriver driver;
    ElementUtils elementUtils;
    public Registration_PO(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils=new ElementUtils(driver);
    }
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement Myaccount;
    @FindBy(xpath = "//li/a[contains(text(),'Register')]")
    private WebElement Register;
    @FindBy(xpath = "//label/input[@value='1' and @name='newsletter']")
    private WebElement yesCheckbox;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;
    @FindBy(id="input-firstname")
    private WebElement firstname;
    @FindBy(id = "input-lastname")
    private WebElement lastname;
    @FindBy(id="input-email")
    private WebElement email;
    @FindBy(id="input-telephone")
    private WebElement telephone;
    @FindBy(id="input-password")
    private WebElement password;
    @FindBy(id="input-confirm")
    private WebElement confirmPassword;
    @FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
    private  WebElement invalidtext;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement termsAndConditions;
    @FindBy(xpath = "(//div/h1)[2]")
    private WebElement sucessMessage;
    public String getSuccessMessage(){
        return elementUtils.elementText(sucessMessage,10);
    }
    public  void ClicktermsAndcondition(){
        elementUtils.clickOnElement(termsAndConditions,10);
    }
    public String getInvakidText(){
        return invalidtext.getText();
    }
    public void SendPassword(String password){
       elementUtils.typeTextIntoElement(this.password,password,10);
    }
    public void sendConfirmPassword(String confirm){
        elementUtils.typeTextIntoElement(confirmPassword,confirm,10);
    }
    public void sendTelphoneNo(String Tel){
        elementUtils.typeTextIntoElement(telephone,Tel,10);
    }
    public void sendemail(String emailAddress){
        elementUtils.typeTextIntoElement(email,emailAddress,10);
    }
    public void sendlastname(String lastname){
        elementUtils.typeTextIntoElement(this.lastname,lastname,10);
    }
    public void sendfirstname(String firstname){
        elementUtils.typeTextIntoElement(this.firstname,firstname,10);
    }
    public void clicksubmit(){
        elementUtils.clickOnElement(submit,10);
    }
    public void selectyesCheckbox(){
        elementUtils.clickOnElement(yesCheckbox,10);
    }
    public void clickRegister(){
        elementUtils.clickOnElement(Register,10);
    }
    public void clickMyaccount(){
        elementUtils.clickOnElement(Myaccount,10);
    }
}
