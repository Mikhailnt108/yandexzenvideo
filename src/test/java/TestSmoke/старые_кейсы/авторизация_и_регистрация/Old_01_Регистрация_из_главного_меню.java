package TestSmoke.старые_кейсы.авторизация_и_регистрация;

import base.TestBaseWebDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Old_01_Регистрация_из_главного_меню extends TestBaseWebDriver {

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
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
