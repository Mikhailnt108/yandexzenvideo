package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_ADWEB.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_04_NIL_REG_AUTH_Enter_password_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "4. NIL_REG_AUTH_Enter_password")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_REG_AUTH_Input_password() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        flowRegistation();
        authPagePW.loginOut();
        authPagePW.checkOpenPageAuthFormInputPassword("+7 926 019 21 44");
        authPagePW.checkElementsPageAuthFormInputPassword();
        authPagePW.clickOnButtonBackAndCheckOpenFormInputPhone();
        authPagePW.checkOpenPageAuthFormInputPassword("+7 926 019 21 44");
        authPagePW.clickOnButtonForgotPasswordInFormInputPhone();
        authPagePW.checkElementsPageAuthFormChangePassword();
        authPagePW.checkImagePageAuthFormChangePassword();
        authPagePW.clickOnButtonNoAndCheckOpenFormInputPassword();
        authPagePW.checkInputValidPasswordAuth("111111");
        authPagePW.checkImageInputValidPasswordAuth();

    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
