package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_3_Расписание_канала extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Жанры программы передач")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void openScheduleChannel() {
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.checkСhannelsСorrespondGenres();
        cardTvChannel.checkOpenScheduleOnCardTvChannel();
    }
}
