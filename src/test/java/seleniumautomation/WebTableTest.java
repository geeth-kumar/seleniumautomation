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

	    // Wait until the first row is displayed
	    WebElement firstRow = new org.openqa.selenium.support.ui.WebDriverWait(
	            driver,
	            java.time.Duration.ofSeconds(10)
	    ).until(
	            org.openqa.selenium.support.ui.ExpectedConditions
	                    .visibilityOfElementLocated(
	                            By.xpath("//table[@id='table1']/tbody/tr[1]")
	                    )
	    );

	    // Get cells from first row
	    List<WebElement> cells = firstRow.findElements(By.tagName("td"));

	    System.out.println("Total columns: " + cells.size());

	    // Verify columns are present
	    Assert.assertTrue(
	            cells.size() > 0,
	            "No columns found in the first table row"
	    );

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