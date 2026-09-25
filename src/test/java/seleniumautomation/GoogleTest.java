package seleniumautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void openGoogle() {
        driver.get("https://www.google.com");

        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test(priority = 2, dependsOnMethods = "openGoogle")
    public void checkUrl() {
    	driver.get("https://www.google.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}