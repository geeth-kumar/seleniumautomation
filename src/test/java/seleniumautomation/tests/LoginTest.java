package seleniumautomation.tests;

import seleniumautomation.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumautomation.pages.LoginPage;

import seleniumautomation.utils.ConfigReader;
public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;
    @BeforeMethod
    public void openLoginPage() {
    	

        String url = ConfigReader.getProperty("url");

        driver.get(url);

        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage.login(username, password);

        secureAreaPage = new SecureAreaPage(driver);

        String heading = secureAreaPage.getPageHeading();

        Assert.assertEquals(heading, "Secure Area");

        secureAreaPage.clickLogout();
        Assert.assertTrue(secureAreaPage.isLoginButtonDisplayed());
    }

    @Test
    public void invalidLoginTest() {

        loginPage.login("wronguser", "wrongpassword");

        String actualMessage = loginPage.getMessage();

        Assert.assertTrue(
            actualMessage.contains("Your username is invalid!")
        );
    }
}