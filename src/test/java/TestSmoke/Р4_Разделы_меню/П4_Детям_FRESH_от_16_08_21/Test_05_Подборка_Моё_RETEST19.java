package TestSmoke.Р4_Разделы_меню.П4_Детям_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#2")
public class Test_05_Подборка_Моё_RETEST19 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="5. Подборка Моё")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void collectionOfMy() {
        headerMenu.goToKidsPage();
        flowRegistation();
        kidsPage.clickToTailCardFilm();
        cardFilm.paymentButtonRent2InCardFilm();
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardSerial();
        cardSerial.paymentSerialAtSubs();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.paymentButtonRent2InCardFilm();
        headerMenu.goToKidsPage();
        kidsPage.clickToHeaderCollectionOfMy();
        collectionsPage.checkCollectionOfMy();
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
