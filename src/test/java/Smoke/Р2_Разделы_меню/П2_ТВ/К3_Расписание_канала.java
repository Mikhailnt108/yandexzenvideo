package Smoke.Р2_Разделы_меню.П2_ТВ;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К3_Расписание_канала extends TestBase {
    @Test
    public void openScheduleChannel() {
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.checkСhannelsСorrespondGenres();
        cardTvChannel.checkOpenScheduleOnCardTvChannel();
    }
}
