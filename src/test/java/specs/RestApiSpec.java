package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class RestApiSpec {
    public static RequestSpecification requestWithContentTypeSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .contentType(JSON)
            .header("x-api-key", "reqres_5dc6050206484003aa6a6c6df4eee54a");

    public static RequestSpecification requestNoContentTypeSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .header("x-api-key", "reqres_5dc6050206484003aa6a6c6df4eee54a");

    public static ResponseSpecification response200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification response201Spec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification response204Spec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification response400Spec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(STATUS)
            .log(BODY)
            .build();

}


