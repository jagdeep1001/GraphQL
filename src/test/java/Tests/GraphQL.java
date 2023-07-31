package Tests;

import DataCreation.CreateQuery;
import com.airstack.ta.pojos.*;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import static org.testng.Reporter.log;



class GraphQL extends BaseTest {



    @DataProvider(name="AddressEQ")
    public Object[][] getAddressEq(){
        return new Object[][]{{"0x60e4d786628fea6478f785a6d7e704777c86a7c6"},{"0xedf6d3c3664606fe9ee3a9796d5cc75e3b16e682"}};

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
