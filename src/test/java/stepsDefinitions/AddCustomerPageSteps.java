package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddCustomerPage;
import pages.ListCustomersPage;
import pages.LoginPage;
import pages.ManagerPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pages.BaseInfo.LOGIN;
import static pages.BaseInfo.MAIN_URL;


public class AddCustomerPageSteps extends Hooks{
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ManagerPage managerPage;
    protected AddCustomerPage addCustomerPage;
    protected ListCustomersPage listCustomersPage;
    protected List<String> userInfo;
  @Given("I am on the Login Page")
   public void i_am_on_the_login_page() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get(MAIN_URL + LOGIN);
      driver.manage().window().maximize();
      loginPage = new LoginPage(driver);
      managerPage = new ManagerPage(driver);
      addCustomerPage = new AddCustomerPage(driver);
      listCustomersPage = new ListCustomersPage(driver);
      userInfo = new ArrayList<>();

      String actualTitle = loginPage.getActualTitle();
      String expectedTitle = loginPage.getExpectedTitle();
      TestAssertions.assertPageUrl(actualTitle,expectedTitle);

    }
    @When("I navigate to the Manager Page")
    public void i_navigate_to_the_manager_page() {
        loginPage.clickOnTheLoginBtn();
        loginPage.navigateToManagerPage();

    }
    @When("I click on the Add Customer button")
    public void i_click_on_the_add_customer_button() {
        managerPage.clickOnAddCustomerBtn();
        managerPage.navigateToAddCustomerPage();
    }
    @When("I fill the form with values and submit it")
    public void i_fill_the_form_with_values_and_submit_it() {
        userInfo.addAll(Arrays.asList("NewUser","lastUser","123123"));
        addCustomerPage.setFirstName(userInfo.get(0));
        addCustomerPage.setLastName(userInfo.get(1));
        addCustomerPage.setPostCode(userInfo.get(2));
        addCustomerPage.clickOnSubmit();

    }
    @When("I accept the popup")
    public void i_accept_the_popup() {
        addCustomerPage.acceptPopUp();
        addCustomerPage.clickOnCustomersBtn();

    }
    @Then("I should be able to add a new customer successfully")
    public void i_should_be_able_to_add_a_new_customer_successfully() {
        listCustomersPage.searchCustomer("NewUser");
        listCustomersPage.getAddedCustomer();
        //Assert.assertEquals(userInfo,listCustomersPage.getAddedCustomer());
        TestAssertions.assertAddedCustomerInfo(userInfo,listCustomersPage.getAddedCustomer());

    }
    @When("I click on the Delete button")
    public void i_click_on_the_delete_button() {
        listCustomersPage.deleteUser();
    }
    @Then("I should see the customer is deleted")
    public void i_should_see_the_customer_is_deleted() {
        //Assert.assertNotEquals(userInfo,listCustomersPage.getAddedCustomer());
        TestAssertions.assertDeletedCustomerInfo(userInfo,listCustomersPage.getAddedCustomer());
        driver.quit();
    }

}
