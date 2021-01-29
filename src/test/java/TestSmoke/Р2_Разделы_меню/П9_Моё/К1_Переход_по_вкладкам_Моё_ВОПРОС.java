package TestSmoke.Р2_Разделы_меню.П9_Моё;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К1_Переход_по_вкладкам_Моё_ВОПРОС extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Переход по вкладкам Моё")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void clickOnTheMyTabs() {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToTailCardFilm();
        cardFilm.paymentFilmAtEst();
        headerMenu.goToMyPageFavorites();
        pageCMS.deleteAccount();
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
