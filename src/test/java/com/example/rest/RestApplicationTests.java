package com.example.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;


@SpringBootTest
class RestApplicationTests {

    @Test
    void contextLoads() {
        baseURI="http://localhost:8082/students";

        given().
                when().
                then().
                statusCode(200);

    }
}