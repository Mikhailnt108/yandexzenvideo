package TestSmokeWebDriver.S1_Sections_menu.SS4_For_childs;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_05_CHILDS_Collection_MY extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "5. Childs")
    @DisplayName(value ="Collection_MY")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#2")
    public void collectionOfMy() throws InterruptedException {
        headerMenu.goToKidsPage();
        flowRegistation();
        kidsPage.clickToFirstTailCardFilm();
        cardFilm.paymentFilmAtEst();
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardSerial();
        cardSerial.paymentSerialAtSubs();
        headerMenu.goToFilmsPage();
        filmsPage.clickToSecondTailCardFilm();
        cardFilm.paymentButtonRent2InCardFilm();
        headerMenu.goToKidsPage();
        kidsPage.clickToHeaderCollectionOfMy();
        collectionsPage.checkCollectionOfMy();
        pageCMS.deleteAccountMF("79250110166");
    }
    private void flowRegistation() throws InterruptedException {
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
