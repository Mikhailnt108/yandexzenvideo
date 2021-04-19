package TestSmoke.старые_кейсы.авторизация_и_регистрация;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


public class Old_06_Авторизация_из_карточки_Передачи extends TestBase {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "Авторизация из карточки Передачи")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void loginFromCardTvProgram() {
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToTabShop();
        packagesPage.checkOpenShopPage();
        packagesPage.clickToTabTvСhannelInMenuShopPage();
        packagesPage.clickToTailCardPackageTvChannel();
        cardPackage.checkOpenCardPackageTvChannel();
        cardPackage.clickTailCardChannel();
        cardTvChannel.checkOpenCardTvChannel();
        cardTvChannel.clickTvProgramInCardChannel();
        cardTvProgram.checkOpenCardTvProgram();
        cardTvProgram.clickPaymentButtonInCardTvProgram();
        flowAutorisation();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowAutorisation() {
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputPassword();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        //headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
