package TestSmokeWebPlaywright.Р4_Разделы_меню.П5_Спорт_В_РАБОТЕ;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

public class Test_02_Работа_фильтров_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "6. Спорт")
    @DisplayName(value = "2. Работа фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Suite#2")
    public void operationFiltersPageSport() throws Exception {
        headerMenuPW.goToSportPage();
        sportPagePW.checkImageBlockFastFiltersSportPageForGuest();
        sportPagePW.chooseFilterSportAndCheckTvChannels();
        sportPagePW.chooseFilterSportAndCheckTvProgram();
    }
}
