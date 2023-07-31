package Tests;

import DataCreation.CreateQuery;
import com.airstack.ta.pojos.GraphqlQuery;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Reporter.log;

public class CursorTests extends BaseTest{


    @DataProvider(name="AddressEQ")
    public Object[][] getAddressEq(){
        return new Object[][]{{"1"},{"2"}};

    }

    @Test(dataProvider ="AddressEQ" , testName = "Verifying For Multiple Ethereum Address")
    @Feature("Airstack GQL API")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Airstack GQL API")
    @Step("Airstack GQL API")
    public void BaseUrlTest(String eq)  {
        GraphqlQuery query = CreateQuery.makeNewQuery(eq);
        Response response = (Response) RestAssured.given().log().all().contentType(ContentType.JSON)
                .body(query).filter(new AllureRestAssured())
                .post("/gql");

        //Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        log("Verified Successfully !!");
    }
}
