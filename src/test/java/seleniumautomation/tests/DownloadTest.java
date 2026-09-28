
package seleniumautomation.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadTest extends BaseTest {

    @Test
    public void downloadFileTest() {

        String downloadPath =
                System.getProperty("user.dir") + "\\downloads";

        File downloadFolder = new File(downloadPath);

        Assert.assertTrue(
                downloadFolder.exists(),
                "Downloads folder does not exist"
        );

        System.out.println("Download folder: " + downloadPath);
    }
}

