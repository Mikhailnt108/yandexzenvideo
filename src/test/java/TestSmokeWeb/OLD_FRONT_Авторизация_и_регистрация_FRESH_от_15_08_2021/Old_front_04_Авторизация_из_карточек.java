package TestSmokeWeb.OLD_FRONT_Авторизация_и_регистрация_FRESH_от_15_08_2021;

import base.TestBaseWebDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Old_front_04_Авторизация_из_карточек extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "4. Авторизация из карточек")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
//    @TmsLink("31541982")
    public void loginFromCardFilm() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToTabFilms();
        filmsPage.checkOpenFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.clickPaymentButtonInCardFilm();
        flowAutorisation();
        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToTabSerials();
        serialsPage.checkOpenSerialsPage();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
        cardSerial.clickPaymentButtonInCardSerial();
        flowAutorisation();
        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToTabShop();
        packagesPage.checkOpenShopPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToTailCardPackageSerials();
        cardPackage.checkOpenCardPackageSerials();
        cardPackage.clickOnPaymentButtonInCardPackageForGuest();
        flowAutorisation();
        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToTabShop();
        packagesPage.checkOpenShopPage();
        packagesPage.clickToTabTvСhannelInMenuShopPage();
        headerMenu.refreshPage();
        packagesPage.clickToFirstTailCardPackage();
        cardPackage.checkOpenCardPackageTvChannel();
//        cardPackage.scrollCardPackage();  // для ноутбука
        cardPackage.clickOnPaymentButtonInCardPackageForGuest();
        flowAutorisation();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin(" 9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF(" 9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }

    private void flowAutorisation() {
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin(" 9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputPassword();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
