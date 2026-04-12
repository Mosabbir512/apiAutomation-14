package com.jsonServer.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UnStructureApiTest {
    @Test
    public void getPostsListShouldSucceed() {
        given()
                .contentType("application/json")
                .log().uri()
                .when()
                .get("http://localhost:3000/posts")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getPostDetailShouldSucceed() {
        given()
                .contentType("application/json")
                .log().uri()
                .when()
                .get("http://localhost:3000/posts/1")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void createPostShouldSucceed() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        "\"title\": \"A Little from Batch 14\",\n" +
                        "\"views\": 200\n" +
                        "}")
                .log().uri()
                .log().body()
                .when()
                .post("http://localhost:3000/posts")
                .then()
                .log().body()
                .statusCode(201);
    }

    @Test
    public void putPostShouldSucceed() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        "\"title\": \"put title Batch 14\",\n" +
                        "\"views\": 210\n" +
                        "}")
                .log().uri()
                .log().body()
                .when()
                .put("http://localhost:3000/posts/2")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void patchPostShouldSucceed() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        "\"title\": \"Patch title Batch 14\"\n" +
                        "}")
                .log().uri()
                .log().body()
                .when()
                .patch("http://localhost:3000/posts/2")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void deletePostShouldSucceed() {
        given()
                .contentType("application/json")
                .log().uri()
                .when()
                .delete("http://localhost:3000/posts/_zkMY9WKxwI")
                .then()
                .log().body()
                .statusCode(200);
    }
}