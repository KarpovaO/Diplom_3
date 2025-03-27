package RestApis;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Requests {
    static RequestSpecification reqSpec(Object body) {
        return given()
                .header("Content-type", "application/json")
                .body(body);
    }
    static RequestSpecification reqSpec() {
        return given()
                .header("Content-type", "application/json");
    }
}
