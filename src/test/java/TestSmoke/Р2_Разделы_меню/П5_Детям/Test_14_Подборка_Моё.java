package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_14_Подборка_Моё extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "14. Подборка Моё")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void collectionOfMy() {
        headerMenu.goToKidsPage();
        flowRegistation();
        kidsPage.clickToTailCardFilm();
        cardFilm.paymentFilmAtEst();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.paymentFilmAtEst();
        headerMenu.goToKidsPage();
        kidsPage.clickToHeaderCollectionOfMy();
        collectionPage.checkCollectionOfMy();
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
