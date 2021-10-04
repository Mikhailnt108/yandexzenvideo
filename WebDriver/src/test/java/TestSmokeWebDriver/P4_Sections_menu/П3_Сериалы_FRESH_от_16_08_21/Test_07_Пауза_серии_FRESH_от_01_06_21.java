package TestSmokeWebDriver.P4_Sections_menu.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_07_Пауза_серии_FRESH_от_01_06_21 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Пауза серии")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#4")
    public void pauseSeries() throws Exception {
        headerMenu.goToSerialsPage();
        flowRegistation();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
        cardSerial.paymentSerialAtSubs();
        cardSerial.clickToPauseVideoPleer();
        cardSerial.clickToPlayVideoPleer();
        cardSerial.clickToSpaceToVideoPleer();
        cardSerial.clickToLeftButtonMouseToVideoPleer();
        pageCMS.deleteAccountMF("79250110166");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9250110166");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9250110166", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79250110166");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
