package seleniumautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import seleniumautomation.utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    protected void click(By locator) {

        waitUtils.waitForElementClickable(locator);

        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {

        waitUtils.waitForElementVisible(locator);

        driver.findElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {

        waitUtils.waitForElementVisible(locator);

        return driver.findElement(locator).getText();
    }
}