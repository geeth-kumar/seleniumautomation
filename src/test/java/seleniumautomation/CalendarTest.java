package seleniumautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;

public class CalendarTest extends BaseTest {

    @Test
    public void calendarFunctionality() {

        driver.get("https://jqueryui.com/datepicker/");

        // Switch to iframe
        driver.switchTo().frame(
                driver.findElement(By.cssSelector(".demo-frame"))
        );

        // Click date field
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.click();

        // Select a date
        driver.findElement(
                By.xpath("//a[text()='16']")
        ).click();

        // Get selected date
        String selectedDate = dateField.getAttribute("value");

        System.out.println("Selected date: " + selectedDate);

        // Verify date was selected
        Assert.assertFalse(selectedDate.isEmpty());

        // Switch back to main page
        driver.switchTo().defaultContent();
    }
}