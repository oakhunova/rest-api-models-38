package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {
    @BeforeEach
    public void setupEnvironment() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath="/api";
    }
}
