package simpleGrocery.api;

import com.thedeanda.lorem.LoremIpsum;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseSimpleGroceryStoreApiTest {
    final protected String BASE_URL = "https://simple-grocery-store-api.click";
    String bearer_token = "acb7a18f6b34427900cdd27f723b2fedca6beb55edcc80998179ba89bdd745ee";
                         //7dca74257d6124df20dfb81820d99a391e3de63febf70d53db4897f100bdbc2b

    public RequestSpecification getHeaderSpecification() {
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setContentType("application/json")
                .setBaseUri(BASE_URL);
        return builder.build();
    }

    public String getBearerToken() {
        Map<String, String> client = new HashMap<>();
        client.put("clientName", LoremIpsum.getInstance().getName());
        client.put("clientEmail", LoremIpsum.getInstance().getEmail());


        return given()
                .spec(getHeaderSpecification())
                .body(client)
                .log().uri()
                .log().body()
                .when()
                .post("/api-clients")
                .then()
                .log().body()
                .statusCode(201)
                .extract().jsonPath().getString("accessToken");
    }

    public String orderId(){
        return given()
                .spec(getHeaderSpecification())
                .header("Authorization", "Bearer " + bearer_token)
                .log().uri()
                .when()
                .get("/orders")
                .then()
                .extract().jsonPath().getString("[0].id");
    }

}