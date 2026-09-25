package seleniumautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;

public class WebTableTest extends BaseTest {
	@Test
	public void verifyUserEmail() {

	    driver.get("https://the-internet.herokuapp.com/tables");

	    // Find the row containing Smith
	    WebElement smithRow = driver.findElement(
	            By.xpath("//table[@id='table1']/tbody/tr[td[text()='Smith']]")
	    );

	    // Get the email from the same row
	    String email = smithRow.findElement(
	            By.xpath("./td[3]")
	    ).getText();

	    System.out.println("Smith email: " + email);

	    // Verify email
	    Assert.assertEquals(email, "jsmith@gmail.com");
	}

    @Test
    public void webTableFunctionality() {

        driver.get("https://the-internet.herokuapp.com/tables");

        // Find all rows in the first table
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@id='table1']/tbody/tr")
        );

        System.out.println("Total rows: " + rows.size());

        // Verify rows are present
        Assert.assertTrue(rows.size() > 0);

        // Get first row
        WebElement firstRow = rows.get(0);

        // Get cells from first row
        List<WebElement> cells = firstRow.findElements(
                By.tagName("td")
        );

        System.out.println("Total columns: " + cells.size());

        // Verify columns are present
        Assert.assertTrue(cells.size() > 0);

        // Print first row data
        for (WebElement cell : cells) {
            System.out.println(cell.getText());
        }
        
    }
    @Test
    public void verifyUserDetails() {

        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement smithRow = driver.findElement(
                By.xpath("//table[@id='table1']/tbody/tr[td[text()='Smith']]")
        );

        List<WebElement> cells = smithRow.findElements(By.tagName("td"));

        Assert.assertEquals(cells.get(0).getText(), "Smith");
        Assert.assertEquals(cells.get(1).getText(), "John");
        Assert.assertEquals(cells.get(2).getText(), "jsmith@gmail.com");
        Assert.assertEquals(cells.get(3).getText(), "$50.00");

        System.out.println("Smith's complete details verified successfully.");
    }
}