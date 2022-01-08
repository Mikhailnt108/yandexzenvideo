package S0_TV_channels_DONE.SS3_Card_TV_program_DONE;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "AndroidWebPW#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_TV_Appearance_card_program_SCREENSHOT_DONE extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "0. TV_channels")
    @Story(value = "1. Section_TV")
    @DisplayName(value = "TV_Appearance_card_program")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("AndroidWebPW#0")
    public void TV_Appearance_card_program() throws InterruptedException, IOException {
        headerMenuPW.goToTabTv();
        tvPagePW.openCardTvChannelInRecord();
        cardTvChannelPW.tapOnCurrentTvProgramRecord();
        cardTvProgramPW.checkImageCardCurrentTvProgramForGuest();
        cardTvProgramPW.checkElementsCardTvProgram();
    }
}
