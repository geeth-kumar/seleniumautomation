
package seleniumautomation.tests;

import seleniumautomation.utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import java.io.IOException;



import seleniumautomation.utils.ConfigReader;
import seleniumautomation.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumautomation.pages.LoginPage;
import seleniumautomation.utils.ExtentTestManager;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;
    @BeforeMethod
    public void openLoginPage() {
    	

        String url = ConfigReader.getProperty("url");

        driver.get(url);

        loginPage = new LoginPage(driver);
    }
   
    
    
    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {

        String filePath =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\loginData.xlsx";

        return ExcelUtils.getTestData(
                filePath,
                "LoginData"
        );
    }
    

    


    
    @Test
    public void validLoginTest() {

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage.login(username, password);

        String message = loginPage.getMessage();

        Assert.assertTrue(
                message.contains("You logged into a secure area!")
        );
        ExtentTestManager.getTest().pass("Valid login test passed");
    }
    


   
    @Test(dataProvider = "loginData")
    public void invalidLoginTest(String username, String password) {

        loginPage.login(username, password);

        String message = loginPage.getMessage();

        Assert.assertTrue(
                message.contains("Your username is invalid!")
        );
        ExtentTestManager.getTest().pass(
                "Invalid login test passed"
        );
    }
    

}