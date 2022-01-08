package S1_New_and_Best_adMWEB.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_NIL_REG_AUTH_Enter_code_Completion_registration_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "3. NIL_REG_AUTH_Enter_code_Completion_registration")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_REG_AUTH_Enter_code_Completion_registration() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        headerMenuPW.tapOnProfileNonAdWeb();
        authPagePW.inputLoginAdMWeb("+7 926 001 01 01");
        authPagePW.clickOnButtonNextAndCheckOpenFormCreatePassword();
        authPagePW.inputValidPasswordRegister("111111");
        authPagePW.clickOnButtonNextAndCheckOpenFormInputCode();
        authPagePW.checkElementsPageAuthFormInputCode();
        authPagePW.checkTimerFormInputCode();
        authPagePW.clickOnButtonBackAndCheckOpenFormInputPassword();
        authPagePW.checkInputInvalidCodeInFormInputCode("+7 926 001 01 01", "111111", "1234");
        authPagePW.checkImageFormInputCodeForInvalidCode();
        headerMenuPW.goToNilPage();
        headerMenuPW.tapOnProfileNonAdWeb();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdMWeb("+7 926 019 21 44");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPageCreatePasswordAdMWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        authPagePW.checkFinishTimerFormInputCode("+7 926 019 21 44", "111111");
        authPagePW.clickResendCodeAndCheckСompletionAuth();
        headerMenuPW.copyPasteCodMsisdnForAdMWeb("79260192144");
        headerMenuPW.tapToComeInNonAdMWeb("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
