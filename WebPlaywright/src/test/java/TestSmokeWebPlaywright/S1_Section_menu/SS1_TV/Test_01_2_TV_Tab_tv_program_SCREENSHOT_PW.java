package TestSmokeWebPlaywright.S1_Section_menu.SS1_TV;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuitePwNonAdWeb#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_2_TV_Tab_tv_program_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "1. TV")
    @DisplayName(value = "Tab_tv_program_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("31542006")
    @Test
    @Tag("SuitePwNonAdWeb#0")
    public void tab_tv_program_SCREENSHOT() throws Exception {
        tvPagePW.checkImageTvPageTabProgramTvForGuest();
    }
}
