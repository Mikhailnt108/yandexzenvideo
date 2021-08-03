package TestSmoke.Р4_Разделы_меню.П11_Промокод;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class Test_01_Общий_вид_окна_Ввести_промокод_SCREENSHOT_VRT_Playwright_FRESH extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "11. Промокод")
    @DisplayName(value ="Общий вид окна Ввести_промокод (скриншоты)")
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
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
