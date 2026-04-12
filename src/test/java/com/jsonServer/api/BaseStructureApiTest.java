package com.jsonServer.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseStructureApiTest {

    // Start JSON Server
    // npx json-server db.json
    final protected String BASE_URL = "http://localhost";
    final protected int PORT = 3000;


    public String getPostId() {
        String postId = given()
                .contentType("application/json")
                .baseUri(BASE_URL)
                .port(PORT)
                .log().uri()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract().jsonPath().getString("[0].id");
        return postId;
    }

    public Map<String, Object> getPostObj(String title_name, int viewNumber) {
        Map<String, Object> sharifBody = new HashMap<>();
        sharifBody.put("title", title_name);
        sharifBody.put("views", viewNumber);
        return sharifBody;
    }

    public Map<String, Object> getPostObj(String title_name) {
        Map<String, Object> sharifBody = new HashMap<>();
        sharifBody.put("title", title_name);
        return sharifBody;
    }

    public RequestSpecification getHeaderSpecification() {
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setContentType("application/json")
                .setBaseUri(BASE_URL)
                .setPort(PORT);
        return builder.build();
    }

    public RequestSpecification getHeadWithJsonPlayLoad(String tittle, int viewNumber) {
        return new RequestSpecBuilder()
                .addRequestSpecification(getHeaderSpecification())
                .setBody(getPostObj(tittle, viewNumber))
                .build();
    }

}