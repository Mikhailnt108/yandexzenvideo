package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@ResourceLock(value = "adWebSuitePW#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_09_NIL_REG_AUTH_Authorization_Internet_slow_NC_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "9. NIL_REG_AUTH_Authorization_Internet_slow")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("53962605")
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_REG_AUTH_Authorization_Internet_slow() throws IOException, InterruptedException, ExecutionException, TimeoutException, SQLException {
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
    private void flowRegistationMF() throws SQLException {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginAdWeb("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForAdWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.inputCodeMsisdnFromDB("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
