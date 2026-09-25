package seleniumautomation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String fileName)
            throws IOException {

        TakesScreenshot screenshot =
                (TakesScreenshot) driver;

        File source =
                screenshot.getScreenshotAs(OutputType.FILE);

        File destination =
                new File("screenshots/" + fileName + ".png");

        destination.getParentFile().mkdirs();

        Files.copy(
                source.toPath(),
                destination.toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );

        System.out.println(
                "Screenshot saved: " + destination.getAbsolutePath()
        );
    }
}