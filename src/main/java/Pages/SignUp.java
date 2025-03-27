package Pages;

import Pojos.PojoUser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static Constants.SignUpForm.*;

public class SignUp extends BasePage
{
    public SignUp(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть на ссылку Зарегистрироваться")
    public void signUpLinkClick(){
        clickElement(signUpButton);
    }
    @Step("Заполнить данные регистрации")
    public void sendSignUpData(PojoUser user){
        sendKeys(nameInput,user.getName());
        sendKeys(emailInput,user.getEmail());
        sendKeys(passwordInput,user.getPassword());
    }
    @Step("Послать данные регистрации")
    public void clickSignUpButton() {
        clickElement(signUpButton);
    }
    @Step("Получить сообещение о неверном пароле")
    public String getErrorPasswordMessage()
    {
        return getText(passwordErrorTex);
    }






}
