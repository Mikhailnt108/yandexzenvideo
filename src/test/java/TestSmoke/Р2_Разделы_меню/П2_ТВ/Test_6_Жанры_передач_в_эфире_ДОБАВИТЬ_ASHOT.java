package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_6_Жанры_передач_в_эфире_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "6. Жанры передач в эфире")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void genresTvProgramInAir() {
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.checkСhannelsСorrespondGenres();
    }
}
