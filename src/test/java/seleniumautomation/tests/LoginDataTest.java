package seleniumautomation.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumautomation.pages.LoginPage;
import seleniumautomation.utils.ConfigReader;

public class LoginDataTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void openLoginPage() {
    	

        driver.get(ConfigReader.getProperty("url"));

        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {

            {"tomsmith", "SuperSecretPassword!", true},

            {"wronguser", "wrongpassword", false},

            {"tomsmith", "wrongpassword", false}

        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(
            String username,
            String password,
            boolean expectedSuccess) {

        loginPage.login(username, password);

        String actualMessage = loginPage.getMessage();

        boolean actualSuccess =
                actualMessage.contains(
                        "You logged into a secure area!"
                );

        Assert.assertEquals(actualSuccess, expectedSuccess);
    }
}