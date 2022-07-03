package stepsDefinitions;

import org.junit.Assert;

import java.util.List;


public class TestAssertions {

    //Assert that the title is correct
    public static void assertPageTitle(String expectedTitle, String actualTitle){
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    //Assert that the URL is correct
    public static void assertPageUrl(String expectedUrl, String actualUrl){
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    //Assert that customer is added with correct info
    public static void assertAddedCustomerInfo(List<String> expectedList, List<String> actualList) {
        Assert.assertEquals(expectedList, actualList);
    }
    //Assert that customer is deleted
    public static void assertDeletedCustomerInfo(List<String> expectedList, List<String> actualList) {
        Assert.assertNotEquals(expectedList, actualList);
    }

}
