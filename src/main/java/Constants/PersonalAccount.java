package Constants;

import org.openqa.selenium.By;

public class PersonalAccount {
    //Кнопка выход из аккаунта
    public final static By logoutButton = By.xpath("//button[text()='Выход']/..");

    //Имя в профиле
    public final static By profileName = By.xpath("//label[contains(text(), 'Имя')]/following-sibling::input");

    //email в профиле
    public final static By profileEmail = By.xpath("//label[contains(text(), 'Логин')]/following-sibling::input");

}
