package Tests;

import com.sun.org.apache.bcel.internal.generic.LOOKUPSWITCH;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    @BeforeSuite
    public void setUp() {
        LOGGER.info("Starting Testss !!");
        Properties properties = new Properties();
        try {
            // Loading the properties file using FileInputStream
            InputStream inputStream = Files.newInputStream(Paths.get("src/test/resources/endpoints.properties"));
            properties.load(inputStream);


            String baseUrl = properties.getProperty("baseURI");
            LOGGER.info("Setting Base URL as " + baseUrl);
            RestAssured.baseURI=baseUrl;

        } catch (IOException e) {
            LOGGER.error("***********Exception Occurred***************");
            e.printStackTrace();
        }
    }
    @AfterSuite
    public void tearDown(){
        LOGGER.info("Shutting Down the Tests !!");
    }

}
