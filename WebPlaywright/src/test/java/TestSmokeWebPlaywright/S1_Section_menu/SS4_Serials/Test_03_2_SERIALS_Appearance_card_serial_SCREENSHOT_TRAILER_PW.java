package TestSmokeWebPlaywright.S1_Section_menu.SS4_Serials;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuitePwNonAdWeb#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_2_SERIALS_Appearance_card_serial_SCREENSHOT_TRAILER_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "4. Serials")
    @DisplayName(value = "03_2_SERIALS_Appearance_card_serial_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void SERIALS_Appearance_card_serial_SCREENSHOT_TRAILER() throws Exception {
        headerMenuPW.goToSerialsPage();
        serialsPagePW.clickToTailCardSerial();
//        cardSerialPW.checkStartTrailerPlayer();
        cardSerialPW.checkImageCardSerialForGuest();
        flowRegistationMF();
        headerMenuPW.goToSerialsPage();
        serialsPagePW.clickToTailCardSerial();
        cardSerialPW.subscribeToPackageSerials();
//        cardSerialPW.checkStartTrailerPlayer();
        cardSerialPW.checkImageCardSerialForUser();
        headerMenuPW.deleteAccountMF("79260205027");
    }

    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginNonAdWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForNonAdWeb("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}