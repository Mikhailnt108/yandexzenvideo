package TestSmoke.Р1_Авторизация_и_регистрация_FRESH_от_16_04_2021;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


public class Test_03_Авторизация_через_кнопку_Вход extends TestBase {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "Авторизация через кнопку 'Вход'")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id="4")
    public void loginFromHeaderMenu() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegister();
        headerMenu.logOut();
        flowAuthorization();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowAuthorization() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.checkElementsPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.checkActiveButtonNext();
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputPassword();
        headerMenu.checkElementsPopUpInputPassword();
        headerMenu.inputLessThanSixSimbolPassword("111");
        headerMenu.checkDisabledButtonComeIn();
        headerMenu.inputInvalidPassword("123456");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkErrorMessage2();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.checkActiveButtonComeIn();
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }

    private void flowRegister() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }

}