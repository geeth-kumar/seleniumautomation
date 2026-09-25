package seleniumautomation;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumautomation.tests.BaseTest;

public class FileDownloadTest extends BaseTest {

    @Test
    public void fileDownloadFunctionality() {

        driver.get("https://the-internet.herokuapp.com/download");

        String downloadPath = System.getProperty("user.dir") + "\\downloads";

        File downloadFolder = new File(downloadPath);

        System.out.println("Download folder: " + downloadPath);
        System.out.println("Folder exists: " + downloadFolder.exists());

        // Click the first downloadable file
        driver.findElement(By.xpath("//div[@id='content']//a")).click();

        // Wait for download
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File[] files = downloadFolder.listFiles();

        Assert.assertNotNull(files, "Downloads folder could not be accessed");
        Assert.assertTrue(files.length > 0, "No file was downloaded");

        System.out.println("Downloaded files: " + files.length);

        for (File file : files) {
            System.out.println("Downloaded file: " + file.getName());
        }
    }

}