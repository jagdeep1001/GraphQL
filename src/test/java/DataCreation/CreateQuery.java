package DataCreation;

import com.airstack.ta.pojos.*;
import com.airstack.ta.pojos.QueryPojo.Token;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

 public class CreateQuery {
    private static String Query;
     private static String Token;

     public static void getQuery(){
        String filePath = "src/main/resources/queries/GraphQLQuery";
        try {

            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            String fileContent = new String(bytes, StandardCharsets.UTF_8);
            Query  =fileContent;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static GraphqlQuery makeNewQuery(String eq){

        getQuery();

        //Initializing all the pojos
        GraphqlQuery query = new GraphqlQuery();
        InputPojo input = new InputPojo();
        Filter filter = new Filter();
        Address address = new Address();
        QueryVariable variable = new QueryVariable();


        //Setting Input Variables

        query.setQuery(Query);
        input.setBlockchain("ethereum");
        input.setLimit(10);
        input.setCursor("");


        //Setting EQ Address
        address.setEq(eq);

        //Setting address in the filter
        filter.setAddress(address);
        input.setFilter(filter);

        //Finally, setting the inout as variable to the query
        variable.setInput(input);
        query.setVariables(variable);
        return query;
    }
}
