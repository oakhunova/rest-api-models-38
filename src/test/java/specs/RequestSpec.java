//package specs;
//
//import io.restassured.specification.RequestSpecification;
//import static helpers.CustomAllureListener.withCustomTemplates;
//import static io.restassured.RestAssured.with;
//import static io.restassured.http.ContentType.JSON;
//
//public class RequestSpec {
//    public static RequestSpecification requestWithContentTypeSpec = with()
//            .filter(withCustomTemplates())
//            .log().uri()
//            .contentType(JSON)
//            .header("x-api-key", "reqres_5dc6050206484003aa6a6c6df4eee54a");
//
//    public static RequestSpecification requestNoContentTypeSpec = with()
//            .filter(withCustomTemplates())
//            .log().uri()
//            .header("x-api-key", "reqres_5dc6050206484003aa6a6c6df4eee54a");
//
//}
package specs;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.http.ContentType.JSON;
import static tests.TestBase.baseRequestSpec;

public class RequestSpec {

    public static final RequestSpecification requestWithContentTypeSpec =
            new RequestSpecBuilder()
                    .addRequestSpecification(baseRequestSpec)
                    .setContentType(JSON)
                    .build();

    public static final RequestSpecification requestNoContentTypeSpec =
            new RequestSpecBuilder()
                    .addRequestSpecification(baseRequestSpec)
                    .build();
}