package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class API {

    String baseUrl = "https://petstore.swagger.io/v2";

    // Function 1
    public void addPet() {

        RestAssured.baseURI = baseUrl;

        String body = "{ \"id\": 101, \"name\": \"doggie\", \"photoUrls\": [\"string\"], \"status\": \"available\" }";

        Response response =
                given()
                        .header("Content-Type","application/json")
                        .body(body)
                        .when()
                        .post("/pet");

        System.out.println("Pet Added");
    }

    // Function 2
    public void checkIfExists() {

        RestAssured.baseURI = baseUrl;

        Response response =
                given()
                        .queryParam("status","available")
                        .when()
                        .get("/pet/findByStatus");

        String result = response.asString();

        if(result.contains("doggie")){
            System.out.println("Pet exists in store");
        }
        else{
            System.out.println("Pet not found");
        }
    }
}

