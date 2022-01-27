package TestSmokeWebPlaywright.S1_Section_menu.SS6_Sport;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "SuitePwNonAdWeb#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_SPORT_Appearance_section_SCREENSHOT_PW_DONE extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "6. Sport")
    @DisplayName(value = "01_SPORT_Appearance_section")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("31546608")
    @Test
    @Tag("SuitePwNonAdWeb#0")
    public void SPORT_Appearance_section() throws IOException, InterruptedException {
        headerMenuPW.goToSportPage();
        sportPagePW.checkElementsOnPageSport();
        sportPagePW.checkImageSportPageScrollForGuest();
        sportPagePW.checkImageFooterSportPageForGuest();
        headerMenuPW.goToSportPage();
        sportPagePW.scrollCollectionSportChannelsToRightAndLeft();
        sportPagePW.scrollCollectionSportVodsToRightAndLeft();
    }
}
