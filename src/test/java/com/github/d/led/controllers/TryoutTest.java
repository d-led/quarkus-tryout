package com.github.d.led.controllers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TryoutTest {

    @Test
    public void test_hello_endpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

    @Test
    public void test_multiplication_endpoint() {
        given()
                .when()
                .queryParam("a", 2)
                .queryParam("b", 3)
                .get("/hello/multiply")
                .then()
                .statusCode(200)
                .body("result", is(6));
    }
}
