package TestSmokeWebPlaywright.S1_Section_menu.SS6_Sport;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Test_02_SPORT_Operation_filters_PW_DONE extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "6. Sport")
    @DisplayName(value = "2. Operation_filters")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void operationFiltersPageSport() throws Exception {
        headerMenuPW.goToSportPage();
        sportPagePW.chooseFilterSportAndCheckTvChannels();
        sportPagePW.chooseFilterSportAndCheckTvProgram();
    }
}