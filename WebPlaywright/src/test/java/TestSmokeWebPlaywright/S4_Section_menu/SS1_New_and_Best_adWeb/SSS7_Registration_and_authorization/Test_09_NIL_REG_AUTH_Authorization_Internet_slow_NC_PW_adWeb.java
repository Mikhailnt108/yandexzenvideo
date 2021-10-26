package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Test_09_NIL_REG_AUTH_Authorization_Internet_slow_NC_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "9. NIL_REG_AUTH_Authorization_Internet_slow")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_REG_AUTH_Authorization_Internet_slow() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        headerMenuPW.stopFiddlerSlowNetwork();
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        authPagePW.loginOut();
        headerMenuPW.startFiddlerSlowNetwork();
        authPagePW.checkOpenPageAuthFormInputPassword("+7 926 019 21 44");
        authPagePW.checkInputValidPasswordAuth("111111");
        headerMenuPW.clickToComeIn("Войти");
        authPagePW.checkElementsPageAuthFormSuccessfullyAuth();
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
