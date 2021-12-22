package S0_TV_channels;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "AndroidWebPW#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_08_2_TV_Tab_efir_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "1. TV")
    @DisplayName(value ="TV_Tab_efir_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("AndroidWebPW#0")
    public void tv_Tab_efir_SCREENSHOT() throws IOException, InterruptedException {
        // неавторизованный пользователь:
        tvPagePW.checkImageTabTvProgramInAirForGuestMWEB();
    }
}