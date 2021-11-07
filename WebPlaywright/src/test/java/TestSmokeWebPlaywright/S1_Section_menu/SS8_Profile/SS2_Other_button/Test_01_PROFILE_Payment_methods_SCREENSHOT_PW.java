package TestSmokeWebPlaywright.S1_Section_menu.SS8_Profile.SS2_Other_button;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "SuitePW#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_PROFILE_Payment_methods_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "8. Profile_Other_button")
    @DisplayName(value ="01_PROFILE_Payment_methods_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePW#4")
    public void PROFILE_Payment_methods_SCREENSHOT() throws IOException, InterruptedException {
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
        authPagePW.inputLogin("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}
