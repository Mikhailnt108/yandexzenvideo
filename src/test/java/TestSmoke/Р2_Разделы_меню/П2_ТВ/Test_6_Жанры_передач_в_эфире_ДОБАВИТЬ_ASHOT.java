package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_6_Жанры_передач_в_эфире_ДОБАВИТЬ_ASHOT extends TestBase {
    @Test
    public void genresTvProgramInAir() {
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.checkСhannelsСorrespondGenres();
    }
}
