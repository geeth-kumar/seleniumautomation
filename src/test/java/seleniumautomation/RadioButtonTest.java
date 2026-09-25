package seleniumautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;

public class RadioButtonTest extends BaseTest {

    @Test
    public void radioButtonFunctionality() {

        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadio = driver.findElement(
                By.id("yesRadio")
        );

        WebElement yesLabel = driver.findElement(
                By.xpath("//label[@for='yesRadio']")
        );

        yesLabel.click();

        Assert.assertTrue(yesRadio.isSelected());
    }
}