package tests.lesson_16_api_rest_assured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class apiExampleTests {
    @BeforeAll
    static void beforeEach() { RestAssured.baseURI = "https://reqres.in/";}

    @Test
    @DisplayName("GET single user")
    void singleUserTest() {

        given()
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();
    }


    @Test
    @DisplayName("POST create user")
    void createUserTest() {

        String data = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        given()
                .body(data)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract().response();
    }


    @Test
    @DisplayName("POST successful registration")
    void successfulRegistrationTest() {

        String data = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("/api/register")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    @DisplayName("POST unsuccessful registration")
    void unsuccessfulRegistrationTest() {

        String data = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("/api/register")
                .then()
                .log().body()
                .statusCode(400);
    }


    @Test
    @DisplayName("DELETE user")
    void deleteUser() {

        given()
                .when()
                .delete("/api/users/2")
                .then()
                .log().body()
                .statusCode(204);
    }



}
