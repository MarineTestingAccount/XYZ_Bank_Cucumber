package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class ListCustomersPage {
    WebDriver driver;
    //WebDriverWait wait;
    //WebElement usersList;
    List<WebElement> usersInfo;

    //Initialize Locators
    private final By

            searchCustomer = By.xpath("//input[@ng-model = 'searchCustomer']"),
    //addedUsersList = By.xpath("//tbody//tr"),
    addedUsersList = By.xpath("//tbody"),
            addedUsersListRaw = By.xpath(".//tr[@class = 'ng-scope']"),
            addedUsersListColumn = By.xpath(".//td"),
            deleteCustomer = By.xpath("//button[@ng-click = 'deleteCust(cust)']");

    public ListCustomersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchCustomer(String user) {
        WebElement search = driver.findElement(searchCustomer);
        search.sendKeys(user);
    }

    public List<String> getAddedCustomer() throws InterruptedException {
        WebElement usersList = driver.findElement(addedUsersList);
        List<WebElement> raw = usersList.findElements(addedUsersListRaw);
        Thread.sleep(3000);
        String getFirstName = "";
        String getLastName = "";
        String getPostCode = "";
        //System.out.println("size=" + raw.size());
        if (raw.size() == 1) {
            usersInfo = usersList.findElements(addedUsersListColumn);
            System.out.println("size=" + usersInfo.size());
            for (int i = 0; i < usersInfo.size(); i++) {
                switch (i) {
                    case 0 -> getFirstName = usersInfo.get(i).getText();
                    case 1 -> getLastName = usersInfo.get(i).getText();
                    case 2 -> getPostCode = usersInfo.get(i).getText();
//                    case 4 -> {
//                        WebElement clickOnDeleteBtn = usersInfo.get(i).findElement(deleteCustomer);
//                        clickOnDeleteBtn.click();
//                        System.out.println("deleted");
//                        Thread.sleep(3000);
//                        break;
//                    }

                }

            }


        }
        System.out.println(Arrays.asList(getFirstName, getLastName, getPostCode));
        return Arrays.asList(getFirstName, getLastName, getPostCode);
    }


    public void deleteUser() throws InterruptedException {

        WebElement clickOnDeleteBtn = driver.findElement(deleteCustomer);
        clickOnDeleteBtn.click();
        System.out.println("deleted");
        Thread.sleep(3000);
    }
}
