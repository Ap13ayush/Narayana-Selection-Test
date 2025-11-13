package com.narayana.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

// API tests using JSONPlaceholder public API
public class ApiTests {

    // Test to create a new user with POST request
    @Test(groups = "API")
    public void testCreateUser() {
        String requestBody = "{\n" +
                "    \"name\": \"Ayush Patel\",\n" +
                "    \"username\": \"ayush.patel\",\n" +
                "    \"email\": \"ayush.patel@example.com\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("https://jsonplaceholder.typicode.com/users")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertNotNull(response.jsonPath().getString("id"));
    }

    // Test to update a user with PUT request
    @Test(groups = "API")
    public void testUpdateUser() {
        String requestBody = "{\n" +
                "    \"name\": \"Harshita Pal\",\n" +
                "    \"username\": \"harshita.pal\",\n" +
                "    \"email\": \"harshita.pal@example.com\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "Harshita Pal");
    }

    // Test to get a user by ID
    @Test(groups = "API")
    public void testGetUser() {
        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
        Assert.assertNotNull(response.jsonPath().getString("name"));
    }

    // Test to get all users
    @Test(groups = "API")
    public void testGetAllUsers() {
        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("$").size() > 0);
    }
}
