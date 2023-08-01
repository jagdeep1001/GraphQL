package Tests;

import DataCreation.CreateQuery;
import com.airstack.ta.pojos.*;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.xml.validation.Schema;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Reporter.log;



class GraphQL extends BaseTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(GraphQL.class);

    @DataProvider(name="AddressEQ")
    public Object[][] getAddressEq(){
        return new Object[][]{{"0x60e4d786628fea6478f785a6d7e704777c86a7c6"},{"0xedf6d3c3664606fe9ee3a9796d5cc75e3b16e682"}};

    }

    
    @Test(dataProvider ="AddressEQ" , testName = "Verifying For Multiple Ethereum Address")
    @Feature("Airstack GQL API")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Airstack GQL API")
    @Step("Airstack GQL API")
    public void BaseUrlTest(String eq) throws IOException {

        GraphqlQuery query = CreateQuery.makeNewQuery(eq);
        LOGGER.info("Setting Query as "+ query);

        //Assertions
        Response response = (Response) RestAssured.given().log().all().contentType(ContentType.JSON)
                .body(query).filter(new AllureRestAssured())
                .post("/gql");
        Assert.assertEquals(response.getStatusCode(), 200);
        //Json Schema Validation
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/response_schema.json")));
        log("Verified Successfully !!");



    }



}
