package seleniumautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;
public class CheckboxTest extends BaseTest {

    @Test
    public void checkboxFunctionality() {

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(
                By.xpath("(//input[@type='checkbox'])[1]")
        );

        // Select checkbox if it is not selected
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        // Verify checkbox is selected
        Assert.assertTrue(checkbox1.isSelected());

        // Unselect checkbox
        checkbox1.click();

        // Verify checkbox is unselected
        Assert.assertFalse(checkbox1.isSelected());
    }
}