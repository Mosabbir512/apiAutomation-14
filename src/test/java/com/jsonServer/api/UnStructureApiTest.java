package com.jsonServer.api;

import org.testng.annotations.Test;
import com.thedeanda.lorem.LoremIpsum;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UnStructureApiTest extends BaseStructureApiTest{

    @Test
    public void getPostsListShouldSucceed() {
        given()
                .spec(getHeaderSpecification())
                .log().uri()
                .when()
                .get("/posts")
                .then()
                .log().body()
                .statusCode(200);
    }



}
