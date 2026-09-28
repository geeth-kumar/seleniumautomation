
package seleniumautomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;

public class DynamicXPathTest extends BaseTest {

    @Test
    public void dynamicXPathTest() {

        driver.get("https://the-internet.herokuapp.com/login");

        // Dynamic XPath using the input's attribute
        By usernameField =
                By.xpath("//input[contains(@id,'user')]");

        // Verify the element is displayed
        Assert.assertTrue(
                driver.findElement(usernameField).isDisplayed(),
                "Username field is not displayed"
        );

        // Enter username
        driver.findElement(usernameField)
              .sendKeys("tomsmith");

        System.out.println("Dynamic XPath worked successfully!");
    }
}

