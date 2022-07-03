package pages;
/**
        1. Open the page https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        2. Click on the "Bank Manager Login"
        3. Add Customer
        4. Accept the alert  popup
        5. Click on the "Customers"
        6. Search the customer on Customers list
        7. Assert that customer is added with correct info
        8. Delete customer
        9. Assert that customer is deleted
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.BaseInfo.*;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    //Initialize Locators
    private final By
            bankManagerLoginBtn = By.xpath("//button[@ng-click = 'manager()']");
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public String getActualTitle(){
        return driver.getTitle();
    }
    public String getExpectedTitle(){
       return driver.findElement(BaseInfo.PAGE_TITLE).getAttribute("textContent");
    }
    public void clickOnTheLoginBtn() {
        WebElement clickOnButton = driver.findElement(bankManagerLoginBtn);
        clickOnButton.click();
    }
    public String navigateToManagerPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.urlContains(MANAGER));
        return driver.getCurrentUrl();
    }
}

