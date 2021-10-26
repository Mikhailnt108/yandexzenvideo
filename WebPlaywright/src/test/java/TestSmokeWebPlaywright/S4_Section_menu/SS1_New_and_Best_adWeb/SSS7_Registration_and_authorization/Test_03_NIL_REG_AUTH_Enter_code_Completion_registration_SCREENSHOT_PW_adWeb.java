package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_03_NIL_REG_AUTH_Enter_code_Completion_registration_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "3. NIL_REG_AUTH_Enter_code_Completion_registration")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_REG_AUTH_Enter_code_Completion_registration() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        headerMenuPW.clickToEnter();
        authPagePW.inputLogin("+7 926 001 01 01");
        authPagePW.clickOnButtonNextAndCheckOpenFormCreatePassword();
        authPagePW.inputValidPasswordRegister("111111");
        authPagePW.clickOnButtonNextAndCheckOpenFormInputCode();
        authPagePW.checkElementsPageAuthFormInputCode();
        authPagePW.checkTimerFormInputCode();
        authPagePW.clickOnButtonBackAndCheckOpenFormInputPassword();
        authPagePW.checkInputInvalidCodeInFormInputCode("+7 926 001 01 01", "111111", "1234");
        authPagePW.checkImageFormInputCodeForInvalidCode();
        headerMenuPW.goToNilPage();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        authPagePW.checkFinishTimerFormInputCode("+7 926 019 21 44", "111111");
        authPagePW.clickResendCodeAndCheckСompletionAuth();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
