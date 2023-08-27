package data.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static data.browser.WebDriverBrowser.BASE_URL;
import static io.restassured.RestAssured.given;

public class UserApiClient {
    private static final String API_AUTH_REGISTER = "/api/auth/register";
    private static final String API_AUTH_LOGIN = "/api/auth/login";
    private static final String API_AUTH_USER = "/api/auth/user";

    public UserApiClient() {
        RestAssured.baseURI = BASE_URL;
    }

    public Response createUser(String email, String password, String name) {
        String json = "{\"email\": \"" + email + "\", \"password\": \"" + password + "\", \"name\": \"" + name + "\"}";
        return given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .post(API_AUTH_REGISTER);
    }

    public Response deleteUser(String email, String password) {

        String json = "{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}";
        String token = "";
        Response login = given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .post(API_AUTH_LOGIN);

        if (login.then().extract().path("success")) {
            token = login.then().extract().path("accessToken").toString().substring(7);
        }

        return given()
                .header("Content-type", "application/json")
                .auth().oauth2(token)
                .when()
                .delete(API_AUTH_USER);

    }
}
