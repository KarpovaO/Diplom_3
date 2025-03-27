package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Constants.HomePage.*;


public class Home extends BasePage {
    public Home(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть на кнопку Личный кабинет")
    public void accountButtonClick(){
        clickElement(accountButton);
    }

    @Step("Кликнуть на кнопку Войти в аккаунт")
    public void loginButtonMain(){
        clickElement(loginButtonMain);
    }
    @Step("Переход в аккаунт")
    public void goToConstructor()
    {
        clickElement(
                constructorButton
        );
    }
    @Step("Переход в ленту заказов")
    public void goToOrdersFeed()
    {
        clickElement(ordersFeedButton);
    }

    @Step("Переход по ссылке булок")
    public void clickOnBunsLink(){
        clickElement(bunsLink);
    }
    @Step("Переход по ссылке соусов")
    public void clickOnSaucesLink(){
        clickElement(saucesLink);
    }
    @Step("Переход по ссылке начинок")
    public void clickOnFillingsLink(){
        clickElement(fillingsLink);
    }

    @Step("Проверить видимость булок")
    public boolean isBunsIsDisplayed() {
        return ifActive(bunsLink);
    }
    @Step("Проверить видимость соусов")
    public boolean isSaucesIsDisplayed() {
        return ifActive(saucesLink);
    }
    @Step("Проверить видимость начинок")
    public boolean isFillingsIsDisplayed() {
        return ifActive(fillingsLink);
    }
    @Step
    public boolean checkFeed(){
        return getVisibility(feederPage);
    }
    @Step("Проверить переход")
    public boolean checkConstructor(){
        return getVisibility(buns);
    }
    @Step("Кликнуть на Лого")
    public void clickLogo()
    {
        clickElement(logo);
    }


    boolean ifActive(By element){
        String classAttribute = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getAttribute("class");
        System.out.println(classAttribute);
        return classAttribute.contains("tab_tab_type_current__2BEPc");
    }

}
