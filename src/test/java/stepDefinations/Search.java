package stepDefinations;

import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Search_PO;


public class Search {
    Search_PO searchPo=new Search_PO(DriverManager.getDriver());

    @When("^I enter valid product (.+) in the search field$")
    public void i_enter_valid_product_in_the_search_field(String string) {
        searchPo.SendKeysSearchBox(string);
    }

    @Then("Valid product should get displayed in the search results")
    public void valid_product_should_get_displayed_in_the_search_results() {
        System.out.println(searchPo.ValidProductText());
    }

    @Given("I click on search button")
    public void i_click_on_search_button() throws InterruptedException {
       searchPo.ClickButton();
    }
    @Then("error message should get displayed in the search results")
    public void error_message_should_get_displayed_in_the_search_results() {
        System.out.println(searchPo.errorMessageText());
    }

}
