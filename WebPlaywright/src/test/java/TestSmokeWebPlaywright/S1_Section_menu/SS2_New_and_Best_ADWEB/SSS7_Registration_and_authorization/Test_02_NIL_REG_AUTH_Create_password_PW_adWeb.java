package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_ADWEB.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class Test_02_NIL_REG_AUTH_Create_password_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "2. NIL_REG_AUTH_Create_new_password")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_REG_AUTH_Create_password() throws InterruptedException, IOException {
        headerMenuPW.goToNilPage();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 001 01 01");
        authPagePW.clickOnButtonNextAndCheckOpenFormCreatePassword();
        authPagePW.checkElementsPageAuthFormCreatePassword();
        authPagePW.clickOnButtonBackAndCheckOpenFormInputPhone();
        authPagePW.inputLogin("+7 926 001 01 01");
        authPagePW.clickOnButtonNextAndCheckOpenFormCreatePassword();
        authPagePW.clickOnOffertaAndCheckOpenDoc();
        headerMenuPW.goToNilPage();
        headerMenuPW.clickToEnter();
        authPagePW.inputLogin("+7 926 001 01 01");
        authPagePW.clickOnButtonNextAndCheckOpenFormCreatePassword();
        authPagePW.inputPasswordRegisterLessThanSixSimbol("111");
        authPagePW.unCheckBoxAndInputPasswordSixSimbols("111111");
        authPagePW.checkBoxAndInputPasswordSixSimbols("111111");
        authPagePW.checkImagePageAuthFormCreatePassword();
        authPagePW.clickOnButtonNextAndCheckOpenFormInputCode();
    }
}
