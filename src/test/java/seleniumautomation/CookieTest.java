package seleniumautomation;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;

public class CookieTest extends BaseTest {

    @Test
    public void cookieFunctionality() {

        driver.get("https://the-internet.herokuapp.com/");

     // Delete the cookie
        driver.manage().deleteCookieNamed("username");

        // Verify cookie is deleted
        Cookie deletedCookie = driver.manage().getCookieNamed("username");

        System.out.println("Cookie after deletion: " + deletedCookie);

        Assert.assertNull(deletedCookie);
    }
}