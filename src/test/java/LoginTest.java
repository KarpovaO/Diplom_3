import Pojos.PojoUser;
import io.qameta.allure.junit4.DisplayName;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход через Кнопку Личный кабинет")
    public void LogInTest1() {
        LoginAccBut();
        PojoUser actual_pj = acc.getData();
        assertEquals(pj.getName().toLowerCase(),actual_pj.getName().toLowerCase());
        assertEquals(pj.getEmail().toLowerCase(),actual_pj.getEmail().toLowerCase());
        acc.logOutButtonClick();

    }
    @Test
    @DisplayName("Вход через Кнопку Войти в аккаунт")

    public void LogInTest2() {
        LoginEnterAccBut();
        PojoUser actual_pj = acc.getData();
        assertEquals(pj.getName().toLowerCase(),actual_pj.getName().toLowerCase());
        assertEquals(pj.getEmail().toLowerCase(),actual_pj.getEmail().toLowerCase());
        acc.logOutButtonClick();

    }
    @Test
    @DisplayName("Вход через Форму восстановления пароля.")

    public void LogInTest3() {
        LoginPassRestorePass();
        PojoUser actual_pj = acc.getData();
        assertEquals(pj.getName().toLowerCase(),actual_pj.getName().toLowerCase());
        assertEquals(pj.getEmail().toLowerCase(),actual_pj.getEmail().toLowerCase());
        acc.logOutButtonClick();

    }
    @Test
    @DisplayName("Вход через Форму регистрации.")
    public void LogInTest4() {
        LoginRegistrationForm();
        PojoUser actual_pj = acc.getData();
        assertEquals(pj.getName().toLowerCase(),actual_pj.getName().toLowerCase());
        assertEquals(pj.getEmail().toLowerCase(),actual_pj.getEmail().toLowerCase());
        acc.logOutButtonClick();

    }
}
