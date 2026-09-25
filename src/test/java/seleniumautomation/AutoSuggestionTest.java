package seleniumautomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;

public class AutoSuggestionTest extends BaseTest {

    @Test
    public void autoSuggestionFunctionality() {

        driver.get("https://www.google.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Enter search text
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("q")
                )
        );

        searchBox.sendKeys("selenium");

        // Wait for suggestions
        List<WebElement> suggestions = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.cssSelector("ul[role='listbox'] li")
                )
        );

        System.out.println("Total suggestions: " + suggestions.size());

        // Find and click Selenium WebDriver suggestion
        for (WebElement suggestion : suggestions) {

            String text = suggestion.getText();

            System.out.println(text);

            if (text.toLowerCase().contains("selenium webdriver")) {
                suggestion.click();
                break;
            }
        }

        // Verify search box contains selenium
        Assert.assertTrue(searchBox.getAttribute("value").contains("selenium"));
    }
}