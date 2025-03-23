package Constants;

import org.openqa.selenium.By;

public class SignUpForm {
    //Ввод имени, почты и пароля
    public final static By nameInput = By.xpath("//label[contains(text(), 'Имя')]/following-sibling::input");
    public final static By emailInput = By.xpath("//label[contains(text(), 'Email')]/following-sibling::input");
    public final static By passwordInput = By.xpath("//label[contains(text(), 'Пароль')]/following-sibling::input");

    //
    public final static By signUpButton = By.xpath("//*[contains(text(), 'Зарегистрироваться')]");
    //

    //Сообщение о неверном пароле
    public final static By passwordErrorTex = By.className("input__error");
}
