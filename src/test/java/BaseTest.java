import Constants.URLS;
import Pages.Account;
import Pages.Home;
import Pages.Login;
import Pages.SignUp;
import Pojos.PojoUser;
import RestApis.BaseUserTest;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static RestApis.BaseUserTest.*;


import java.net.MalformedURLException;



public class BaseTest  {

    static Account acc;
    static Home home;
    static Login login;
    static SignUp signUp;
    static int i =0;

    static PojoUser pj;
    static WebDriver driver;
    @Before
    public void setup(){
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
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
         pj = BaseUserTest.createUser();
         getAuthPj(pj);
    }

    public static WebDriver getWebDriver(String browserName) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        switch (browserName) {
            case "chrome":
                chromeOptions.addArguments("--remote-allow-origins=*","--headless");
                chromeOptions.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");
                return new ChromeDriver(chromeOptions);

            case "yandex":
                chromeOptions.addArguments("--remote-allow-origins=*","--headless");
                return new ChromeDriver(chromeOptions.setBinary("C:/Users/user/AppData/Local/Yandex/YandexBrowser/Application/browser.exe"));
            default:
                throw new RuntimeException("Неподдерживаемый браузер");
        }
    }

    void sign()
    {
        signUp.signUpLinkClick();
        signUp.sendSignUpData(pj );
        signUp.clickSignUpButton();
    }
    void log()
    {
        login.sendLogInData(pj);
        login.clickLogInButton();
    }
    @Step("Регистрация и вход через кнопку Личный кабинет")
    public void RegisterAndLoginAccBut()
    {
        driver.get(URLS.siteURL);
        driver.get(URLS.siteURL);

        home.accountButtonClick();
        sign();
        log();
        home.accountButtonClick();
    }
    @Step("Вход через кнопку Личный кабинет")
    public void LoginAccBut()
    {
        driver.get(URLS.siteURL);
        driver.get(URLS.siteURL);

        home.accountButtonClick();
        log();
        home.accountButtonClick();
    }
    @Step("Вход через кнопку Войти в аккаунт")
    public void LoginEnterAccBut(){
        driver.get(URLS.siteURL);
        driver.get(URLS.siteURL);

        home.loginButtonMain();
        log();
        home.accountButtonClick();
    }
    @Step("Вход через форму восстановления пароля.")
    public void LoginPassRestorePass(){
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        login.clickOnLoginLink();
        log();
        home.accountButtonClick();
    }
    @Step("Вход через форму регистрацию")
    public void LoginRegistrationForm(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        login.clickOnLoginLink();
        log();
        home.accountButtonClick();
    }
    @After
    public void teardown()
    {
        BaseUserTest.deleteUser(pj);
        driver.quit();
    }
}
