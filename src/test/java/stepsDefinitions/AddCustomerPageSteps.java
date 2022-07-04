package stepsDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
import java.util.Arrays;
import java.util.List;

import static pages.BaseInfo.LOGIN;
import static pages.BaseInfo.MAIN_URL;

public class AddCustomerPageSteps{
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ManagerPage managerPage;
    protected AddCustomerPage addCustomerPage;
    protected ListCustomersPage listCustomersPage;
    //protected List<String> userInfo;
    List<List<String>>  userInfo;
    List<String> setUserInfo;
    String fName = "";
    String lName = "";
    String pCode = "";

    @Before
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        managerPage = new ManagerPage(driver);
        addCustomerPage = new AddCustomerPage(driver);
        listCustomersPage = new ListCustomersPage(driver);
    }
  @Given("I am on the Login Page")
   public void i_am_on_the_login_page() {
      driver.get(MAIN_URL + LOGIN);
      String actualTitle = loginPage.getActualTitle();
      String expectedTitle = loginPage.getExpectedTitle();
      TestAssertions.assertPageTitle(actualTitle,expectedTitle);
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
    public void i_fill_the_form_with_values_and_submit_it(DataTable table) {
        userInfo = table.asLists(String.class);
        fName = addCustomerPage.setFirstName(userInfo.get(0).get(1));
        lName = addCustomerPage.setLastName(userInfo.get(1).get(1));
        pCode = addCustomerPage.setPostCode(userInfo.get(2).get(1));
        setUserInfo = Arrays.asList(fName,lName,pCode);
        addCustomerPage.clickOnSubmit();
    }
    @When("I accept the popup")
    public void i_accept_the_popup() {
        addCustomerPage.acceptPopUp();
        addCustomerPage.clickOnCustomersBtn();
    }
    @Then("I should be able to add a new customer successfully")
    public void i_should_be_able_to_add_a_new_customer_successfully() {
        listCustomersPage.searchCustomer(fName);
        listCustomersPage.getAddedCustomer();
        TestAssertions.assertAddedCustomerInfo(setUserInfo,listCustomersPage.getAddedCustomer());
    }
    @When("I click on the Delete button")
    public void i_click_on_the_delete_button() {
        listCustomersPage.deleteUser();
    }

    @Then("I should see the customer is deleted")
    public void i_should_see_the_customer_is_deleted() {
        TestAssertions.assertDeletedCustomerInfo(setUserInfo,listCustomersPage.getAddedCustomer());
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
}
