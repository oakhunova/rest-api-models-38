package tests;

import models.*;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.ResponseSpec.responseSpec;
import static specs.RequestSpec.*;

public class UserTests extends TestBase {

    @Test
    void checkTotalUsers() {
        TotalUsers response = step("Make request", () -> given()
                .spec(requestNoContentTypeSpec)
                .when()
                .queryParam("page", "2")
                .get("/users")
                .then()
                .spec(responseSpec(200))
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
                .spec(responseSpec(201))
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
                .spec(responseSpec(200))
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
                .spec(responseSpec(204)));
    }

}