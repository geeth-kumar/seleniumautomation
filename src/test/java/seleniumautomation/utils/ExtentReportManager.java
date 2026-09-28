package seleniumautomation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Project", "Selenium Automation");
            extent.setSystemInfo("Tester", "Geeth Kumar");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }
}