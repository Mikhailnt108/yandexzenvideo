package TestSmoke.Р3_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_03_Расписание_канала_Ashot_FRESH_от_06_05_21_нужен_ли_этот_кейс extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Жанры программы передач")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void openScheduleChannel() throws IOException, InterruptedException {
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabInRecording();
        tvPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        cardTvChannel.checkImageDifferCardTvChannelForUnauthorized();
    }
}
