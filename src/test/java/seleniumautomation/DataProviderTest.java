package seleniumautomation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumautomation.pages.LoginPage;
import seleniumautomation.tests.BaseTest;

public class DataProviderTest extends BaseTest {


private LoginPage loginPage;

@DataProvider(name = "loginData")
public Object[][] loginData() {
    return new Object[][] {
        { "tomsmith", "SuperSecretPassword!", true, "You logged into a secure area" },
        { "wronguser", "wrongpassword", false, "Your username is invalid!" },
        { "tomsmith", "wrongpassword", false, "Your password is invalid!" }
    };
}

@Test(dataProvider = "loginData")
public void loginTest(String user, String pass, boolean shouldSucceed, String expectedMsg) {

    driver.get("https://the-internet.herokuapp.com/login");

    loginPage = new LoginPage(driver);

    loginPage.login(user, pass);

    String actualMessage = loginPage.getMessage();

    Assert.assertTrue(
        actualMessage.contains(expectedMsg),
        "Expected message: " + expectedMsg + " but actual message was: " + actualMessage
    );
}


}
