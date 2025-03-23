package Pages;

import Pojos.PojoUser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static Constants.PersonalAccount.*;
public class Account extends BasePage{
    public Account(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть на кнопку Выйти")
    public void logOutButtonClick(){
        clickElement(logoutButton);
    }
    @Step("Прочитать данные об отправленном пароле")
    public PojoUser getData()
    {

        return new PojoUser(getValue(profileName),getValue(profileEmail),"password");
    }

}
