package seleniumautomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;

public class MultipleWindowTest extends BaseTest {

    @Test
    public void multipleWindowFunctionality() {

        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindow = driver.getWindowHandle();

        System.out.println("Parent window: " + parentWindow);

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindows = driver.getWindowHandles();

        System.out.println("Total windows: " + allWindows.size());

        Assert.assertEquals(allWindows.size(), 2);

        for (String window : allWindows) {

            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        System.out.println("New window title: " + driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "New Window");
    }
}