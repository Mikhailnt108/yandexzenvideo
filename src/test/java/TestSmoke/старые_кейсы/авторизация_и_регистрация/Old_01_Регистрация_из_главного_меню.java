package TestSmoke.старые_кейсы.авторизация_и_регистрация;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


public class Old_01_Регистрация_из_главного_меню extends TestBase {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "Регистрация из главного меню")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    public void registerFromHeaderMenu() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForCaseRegistrationMF("9260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
