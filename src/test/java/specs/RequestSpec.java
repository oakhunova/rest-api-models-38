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