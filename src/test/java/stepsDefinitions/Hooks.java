package stepsDefinitions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Hooks {
//        protected WebDriver driver;
//        protected LoginPage loginPage;
//        protected ManagerPage managerPage;
//        protected AddCustomerPage addCustomerPage;
//        protected ListCustomersPage listCustomersPage;
//        protected List<String> userInfo;



        @BeforeEach
        public void initDriver() {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            driver.get(MAIN_URL + LOGIN);
//            driver.manage().window().maximize();

//            loginPage = new LoginPage(driver);
//            managerPage = new ManagerPage(driver);
//            addCustomerPage = new AddCustomerPage(driver);
//            listCustomersPage = new ListCustomersPage(driver);
//            userInfo = new ArrayList<>();


        }

        @Test
        public void testDemo(){
//            String actualTitle = loginPage.getActualTitle();
//            String expectedTitle = loginPage.getExpectedTitle();
//            TestAssertions.assertLoginPageTitle(actualTitle,expectedTitle);

            //List<String> userInfo = new ArrayList<>();
//            loginPage.clickOnTheLoginBtn();
//            loginPage.navigateToManagerPage();
//            managerPage.clickOnAddCustomerBtn();
//            managerPage.navigateToAddCustomerPage();
//            userInfo.addAll(Arrays.asList("NewUser","lastUser","123123"));
//            addCustomerPage.setFirstName(userInfo.get(0));
//            addCustomerPage.setLastName(userInfo.get(1));
//            addCustomerPage.setPostCode(userInfo.get(2));
//            addCustomerPage.clickOnSubmit();
//            addCustomerPage.acceptPopUp();

//            addCustomerPage.clickOnCustomersBtn();
//            listCustomersPage.searchCustomer("NewUser");
//            listCustomersPage.getAddedCustomer();
//            Assert.assertEquals(userInfo,listCustomersPage.getAddedCustomer());
//           TestAssertions.assertAddedCustomerInfo(userInfo,listCustomersPage.getAddedCustomer());
//            listCustomersPage.deleteUser();
//            Assert.assertNotEquals(userInfo,listCustomersPage.getAddedCustomer());
//            TestAssertions.assertDeletedCustomerInfo(userInfo,listCustomersPage.getAddedCustomer());
        }


//        @After
//        public void teardown() {
//            System.out.println("Close browser");
//            driver.quit();
//        }
    }

