package TestSmoke.Р0_Разделы_меню_ТВ.П1_ТВ_FRESH;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;

public class Test_03_Расписание_канала_FRESH_от_29_06_21 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value ="Расписание_канала")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void openScheduleChannel() throws IOException, InterruptedException {
        headerMenu.goToTvPage();
        tvPage.checkOpenTvPageTabScheduleTv();
        tvPage.clickShowAllToTailTvChannelAndCheckOpenCardTvChannel();
    }
}
