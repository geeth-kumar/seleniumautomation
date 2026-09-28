
package seleniumautomation;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;

public class ExceptionTest extends BaseTest {

    @Test
    public void noSuchElementExceptionTest() {

        driver.get("https://the-internet.herokuapp.com/login");

        try {

            driver.findElement(
                    By.id("doesNotExist")
            ).click();

        } catch (NoSuchElementException e) {

            System.out.println(
                    "NoSuchElementException handled successfully!"
            );
        }
    }
    
    @Test
    public void timeoutExceptionTest() {

        driver.get("https://the-internet.herokuapp.com/login");

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("doesNotExist")
                    )
            );

        } catch (TimeoutException e) {

            System.out.println(
                    "TimeoutException handled successfully!"
            );
        }
    }
    
    @Test
    public void staleElementExceptionTest() {

        driver.get("https://the-internet.herokuapp.com/login");

        try {

            // Find the username field
            WebElement usernameField =
                    driver.findElement(By.id("username"));

            // Refresh the page
            driver.navigate().refresh();

            // Try to use the old element reference
            usernameField.sendKeys("tomsmith");

        } catch (StaleElementReferenceException e) {

            System.out.println(
                    "StaleElementReferenceException handled successfully!"
            );
        }
    }
    

    

}

