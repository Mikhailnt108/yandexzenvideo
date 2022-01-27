package TestSmokeWebDriver.S1_Sections_menu.SS2_Films;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_08_FILMS_Rent_film_with_discount extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "3. Films")
    @DisplayName(value ="Rent_film_with_discount")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31546471")
    @Test
    @Tag("SuiteWD#1")
    public void rentFilmWithDiscount() throws Exception {
        headerMenu.goToFilmsPage();
        filmsPage.clickToSecondTailCardFilm();
        cardFilm.checkOpenCardFilm();
        pageCMS.createPriseEstOrRent2WithDiscount();
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToSecondTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkStikerDiscount();
        cardFilm.checkPriseRent2Discount();
        cardFilm.paymentFilmAtRent2Discount();
        cardFilm.checkUnavailabilityStikerDiscount();
        cardFilm.startVideoPleer();
        pageCMS.deleteDiscount();
        pageCMS.deleteAccountMF("79260192144");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
