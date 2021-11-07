package TestSmokeWebDriver.S1_Sections_menu.SS7_MY;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_Переход_на_страницу_Моё_Избранное_FRESH_от_13_06_21 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="Переход на страницу Моё_Избранное")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void goToFavoritesPage() throws InterruptedException {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.clickButtonFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm2FromAll();
        cardFilm.clickButtonFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm3FromAll();
        cardFilm.clickButtonFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm4FromAll();
        cardFilm.clickButtonFavorites();
        myPage.goToMyPageFavorites();
        myPage.goToCollectionFavoritesPage();
        pageCMS.deleteAccountMF("79260172279");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
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
