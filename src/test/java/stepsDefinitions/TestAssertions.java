package stepsDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ListCustomersPage.*;
import  pages.AddCustomerPage.*;

import java.util.List;

public class TestAssertions {
    //Assert that customer is added with correct info
    public static void assertAddedCustomerInfo(List<String> expectedList, List<String> actualList) {
        Assert.assertEquals(expectedList, actualList);
    }
    public static void assertDeletedCustomerInfo(List<String> expectedList, List<String> actualList) {
        Assert.assertNotEquals(expectedList, actualList);
    }

}
