package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.BaseInfo.*;

public class ManagerPage {
    WebDriver driver;
    WebDriverWait wait;

    //Initialize Locators
    private final By
            addCustomerBtn = By.xpath("//button[@ng-click='addCust()'] ");

    public ManagerPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickOnAddCustomerBtn() {
        WebElement clickOnButton = driver.findElement(addCustomerBtn);
        clickOnButton.click();
    }
    public String navigateToAddCustomerPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.urlContains(ADD_CUSTOMER));
        System.out.println("add"+driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
}
