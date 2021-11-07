package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_ADWEB.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_01_NIL_REG_AUTH_Enter_your_phone_number_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1. NIL_REG_AUTH_Enter_your_phone_number")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_REG_AUTH_Enter_your_phone_number() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnButtonEnterAndCheckOpenPageAuth();
        authPagePW.checkElementsPageAuthFormInputPhone();
        authPagePW.checkImagePageAuth();
        authPagePW.clickOnButtonCloseAuthAndCheckOpenNil();
        nilPagePW.clickOnButtonEnterAndCheckOpenPageAuth();
        authPagePW.inputValidNumberAndCheckActiveButtonNext("+7 926 001 01 01");
        authPagePW.checkImagePageAuthWithValidNumber();
        authPagePW.clickOnButtonNextAndCheckOpenFormCreatePassword();
    }
}
