package S1_Section_menu.SS2_New_and_Best_adWEB.SSS7_Registration_and_authorization;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "adWebSuitePW#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_07_NIL_REG_AUTH_Registered_without_password_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "7. NIL_REG_AUTH_Registered_without_password")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_REG_AUTH_Registered_without_password() throws InterruptedException {
        // ввести номер прозрачно зарегистрированный в МФТВ на телефоне:
        headerMenuPW.goToNilPage();
        headerMenuPW.clickToProfile();
        authPagePW.inputLoginAdmWeb("+7 926 019 21 44");
        authPagePW.clickOnButtonNextAndCheckOpenFormCreatePassword();
        authPagePW.checkElementsPageAuthFormCreatePassword();
        authPagePW.checkInputValidPasswordRegist("111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdWeb("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
