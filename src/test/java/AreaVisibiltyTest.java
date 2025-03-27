import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AreaVisibiltyTest extends BaseTest
{

    @Test
    @DisplayName("Тест на переход к разделу Булки")
    public void areaBunsVisibilityTest() {
        assertTrue(home.isBunsIsDisplayed());
    }
    @Test
    @DisplayName("Тест на переход к разделу Соусы")

    public void areaSaucesVisibilityTest(){
        home.clickOnSaucesLink();
        assertTrue(home.isSaucesIsDisplayed());
    }
    @Test
    @DisplayName("Тест на переход к разделу Начинки")
    public void areaFillingsVisibilityTest(){
        home.clickOnFillingsLink();
        assertTrue(home.isFillingsIsDisplayed());
    }
}
