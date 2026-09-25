package seleniumautomation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import seleniumautomation.pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends BaseTest {

    private AddRemoveElementsPage addRemovePage;

    @BeforeMethod
    public void openAddRemovePage() {

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        addRemovePage = new AddRemoveElementsPage(driver);
    }

    @Test
    public void addAndDeleteElementTest() {

        addRemovePage.clickAddElement();

        Assert.assertTrue(
            addRemovePage.isDeleteButtonDisplayed()
        );

        addRemovePage.clickDelete();

        Assert.assertFalse(
            addRemovePage.isDeleteButtonPresent()
        );
    }
}