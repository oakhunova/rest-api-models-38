package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import static helpers.CustomAllureListener.withCustomTemplates;

public class TestBase {

    public static RequestSpecification baseRequestSpec;
    static String apiKey;

    @BeforeAll
    public static void setupEnvironment() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
        apiKey = System.getProperty("X_API_KEY");
        baseRequestSpec = new RequestSpecBuilder()
                .addFilter(withCustomTemplates())
                .addHeader("x-api-key", apiKey)
                .log(LogDetail.URI)
                .build();
    }
}
