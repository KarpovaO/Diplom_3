import Constants.URLS;
import Pages.Account;
import Pages.Home;
import Pages.Login;
import Pages.SignUp;
import Pojos.PojoUser;
import RestApis.BaseUserTest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import static RestApis.BaseUserTest.createUser;
import static RestApis.BaseUserTest.getAuthPj;
import static org.junit.Assert.assertEquals;

public class SignUpTest extends BaseTest {
    @Before
    @Override
    public void setup() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        pj = createUser();

        try {
            driver = getWebDriver("chrome");
        } catch (MalformedURLException e) {
            System.out.println("error" + e.toString());
        }
        acc = new Account(driver);
        home = new Home(driver);
        login = new Login(driver);
        signUp = new SignUp(driver);
        driver.get(URLS.siteURL);
    }

    @Test
    @DisplayName("Тест Попытка регистрации с невалидным паролем")
    public void WrongPassTest() {
        home.accountButtonClick();
        signUp.signUpLinkClick();
        pj.setPassword("passw");
        signUp.sendSignUpData(pj);
        signUp.clickSignUpButton();
        String s = signUp.getErrorPasswordMessage();
        assertEquals("Некорректный пароль", s);
    }
    @Test
    @DisplayName("Тест Успешная регистрация")
    public void RegistrationTest() {
        getAuthPj(pj);
        driver.get(URLS.registerURL);
        signUp.sendSignUpData(pj);
        driver.get(URLS.loginURL);
        login.sendLogInData(pj);
        login.clickLogInButton();
        home.accountButtonClick();

        PojoUser actual_pj = acc.getData();
        assertEquals(pj.getName().toLowerCase(),actual_pj.getName().toLowerCase());
        assertEquals(pj.getEmail().toLowerCase(),actual_pj.getEmail().toLowerCase());

        acc.logOutButtonClick();
        BaseUserTest.deleteUser(pj);

    }
    @After
    @Override
    public void teardown() {
        driver.quit();
    }

}
