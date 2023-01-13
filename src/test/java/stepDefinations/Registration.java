package stepDefinations;

import factory.DriverFactory;
import factory.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Registration_PO;

import java.util.Map;

public class Registration {
    Registration_PO registrationPo=new Registration_PO(DriverManager.getDriver());
    @Given("User is on Registration page")
    public void User_is_on_Registration_page() throws InterruptedException {
      registrationPo.clickMyaccount();
      registrationPo.clickRegister();
    }

    @And("User selects {word} radio button in registration page")
    public void User_selects_radio_button_in_registration_page(String s){
      registrationPo.selectyesCheckbox();
    }
    @And("User clicks on continue button in registration page")
    public void User_clicks_on_continue_button_in_registration_page() throws InterruptedException {
       registrationPo.clicksubmit();
    }
    @And("User enters following all mandatory fields in registration page")
    public void User_enters_following_all_mandatory_fields_in_registration_page(DataTable dataTable){
        Map<String,String> map= dataTable.asMap(String.class,String.class);
        registrationPo.sendfirstname(map.get("firstname"));
        registrationPo.sendlastname(map.get("lastname"));
        registrationPo.sendemail(map.get("email"));
        registrationPo.sendTelphoneNo(map.get("phoneno"));
        registrationPo.sendConfirmPassword(map.get("password"));
        registrationPo.sendConfirmPassword(map.get("confirmPass"));
    }
    @Then("User should be seeing invalid message")
    public void user_should_be_seeing_invalid_message() {
        registrationPo.getInvakidText();
    }
    @And("User accepts terms")
    public void user_accepts_terms() throws InterruptedException {
       registrationPo.ClicktermsAndcondition();
    }

    @Then("User account is successfully created")
    public void user_account_is_successfully_created() throws InterruptedException {
       registrationPo.getSuccessMessage();
    }

}
