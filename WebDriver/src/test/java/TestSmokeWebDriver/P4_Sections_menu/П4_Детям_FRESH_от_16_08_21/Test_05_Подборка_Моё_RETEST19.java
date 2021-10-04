package TestSmokeWebDriver.P4_Sections_menu.П4_Детям_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_05_Подборка_Моё_RETEST19 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="5. Подборка Моё")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#4")
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
        pageCMS.deleteAccountMF("79250110166");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9250110166");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9250110166", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79250110166");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
