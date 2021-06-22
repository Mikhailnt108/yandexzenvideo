package TestSmoke.Р1_Авторизация_и_регистрация_FRESH_от_16_04_2021;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


public class Test_05_Восстановление_пароля extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Авторизация и регистрация")
    @DisplayName(value = "Восстановление пароля")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(3)
    @TestRailCase(id="6")
    public void passwordRecovery() {
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.logOut();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputPassword();
        headerMenu.clickToButtonForgetPassword();
        headerMenu.checkOpenPopUpNewPasswordForMF();
        headerMenu.checkElementsPopUpNewPasswordForMF();
        headerMenu.inputLessThanSixSimbolPassword("111");
        headerMenu.checkDisabledButtonComeIn();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.checkActiveButtonComeIn();
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        headerMenu.checkElementsPopUpInputCode();
        headerMenu.inputInvalidCodeСonfirmation("1234");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkErrorMessage1();
        headerMenu.inputInvalidCodeMoreThanThreeTimes();
        headerMenu.checkElementsPopUpForInvalidCodeMoreThanThreeTimes();
        headerMenu.clickToButtonGetNewCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectAfterForgetPassword();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowRegistation() {
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
