package stepsDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddCustomerPage;
import pages.ListCustomersPage;
import pages.LoginPage;
import pages.ManagerPage;

import java.time.Duration;

import static pages.BaseInfo.*;

public class Hooks {
        protected WebDriver driver;
        LoginPage loginPage;
        ManagerPage managerPage;
        AddCustomerPage addCustomerPage;
        ListCustomersPage listCustomersPage;


        @BeforeEach
        public void initDriver() {
            System.out.println("Open browser");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(MAIN_URL + LOGIN);
            driver.manage().window().maximize();

            loginPage = new LoginPage(driver);
            managerPage = new ManagerPage(driver);
            addCustomerPage = new AddCustomerPage(driver);
            listCustomersPage = new ListCustomersPage(driver);
        }

        @Test
        public void testDemo() throws InterruptedException {
            System.out.println(driver.getCurrentUrl());
            loginPage.clickOnTheLoginBtn();
            loginPage.navigateToManagerPage();
            managerPage.clickOnAddCustomerBtn();
            managerPage.navigateToAddCustomerPage();
            addCustomerPage.setFirstName("NewUser");
            addCustomerPage.setLastName("lastUser");
            addCustomerPage.setPostCode("123123");
            addCustomerPage.clickOnSubmit();
            addCustomerPage.acceptPopUp();
            addCustomerPage.clickOnCustomersBtn();
            listCustomersPage.searchCustomer("NewUser");
            listCustomersPage.getAddedCustomer();
            listCustomersPage.deleteUser();




        }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

        @AfterEach
        public void teardown() {
            System.out.println("Close browser");
            driver.quit();
        }
    }

