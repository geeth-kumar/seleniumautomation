package seleniumautomation.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ScreenshotFailureTest extends BaseTest {

    @Test
    public void failedLoginTest() {

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("wrong");
    }
}