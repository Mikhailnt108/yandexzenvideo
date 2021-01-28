package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_3_Расписание_канала extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Расписание канала")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void openScheduleChannel() {
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.checkСhannelsСorrespondGenres();
        cardTvChannel.checkOpenScheduleOnCardTvChannel();
    }
}
