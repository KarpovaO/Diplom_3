package RestApis;

import Pojos.PojoUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestsUsers  extends Requests {
    private final static String CREATE_USER = "/api/auth/register";
    private final static String LOGIN_USER = "/api/auth/login";
    private final static String EDIT_USER = "/api/auth/user";
    private final static String DELETE_USER = "/api/auth/user";

    @Step("Регистрация пользователя через API")
    public static Response userSignUp(PojoUser user) {

            return  given()
                    .spec(reqSpec(user))
                    .post(CREATE_USER);
    }
    @Step("Авторизация пользователя")
    public static Response userLogIn(PojoUser user) {
        return given()
                .spec(reqSpec(user))
                .post(LOGIN_USER);
    }
    @Step("Изменение данных пользователя")

    public static Response userChangeData(PojoUser user,String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .body(user)
                .patch(EDIT_USER);
    }
    @Step("Попытка изменения данных пользователя без авторизации")

    public static Response userChangeDataUnauthorized(PojoUser user) {
        return given()
                .spec(reqSpec(user))
                .patch(EDIT_USER);
    }
    @Step("Получение данных пользователя")
    public static Response userGet(PojoUser user,String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .body(user)
                .get(EDIT_USER);
    }
    @Step("Удаление пользователя")
    public static Response userDelete(PojoUser user) {
        return given()
                .header("Authorization", user.getAccessToken())
                .body(user)
                .delete(DELETE_USER);
    }
}
