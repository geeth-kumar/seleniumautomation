package seleniumautomation.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import seleniumautomation.utils.ConfigReader;
import seleniumautomation.utils.ScreenshotUtils;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {

        ConfigReader.loadProperties();

        String browser =
                ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            String downloadPath =
                    System.getProperty("user.dir") + "\\downloads";

            File downloadFolder = new File(downloadPath);

            if (!downloadFolder.exists()) {
                downloadFolder.mkdirs();
            }

            Map<String, Object> prefs = new HashMap<>();

            prefs.put("download.default_directory", downloadPath);
            prefs.put("download.prompt_for_download", false);
            prefs.put("download.directory_upgrade", true);

            ChromeOptions options = new ChromeOptions();

            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
        }

        // Temporarily commented because of the Chrome 153 maximize issue
        // driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            try {

                ScreenshotUtils.takeScreenshot(
                        driver,
                        result.getName()
                );

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}