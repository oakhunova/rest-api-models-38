package tests;

import io.restassured.RestAssured;

public class TestBase {
    public void setupEnvironment() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath="/api";
    }
}
