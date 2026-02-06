package tests;

import models.UnsuccessfulRegister;
import models.UnsuccessfulRegisterResponse;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RequestSpec.requestWithContentTypeSpec;
import static specs.ResponseSpec.responseSpec;

public class RegistrationTest extends TestBase{
    @Test
    void unsuccessfulRegister400() {
        UnsuccessfulRegister unsuccessfulData = new UnsuccessfulRegister("test@test.com");
        UnsuccessfulRegisterResponse response = step("Make request #5", () -> given()
                .spec(requestWithContentTypeSpec)
                .body(unsuccessfulData)
                .when()
                .post("/register")
                .then()
                .spec(responseSpec(400))
                .extract()
                .as(UnsuccessfulRegisterResponse.class));
        step("Check response #5", () ->
                assertEquals("Missing password", response.getError(),
                        "Error message should be 'Missing password'"));
    }
}
