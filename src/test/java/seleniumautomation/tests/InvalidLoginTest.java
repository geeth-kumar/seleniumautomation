
package seleniumautomation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import seleniumautomation.pages.LoginPage;
import seleniumautomation.utils.ConfigReader;

public class InvalidLoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void openLoginPage() {

        String url = ConfigReader.getProperty("url");

        driver.get(url);

        loginPage = new LoginPage(driver);
    }

    @Test
    public void invalidLoginTest() {

        String username = "wrong_user";
        String password = "wrong_password";

        loginPage.login(username, password);

        String actualMessage = loginPage.getMessage();

        Assert.assertTrue(
            actualMessage.contains("Your username is invalid!")
        );
    }
}

