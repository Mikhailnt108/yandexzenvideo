package TestSmokeWebDriver.S1_Sections_menu.SS9_Profile.П1_Акции.пп0_Акции;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuiteWD#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_АКЦИИ_Переход_в_раздел_Фильмы_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="2. Переход в раздел Фильмы")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#4")
    public void goToMoviesPromoSection() throws InterruptedException {
        headerMenu.goToNilPage();
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
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260205027");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
