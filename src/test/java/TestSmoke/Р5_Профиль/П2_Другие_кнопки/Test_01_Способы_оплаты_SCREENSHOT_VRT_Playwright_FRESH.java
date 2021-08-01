package TestSmoke.Р5_Профиль.П2_Другие_кнопки;

import base.TestBasePlaywright;
import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_01_Способы_оплаты_SCREENSHOT_VRT_Playwright_FRESH extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Другие кнопки")
    @DisplayName(value ="Способы оплаты (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void paymentMethod() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        flowRegistation();
        headerMenuPW.openSubsectionPaymentMethod();
        headerMenuPW.checkImagePagePaymentMethod();
        headerMenuPW.deleteAccountMF("79260192144");
    }

    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMF();
    }
}
