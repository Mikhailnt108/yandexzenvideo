package TestSmoke.Р1_Авторизация_и_регистрация;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


public class Test_04_Авторизация_из_карточек_FRESH extends TestBase {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "Авторизация из карточек")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void loginFromCardFilm() {
        headerMenu.goToNilPage();
        //flowRegistation();
        //headerMenu.logOut();
//        headerMenu.checkNotLoggedIsCorrect();
//        headerMenu.clickToTabFilms();
//        filmsPage.checkOpenFilmsPage();
//        filmsPage.clickToTailCardFilm();
//        cardFilm.checkOpenCardFilm();
//        cardFilm.clickPaymentButtonInCardFilm();
//        flowAutorisation();
//        headerMenu.logOut();
//        headerMenu.checkNotLoggedIsCorrect();
//        headerMenu.clickToTabSerials();
//        serialsPage.checkOpenSerialsPage();
//        serialsPage.clickToTailCardSerial();
//        cardSerial.checkOpenCardSerial();
//        cardSerial.clickPaymentButtonInCardSerial();
//        flowAutorisation();
//        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToTabShop();
        packagesPage.checkOpenShopPage();
        packagesPage.clickToTabSerialsInMenuShopPage();
        packagesPage.clickToTailCardPackageSerials();
        cardPackage.checkOpenCardPackageSerials();
        cardPackage.clickPaymentButtonInCardPackage();
        flowAutorisation();
        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToTabShop();
        packagesPage.checkOpenShopPage();
        packagesPage.clickToTabTvСhannelInMenuShopPage();
        packagesPage.clickToTailCardPackageTvChannel();
        cardPackage.checkOpenCardPackageTvChannel();
        cardPackage.clickPaymentButtonInCardPackage();
        flowAutorisation();
        pageCMS.deleteAccountMF();
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }

    private void flowAutorisation() {
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputPassword();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
