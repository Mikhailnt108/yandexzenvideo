package TestSmokeWebPlaywright.S1_Section_menu.SS6_Sport;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuitePW#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_SPORT_Composition_and_appearance_collections_sports_events_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "6. Sport")
    @DisplayName(value = "04_SPORT_Composition_and_appearance_collections_sports_events")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePW#4")
    public void SPORT_Composition_and_appearance_collections_sports_events() throws Exception {
        headerMenuPW.goToSportPage();
    }
}
