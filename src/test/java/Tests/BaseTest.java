package Tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        System.out.println("Starting Testss !!");
        Properties properties = new Properties();
        try {
            // Loading the properties file using FileInputStream
            InputStream inputStream = Files.newInputStream(Paths.get("src/test/resources/endpoints.properties"));
            properties.load(inputStream);


            String baseUrl = properties.getProperty("baseURI");
            System.out.println("Setting Base URL as " + baseUrl);
            RestAssured.baseURI=baseUrl;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
