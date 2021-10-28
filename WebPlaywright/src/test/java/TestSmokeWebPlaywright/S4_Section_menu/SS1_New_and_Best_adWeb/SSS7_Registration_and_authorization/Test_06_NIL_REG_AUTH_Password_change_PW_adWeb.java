package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_06_NIL_REG_AUTH_Password_change_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "6. NIL_REG_AUTH_Password_change")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_REG_AUTH_Password_change() throws InterruptedException, IOException {
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        authPagePW.loginOut();
        authPagePW.checkOpenPageAuthFormInputPassword("+7 926 019 21 44");
        authPagePW.clickOnButtonForgotPasswordInFormInputPhone();
        authPagePW.clickOnButtonChangePassAndCheckFormCreateNewPassword();
        authPagePW.checkElementsPageAuthFormCreateNewPassword();
        authPagePW.checkImagePageAuthFormCreateNewPassword();
        authPagePW.checkInputNewValidPasswordAuth("111111");
        authPagePW.clickOnButtonNextAndCheckOpenFormInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
    private void flowRegistationMF() {
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
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
