package TestSmoke.Р1_Авторизация_и_регистрация;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Test_4_Авторизация_из_карточки_Пакета_Каналов extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "Авторизация из карточки Пакета Каналов")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void loginFromCardPackageTvChannel() {
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToTabPackages();
        packagesPage.checkOpenPackagesPage();
        packagesPage.clickToTabTvСannelInMenuPackagesPage();
        packagesPage.clickToTailCardPackageTvChannel();
        cardPackage.checkOpenCardPackageTvChannel();
        cardPackage.clickPaymentButtonInCardPackage();
        flowAutorisation();
        pageCMS.deleteAccount();
    }

    private void flowAutorisation() {
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameInputPassword();
        headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        //headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
