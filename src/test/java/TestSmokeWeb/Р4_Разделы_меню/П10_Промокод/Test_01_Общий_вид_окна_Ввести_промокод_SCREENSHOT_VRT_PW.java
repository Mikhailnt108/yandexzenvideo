package TestSmokeWeb.Р4_Разделы_меню.П10_Промокод;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock("Suite#3")
public class Test_01_Общий_вид_окна_Ввести_промокод_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "11. Промокод")
    @DisplayName(value ="1. Общий вид окна Ввести_промокод (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkViewOfPromoCodePopUp() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        headerMenuPW.clickToButtonPromo();
        flowRegistation();
        headerMenuPW.clickToButtonPromo();
        headerMenuPW.checkOpenPopUpPromoCode();
        headerMenuPW.checkElementsPopUpPromoCode();
        headerMenuPW.checkImagePopUpPromoCode();
    }
    private void flowRegistation() {
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
