
package seleniumautomation.utils;


import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    public static void startTest(String testName) {

        ExtentTest test =
                ExtentReportManager
                        .getReportInstance()
                        .createTest(testName);

        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }
}

