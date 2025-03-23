package RestApis;

import Pojos.PojoUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static RestApis.RequestsUsers.*;

public class BaseUserTest{
    static int counter = 0;
    @Step("Создание пользователя")
    public static PojoUser createUser(){
        Instant instant = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = instant.atZone(ZoneId.systemDefault()).format(formatter);

        String name = "Vlad_User_"+formattedTime;
        String email = name+counter+"@yandex.ru";
        String password = "TestP$aSSword";
        return new PojoUser(name,email,password);
    }
    static PojoUser createUser(String param){
        PojoUser user = createUser();
        switch (param){
            case "noName":
                user.setName("");
                break;
            case "noEmail":
                user.setEmail("");
                break;
            case "noPassword":
                user.setPassword("");
                break;
        }
        return user;
    }
    public static PojoUser getAuthPj(PojoUser pj){
        Response r = userSignUp(pj).then().extract().response();
        userLogIn(pj);
        String accessToken = r.jsonPath().getString("accessToken");
        String refreshToken = r.jsonPath().getString("refreshToken");
        pj.setAccessToken(accessToken);
        pj.setRefreshToken(refreshToken);
        pj.setAuthorization(accessToken);
        return pj;
    }

    public static void deleteUser(PojoUser pj){
        if(pj != null){
            userDelete(pj);
        }
    }

}
