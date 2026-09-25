package seleniumautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReportingTest {

    @Test
    public void passTest() {

        System.out.println("This test should PASS");

        Assert.assertTrue(true);
    }

    @Test
    public void anotherPassTest() {

        System.out.println("Another test should PASS");

        Assert.assertEquals(10, 10);
    }

    @Test
    public void failTest() {

        System.out.println("This test should FAIL");

        Assert.assertEquals(10, 10);
    }
}