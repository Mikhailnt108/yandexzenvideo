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
public class Test_06_CHILDS_Collection_favorites extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "5. Childs")
    @DisplayName(value ="Collection_favorites")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("31542080")
    @Test
    @Tag("SuiteWD#2")
    public void collectionOfFavorites() throws InterruptedException {
        headerMenu.goToKidsPage();
        flowRegistation();
        kidsPage.clickToFirstTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.clickButtonFavorites();
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardSerial();
        cardSerial.clickButtonFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToSecondTailCardFilm();
        cardFilm.clickButtonFavorites();
        headerMenu.goToKidsPage();
        kidsPage.clickToHeaderCollectionOfFavorites();
        collectionsPage.checkCollectionOfFavorites();
        pageCMS.deleteAccountMF("79250110166");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9250110166");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("79250110166", "111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79250110166");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
