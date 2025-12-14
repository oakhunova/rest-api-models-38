package tests;

import models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RestApiSpec.*;

@Tag("restapi")
public class RestApiTests {
    private static final TestBase testBase = new TestBase();

    @BeforeEach
    public void setUp() {
        testBase.setupEnvironment();
    }

    @Test
    void checkTotalUsers() {
        TotalUsers response = step("Make request", () -> given()
                .spec(requestNoContentTypeSpec)
                .when()
                .queryParam("page", "2")
                .get("/users")
                .then()
                .spec(response200Spec)
                .extract()
                .as(TotalUsers.class));
        step("Check response", () ->
                assertEquals(12, response.getTotal(), "Total users should be 12"));
    }

    @Test
    void createUser201() {
        CreateUser createData = new CreateUser();
        createData.setName("tony");
        createData.setJob("skater");
        CreateUserResponse response = step("Make request #2", () -> given()
                .spec(requestWithContentTypeSpec)
                .body(createData)
                .when()
                .post("/users")
                .then()
                .spec(response201Spec)
                .extract()
                .as(CreateUserResponse.class));
        step("Check response #2", () -> {
            assertEquals("tony", response.getName(), "Name should be 'tony'");
            assertEquals("skater", response.getJob(), "Job should be 'skater'");
        });
    }

    @Test
    void updateUser200() {
        UpdateUser updateData = new UpdateUser();
        updateData.setName("test");
        updateData.setJob("qa");
        UpdateUserResponse response = step("Make request #3", () -> given()
                .spec(requestWithContentTypeSpec)
                .body(updateData)
                .when()
                .put("/users/2")
                .then()
                .spec(response200Spec)
                .extract()
                .as(UpdateUserResponse.class));
        step("Check response #3", () -> {
            assertEquals("test", response.getName(), "Name should be 'test'");
            assertEquals("qa", response.getJob(), "Job should be 'qa'");
        });
    }

    @Test
    void deleteUser204() {
        step("Make request #4", () -> given()
                .spec(requestNoContentTypeSpec)
                .when()
                .delete("/users/2")
                .then()
                .spec(response204Spec));
    }

    @Test
    void unsuccessfulRegister400() {
        UnsuccessfulRegister unsuccessfulData = new UnsuccessfulRegister();
        unsuccessfulData.setEmail("test@test.com");
        UnsuccessfulRegisterResponse response = step("Make request #5", () -> given()
                .spec(requestWithContentTypeSpec)
                .body(unsuccessfulData)
                .when()
                .post("/register")
                .then()
                .spec(response400Spec)
                .extract()
                .as(UnsuccessfulRegisterResponse.class));
        step("Check response #5", () ->
                assertEquals("Missing password", response.getError(),
                        "Error message should be 'Missing password'"));
    }
}