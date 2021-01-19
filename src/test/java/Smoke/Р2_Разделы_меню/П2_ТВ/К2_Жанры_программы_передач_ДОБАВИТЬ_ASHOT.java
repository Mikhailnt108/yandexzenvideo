package Smoke.Р2_Разделы_меню.П2_ТВ;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Жанры_программы_передач_ДОБАВИТЬ_ASHOT extends TestBase {
    @Test
    public void genresTvProgram() {
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.checkСhannelsСorrespondGenres();

    }

}
