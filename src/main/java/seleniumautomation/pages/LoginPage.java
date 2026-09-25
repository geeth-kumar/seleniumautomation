package seleniumautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.cssSelector("button[type='submit']");
    By message = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String value) {
        type(username, value);
    }

    public void enterPassword(String value) {
        type(password, value);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public String getMessage() {
        return getText(message);
    }
}