package seleniumautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElementsPage extends BasePage {

    By addElementButton = By.xpath("//button[text()='Add Element']");
    By deleteButton = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddElement() {
        click(addElementButton);
    }

    public void clickDelete() {
        click(deleteButton);
    }

    public boolean isDeleteButtonDisplayed() {
        return driver.findElement(deleteButton).isDisplayed();
    }

    public boolean isDeleteButtonPresent() {
        return driver.findElements(deleteButton).size() > 0;
    }
}