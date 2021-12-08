package S0_TV_channels.SS2_TV_channel_schedule;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "AndroidWebPW#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_TV_Appearance_schedule_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "0. TV_channels")
    @Story(value = "1. Section_TV")
    @DisplayName(value = "TV_Appearance_schedule")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("AndroidWebPW#0")
    public void TV_Appearance_schedule() throws InterruptedException, IOException {
        headerMenuPW.goToTabTv();
        tvPagePW.openCardTvChannelNonRecordHd();
        cardTvChannelPW.checkElementsScheduleNonRecordedTv();
        cardTvChannelPW.checkImageCardTvChannelNonRecorded();
        tvPagePW.checkImageFooterMWEB();
        headerMenuPW.goToTabTv();
        tvPagePW.openCardTvChannelInRecord();
        cardTvChannelPW.checkElementsScheduleRecordedTv();
        cardTvChannelPW.checkImageCardTvChannelRecorded();
        tvPagePW.checkImageFooterMWEB();
    }
}
