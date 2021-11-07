package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@ResourceLock(value = "adWebSuitePW#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_05_NIL_REG_AUTH_Invalid_password_Limit_on_number_inputs_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "5. NIL_REG_AUTH_Invalid_password_Limit_on_number_inputs")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_REG_AUTH_Invalid_password_Limit_on_number_inputs() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        headerMenuPW.goToNilPage();
        flowRegistation();
        authPagePW.loginOut();
        authPagePW.checkOpenPageAuthFormInputPassword("+7 926 019 21 44");
        authPagePW.checkInputInvalidPasswordAuth("123456");
        authPagePW.clickOnButtonEnterForInvalidPasswordAndCheckElements();
        authPagePW.checkImageInputInvalidPasswordAuth();
        authPagePW.checkInputThreeTimesInvalidPasswordAuth("+7 926 019 21 44","123456");
        authPagePW.checkImageInputThreeTimesInvalidPasswordAuth();
        authPagePW.waitReEnterPasswordAndCheckValidPassword("111111");
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
