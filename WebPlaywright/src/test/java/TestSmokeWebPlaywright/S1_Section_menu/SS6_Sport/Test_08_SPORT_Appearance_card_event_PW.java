package TestSmokeWebPlaywright.S1_Section_menu.SS6_Sport;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuitePwNonAdWeb#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_08_SPORT_Appearance_card_event_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "6. Sport")
    @DisplayName(value = "08_SPORT_Appearance_card_event")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("54027914")
    @Test
    @Tag("SuitePwNonAdWeb#0")
    public void SPORT_Appearance_card_event() throws Exception {
        headerMenuPW.goToSportPage();
        sportPagePW.checkElementsBlockSportsEvents();
    }
}
