package Constants;

import org.openqa.selenium.By;

public class HomePage {
    //Ccылки меню
    public final static By bunsLink = By.xpath("//span[text()='Булки']/..");
    public final static By saucesLink = By.xpath("//span[text()='Соусы']/..");
    public final static By fillingsLink = By.xpath("//span[text()='Начинки']/..");

    //Локатор булок
    public final static  By buns = By.xpath("//h2[contains(text(),'Булки') ]");
    //Локатор соусов
    public final static  By sauces = By.xpath("//h2[contains(text(),'Соусы')]");
    //Локатор начинки
    public final static By fillings = By.xpath("//h2[contains(text(),'Начинки')]");

    //Локатор ленты
    public final static By feederPage= By.className("OrderFeed_orderFeed__2RO_j");

    //Локатор Лого
    public final static By logo = By.className("AppHeader_header__logo__2D0X2");

    //Кнопка Личный кабинет
    public final static By accountButton = By.xpath("//p[text()='Личный Кабинет']");

    //Кнопка войти в аккаунт

    public final static By loginButtonMain = By.xpath("//button[text()='Войти в аккаунт']");

    //Кнопка Конструктор
    public final static By constructorButton = By.xpath("//p[text()='Конструктор']");

    //Кнопка Лента заказов
    public final static By ordersFeedButton = By.xpath("//p[text()='Лента Заказов']");
    //

}
