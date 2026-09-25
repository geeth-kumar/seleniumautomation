package seleniumautomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class ExceptionTest {

    @Test
    public void noSuchElementTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        try {

            driver.findElement(By.id("wrongusername")).sendKeys("tomsmith");

        } catch (NoSuchElementException e) {

            System.out.println("Element was not found!");

        }

        driver.quit();
    }
}