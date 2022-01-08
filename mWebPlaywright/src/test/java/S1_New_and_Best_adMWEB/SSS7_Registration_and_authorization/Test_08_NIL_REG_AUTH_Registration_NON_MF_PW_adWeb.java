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
public class Test_08_NIL_REG_AUTH_Registration_NON_MF_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "8. NIL_REG_AUTH_Registration_non_MF")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_REG_AUTH_Registration_non_MF() throws InterruptedException, IOException {
        headerMenuPW.goToNilPage();
        flowRegistationNonMF();
    }
    private void flowRegistationNonMF() throws InterruptedException, IOException {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.tapOnProfileNonAdWeb();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdMWeb("+7 926 118 49 72");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPopUpInputEmail("+7 926 118 49 72");
        authPagePW.checkElementsPageAuthFormInputEmail();
        authPagePW.checkImagePageAuthFormInputEmail();
        authPagePW.clickOnButtonBackAndCheckOpenFormInputPhone();
        headerMenuPW.tapToNextNonAdWeb();
        authPagePW.checkInputInvalidEmailInFormInputEmail("mail.ru");
        headerMenuPW.checkInputValidEmailInPopUpInputEmail("ispolnitel1mt@yandex.ru");
        headerMenuPW.tapToNextNonAdWeb();
        authPagePW.inputValidPasswordRegister("111111");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.copyPasteCodMsisdnForNonMF("79261184972");
        headerMenuPW.tapToComeInNonAdMWeb("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
