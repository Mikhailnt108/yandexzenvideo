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

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_07_TV_Transition_in_card_tv_program_and_channel extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Sections_menu")
    @Story(value = "1. TV")
    @DisplayName(value ="Transition_in_card_tv_program_and_channel")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31542021")
    @Test
    @Tag("SuiteWD#0")
    public void tvProgramInAir() throws InterruptedException {
        headerMenu.goToTvPage();
        tvPage.checkOpenTvPageTabScheduleTv();
        tvPage.clickToLinkTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
        headerMenu.goToBack();
        tvPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        headerMenu.goToBack();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.clickToTailTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
    }
}
