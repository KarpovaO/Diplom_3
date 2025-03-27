package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void sendKeys(By element, String keys)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(keys);
    }
    String getValue(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getAttribute("value");
    }
    String getText(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }
    boolean getVisibility(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
    }
}
