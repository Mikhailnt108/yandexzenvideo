package TestSmokeWebDriver.S1_Sections_menu.SS3_Serials;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_SERIALS_Transition_on_card_serial extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "4. Serials")
    @DisplayName(value ="Transition_on_card_serial")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31542063")
    @Test
    @Tag("SuiteWD#2")
    public void GoToCardSerial() throws InterruptedException {
        headerMenu.goToSerialsPage();
        serialsPage.switchingFromBannerToCardSerial();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToSerialsPage();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToSerialsPage();
        serialsPage.clickToLinkAllOnCollectionBlock();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
    }
}
