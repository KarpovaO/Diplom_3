package Pages;

import Pojos.PojoUser;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static Constants.LoginForm.*;
import static Constants.SignUpForm.*;

public class Login extends BasePage {
    public Login(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнить данные входа")
    public void sendLogInData(PojoUser user)
    {
        sendKeys(emailInput,user.getEmail());
        sendKeys(passwordInput,user.getPassword());
        sendKeys(passwordInput, String.valueOf(Keys.TAB));
    }
    @Step("Переход по ссылке регистрации")
    public void clickOnRegisterLink(){
        clickElement(registerLink);
    }
    @Step("Послать данные входа")
    public void clickLogInButton()
    {
        clickElement(loginButton);
    }
    @Step("Переход по ссылке Забыли пароль?")
    public void clickOnForgotPasswordLink(){
        clickElement(forgotPasswordLink);
    }
    @Step("Переход по ссылке Войти")
    public void clickOnLoginLink(){
        clickElement(LoginLink);
    }



}
