package TestSmoke.Р4_Разделы_меню.П4_Детям_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#2")
public class Test_06_Подборка_Избранное_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Подборка Избранное")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void collectionOfFavorites() throws InterruptedException {
        headerMenu.goToKidsPage();
        flowRegistation();
        kidsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.clickButtonFavorites();
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardSerial();
        cardSerial.clickButtonFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.clickButtonFavorites();
        headerMenu.goToKidsPage();
        kidsPage.clickToHeaderCollectionOfFavorites();
        collectionsPage.checkCollectionOfFavorites();
        pageCMS.deleteAccountMF("79260172279");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260172279");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260172279", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260172279");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
