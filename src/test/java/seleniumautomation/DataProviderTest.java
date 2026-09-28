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
        {"wronguser", "wrongpassword"},
        {"invaliduser", "invalidpassword"}
    };
}



@Test(dataProvider = "loginData")
public void loginTest(String user, String pass) {

    driver.get("https://the-internet.herokuapp.com/login");

    loginPage = new LoginPage(driver);

    loginPage.login(user, pass);

    String actualMessage = loginPage.getMessage();

    Assert.assertTrue(
        actualMessage.contains("Your username is invalid!"),
        "Expected invalid login message but actual message was: " + actualMessage
    );
}




}
