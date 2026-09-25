package seleniumautomation.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import seleniumautomation.utils.ConfigReader;

public class ConfigTest {

    @Test
    public void readConfig() throws IOException {

        ConfigReader.loadProperties();

        System.out.println("URL: " +
                ConfigReader.getProperty("url"));

        System.out.println("Browser: " +
                ConfigReader.getProperty("browser"));

        System.out.println("Username: " +
                ConfigReader.getProperty("username"));
    }
}