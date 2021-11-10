package TestSmokeWebDriver.S1_Sections_menu.SS1_TV;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_09_TV_Жанры_передач_в_эфире extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value ="9. Жанры передач в эфире")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#1")
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
