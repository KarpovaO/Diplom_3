package Constants;

import org.openqa.selenium.By;

public class LoginForm {
    public final static By loginButton = By.xpath("//button[text()='Войти']");

    //Кнопка войти в аккаунт

    public final static By loginButtonMain = By.xpath("//button[text()='Войти в аккаунт']");
    //Ссылка зарегистрироваться
    public final static By registerLink = By.xpath("//a[text()='Зарегистрироваться']");

    //Cсылка восстановите пароль
    public final static By forgotPasswordLink = By.xpath("//a[text()='Восстановить пароль']");


    //Ссылка Войти
    public final static By LoginLink = By.xpath("//a[text()='Войти']");
}
