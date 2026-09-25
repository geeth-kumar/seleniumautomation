package seleniumautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;

public class FirstTest {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(2000);

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);

        File destination = new File("google-screenshot.png");

        Files.copy(source.toPath(), destination.toPath());

        System.out.println("Screenshot saved successfully!");

        Thread.sleep(2000);

        driver.quit();
    }
}