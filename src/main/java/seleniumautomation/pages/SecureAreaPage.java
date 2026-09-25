package seleniumautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    By pageHeading = By.cssSelector("h2");
    By logoutButton = By.cssSelector("a.button.secondary.radius");
    By loginButton = By.cssSelector("button[type='submit']");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeading() {
        return getText(pageHeading);
    }

    public void clickLogout() {
        click(logoutButton);
        }
        public boolean isLoginButtonDisplayed() {
            return driver.findElement(loginButton).isDisplayed();
        }
    
}