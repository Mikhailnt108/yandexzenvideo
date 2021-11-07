package TestSmokeWebPlaywright.S1_Section_menu.SS6_Sport;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

public class Test_02_SPORT_Operation_filters_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "6. Спорт")
    @DisplayName(value = "2. Работа фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("adWebSuitePW#4")
    public void operationFiltersPageSport() throws Exception {
        headerMenuPW.goToSportPage();
        sportPagePW.checkImageBlockFastFiltersSportPageForGuest();
        sportPagePW.chooseFilterSportAndCheckTvChannels();
        sportPagePW.chooseFilterSportAndCheckTvProgram();
    }
}
