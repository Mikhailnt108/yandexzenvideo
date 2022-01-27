package TestSmokeWebDriver.S1_Sections_menu.SS9_Profile.SSS1_Promo.SSSS1_Promo_base;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_PROMO_Transition_on_section_films extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Profile")
    @Story(value = "2. Promo")
    @DisplayName(value ="Transition_on_section_films")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31542006")
    @Test
    @Tag("SuiteWD#4")
    public void goToMoviesPromoSection() throws InterruptedException {
        headerMenu.goToFilmsPage();
        flowRegistation();
        pageCMS.chooseBundleInternetMFromMsisdn("79260205027");
        headerMenu.closePopUpNotif();
        headerMenu.openSubsectionPromo();
        promoPage.clickButtonGoToFilms();
        filmsPage.checkFilmsPromo();
        pageCMS.chooseBundleNotSelected("79260205027");
        pageCMS.deleteAccountMF("79260205027");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260205027");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260205027", "111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260205027");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
