package stepsDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddCustomerPage;
import pages.ListCustomersPage;
import pages.LoginPage;
import pages.ManagerPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import stepsDefinitions.TestAssertions;

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
            List<String> userInfo = new ArrayList<>();
            loginPage.clickOnTheLoginBtn();
            loginPage.navigateToManagerPage();
            managerPage.clickOnAddCustomerBtn();
            managerPage.navigateToAddCustomerPage();
            userInfo.addAll(Arrays.asList("NewUser","lastUser","123123"));
            addCustomerPage.setFirstName(userInfo.get(0));
            addCustomerPage.setLastName(userInfo.get(1));
            addCustomerPage.setPostCode(userInfo.get(2));
            addCustomerPage.clickOnSubmit();
            addCustomerPage.acceptPopUp();

            addCustomerPage.clickOnCustomersBtn();
            listCustomersPage.searchCustomer("NewUser");
            listCustomersPage.getAddedCustomer();
           // Assert.assertEquals(userInfo,listCustomersPage.getAddedCustomer());
           TestAssertions.assertAddedCustomerInfo(userInfo,listCustomersPage.getAddedCustomer());
            listCustomersPage.deleteUser();
            //Assert.assertNotEquals(userInfo,listCustomersPage.getAddedCustomer());
            TestAssertions.assertDeletedCustomerInfo(userInfo,listCustomersPage.getAddedCustomer());
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

