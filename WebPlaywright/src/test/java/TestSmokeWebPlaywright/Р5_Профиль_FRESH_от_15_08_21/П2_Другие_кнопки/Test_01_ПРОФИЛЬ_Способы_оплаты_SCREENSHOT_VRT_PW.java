package TestSmokeWebPlaywright.Р5_Профиль_FRESH_от_15_08_21.П2_Другие_кнопки;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "Suite#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_ПРОФИЛЬ_Способы_оплаты_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Другие кнопки")
    @DisplayName(value ="Способы оплаты (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#3")
    public void paymentMethod() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        headerMenuPW.openSubsectionPaymentMethod();
        headerMenuPW.checkImagePagePaymentMethod();
        headerMenuPW.deleteAccountMF("79260205027");
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
