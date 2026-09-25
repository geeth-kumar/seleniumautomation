package seleniumautomation;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadFunctionality() {

        driver.get("https://the-internet.herokuapp.com/upload");

        String filePath = System.getProperty("user.dir") + "\\testdata\\sample.txt";

        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));

        System.out.println("Uploaded file: " + uploadedFile.getText());

        Assert.assertEquals(uploadedFile.getText(), "sample.txt");
    }
}