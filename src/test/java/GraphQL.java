import com.airstack.ta.pojos.*;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;


class GraphQL {
    private static String Query;
    @BeforeTest
    public void getQuery(){
        String filePath = "src/main/resources/queries/GraphQLQuery";

        try {

            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            String fileContent = new String(bytes, StandardCharsets.UTF_8);
            Query  =fileContent;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    
    @Test
    public void Testing() throws IOException {
        RestAssured.baseURI="https://api.dev.airstack.xyz";
        GraphqlQuery query = new GraphqlQuery();
         query.setQuery(Query);
        InputPojo input = new InputPojo();
        input.setBlockchain("ethereum");
        input.setLimit(10);
        input.setCursor("");
        Filter filter = new Filter();
        Address address = new Address();
        address.setEq("0x60e4d786628fea6478f785a6d7e704777c86a7c6");
        filter.setAddress(address);
        input.setFilter(filter);
        QueryVariable variable = new QueryVariable();
        variable.setInput(input);
        query.setVariables(variable);

      given().log().all().contentType(ContentType.JSON)
                        .body(query)
                .when().post("/gql").then().assertThat().statusCode(200);

    }
}
