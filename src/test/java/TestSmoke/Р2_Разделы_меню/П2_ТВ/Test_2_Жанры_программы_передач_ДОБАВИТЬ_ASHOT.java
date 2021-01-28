package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_2_Жанры_программы_передач_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Жанры программы передач")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void genresTvProgram() {
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.checkСhannelsСorrespondGenres();

    }

}
