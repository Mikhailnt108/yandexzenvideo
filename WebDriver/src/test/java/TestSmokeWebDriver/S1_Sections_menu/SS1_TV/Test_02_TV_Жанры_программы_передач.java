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
@ResourceLock(value = "SuiteWD#X", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_TV_Жанры_программы_передач extends TestBaseWebDriver {
    @Epic(value = "smoke-mftv-desktop-web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value ="Жанры программы передач")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#X")
    public void genresTvProgram() throws InterruptedException {
        headerMenu.goToTvPage();
        tvPage.checkOpenTvPageTabScheduleTv();
        tvPage.clickOnTabInRecording();
        tvPage.checkColorButtonChooseGenre();
        tvPage.checkСhannelsСorrespondGenres();
    }
}
