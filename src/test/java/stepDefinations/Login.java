package stepDefinations;

import factory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.Login_PO;

public class Login {
    Login_PO loginPo=new Login_PO(DriverManager.getDriver());
    @Given("^I open the application URL to  login page$")
    public void I_open_the_application_URL_to_login_page() throws InterruptedException {
       loginPo.ClickMyAccount();
       loginPo.clickOnLogin();
    }
    @When("^User enters valid email address (.+)$")
    public void User_enters_valid_email_address(String s){
        loginPo.sendKeysEmail(s);
    }
    @And("^User enters valid password (.+)$")
    public void User_enters_valid_password(String password){
        loginPo.sendPassword(password);
    }
    @And("^User clicks on login button$")
    public void User_clicks_on_login_button(){
        loginPo.clickLoginButton();
    }
    @And("^User should be login Successfully$")
    public void User_should_be_login_Successfully(){
        System.out.println(loginPo.getLoginSuccessTxt().getText());
    }
    @And("^User should seeing invalid message$")
    public void User_should_seeing_invalid_message(){
        System.out.println(loginPo.getInvalidMessage().getText());
    }
}
