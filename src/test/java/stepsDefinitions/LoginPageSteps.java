package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public class LoginPageSteps {
    public WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    @Given("I am in HomePage")
    public void i_am_in_home_page() {

    }
    @When("I click on the Bank Manager button")
    public void i_click_on_the_bank_manager_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should navigate into Manager page")
    public void i_should_navigate_into_manager_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
