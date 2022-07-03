package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class AddCustomerPage {
    WebDriver driver;
    WebDriverWait wait;

    //Initialize Locators
    private final By
            fName = By.xpath("//input[@ng-model = 'fName']"),
            lName = By.xpath("//input[@ng-model = 'lName']"),
            postCode = By.xpath("//input[@ng-model = 'postCd']"),
            addCustomerBtn = By.xpath("//button[@type= 'submit']"),
            customersListBtn = By.xpath("//button[@ng-click = 'showCust()']");
    public AddCustomerPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void setFirstName(String firstName) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fName));
        WebElement setFName = driver.findElement(fName);
        setFName.sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        WebElement setLName = driver.findElement(lName);
        setLName.sendKeys(lastName);
    }
    public void setPostCode(String postCd) {
        WebElement setPostCode = driver.findElement(postCode);
        setPostCode.sendKeys(postCd);
    }
    public void clickOnSubmit() {
        WebElement submitAddCustomer = driver.findElement(addCustomerBtn);
        submitAddCustomer.click();
    }
    public  void acceptPopUp(){
        driver.switchTo().alert().accept();
    }
    public void clickOnCustomersBtn() {
        WebElement customersBtn = driver.findElement(customersListBtn);
        customersBtn.click();
    }
}

