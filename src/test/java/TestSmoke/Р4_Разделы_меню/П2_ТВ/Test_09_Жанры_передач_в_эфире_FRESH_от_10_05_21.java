package TestSmoke.Р4_Разделы_меню.П2_ТВ;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_09_Жанры_передач_в_эфире_FRESH_от_10_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Жанры передач в эфире")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id = "30")
    public void genresTvProgramInAir() throws Exception {
        headerMenu.goToTvPage();
        tvPage.checkOpenTvPageTabScheduleTv();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.clickOnTabHD();
        tvPage.checkColorButtonChooseGenre();
        tvPage.checkGenreHDTvProgramInAir();
        tvPage.clickOnTabForKids();
        tvPage.checkColorButtonChooseGenre();
        tvPage.checkGenreForKidsTvProgramInAir();
        tvPage.clickOnTabInRecording();
        tvPage.checkColorButtonChooseGenre();
        tvPage.checkGenreInRecordingTvProgramInAir();
        tvPage.clickOnTabKino();
        tvPage.checkColorButtonChooseGenre();
        tvPage.checkGenreKinoTvProgramInAir();
    }
}
