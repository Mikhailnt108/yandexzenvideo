package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Test_07_NIL_REG_AUTH_Registered_without_password_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "7. NIL_REG_AUTH_Registered_without_password")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_REG_AUTH_Registered_without_password() throws InterruptedException {
        // ввести номер прозрачно зарегистрированный в МФТВ на телефоне:
        headerMenuPW.goToNilPage();
        headerMenuPW.clickToEnter();
        authPagePW.inputLogin("+7 926 020 50 27");
        authPagePW.clickOnButtonNextAndCheckOpenFormCreatePassword();
        authPagePW.checkElementsPageAuthFormCreatePassword();
        authPagePW.checkInputValidPasswordRegist("111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
