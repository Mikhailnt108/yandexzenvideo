package TestSmoke.Р4_Разделы_меню.П2_ТВ;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;

public class Test_03_Расписание_канала_Ashot_FRESH_от_06_05_21_D_КЕЙС_НЕАКТУАЛЕН extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Расписание_канала")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id = "25")
    public void openScheduleChannel() throws IOException, InterruptedException {
        headerMenu.goToTvPage();
        tvPage.checkOpenTvPageTabScheduleTv();
        tvPage.clickOnTabInRecording();
        tvPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        cardTvChannel.checkImageDifferCardTvChannelForUnauthorized();
    }
}
