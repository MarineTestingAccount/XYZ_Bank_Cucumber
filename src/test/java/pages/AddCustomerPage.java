package pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    @DataTableType
    public List<String> userInfoSetter(DataTable row) {
        System.out.println("row = " +row.asList());
        return row.asList();
    }

    public String setFirstName(String firstName) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fName));
        WebElement setFName = driver.findElement(fName);
        setFName.sendKeys(firstName);
        return firstName;
    }
    public String setLastName(String lastName) {
        WebElement setLName = driver.findElement(lName);
        setLName.sendKeys(lastName);
        return lastName;
    }
    public String setPostCode(String postCd) {
        WebElement setPostCode = driver.findElement(postCode);
        setPostCode.sendKeys(postCd);
        return postCd;
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

