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

import java.io.IOException;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_08_1_TV_Program_in_air extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Sections_menu")
    @Story(value = "1. TV")
    @DisplayName(value ="TV_program_in_air")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31542010")
    @Test
    @Tag("SuiteWD#0")
    public void tvProgramInAir() throws IOException, InterruptedException {
        headerMenu.goToTvPage();
        tvPage.checkOpenTvPageTabScheduleTv();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.checkElementsTailsTvProgramInAir();
    }
}
