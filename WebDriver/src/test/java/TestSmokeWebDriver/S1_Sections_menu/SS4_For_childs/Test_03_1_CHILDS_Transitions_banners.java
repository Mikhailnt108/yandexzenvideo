package TestSmokeWebDriver.S1_Sections_menu.SS4_For_childs;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_1_CHILDS_Transitions_banners extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "5. Childs")
    @DisplayName(value ="Transitions_banners")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("39192987")
    @Test
    @Tag("SuiteWD#2")
    public void goToBanner() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkElementsBannersCarousel();
        kidsPage.switchingFromBannerToCardFilm();
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardSerial();
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardTvChannel();
    }
}
