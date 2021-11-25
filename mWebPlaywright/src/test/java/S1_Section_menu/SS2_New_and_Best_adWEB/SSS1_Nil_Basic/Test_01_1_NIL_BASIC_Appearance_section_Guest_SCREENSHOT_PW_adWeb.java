package S1_Section_menu.SS2_New_and_Best_adWEB.SSS1_Nil_Basic;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_1_NIL_BASIC_Appearance_section_Guest_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "1. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1.1 NIL_Appearance_section_Guest_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_Appearance_section_Guest_SCREENSHOT() throws IOException, InterruptedException {
        // Guest:
        headerMenuPW.goToNilPage();
        nilPagePW.checkImageNilPageScrollGuestMWEB();
        nilPagePW.checkImageCherdakAndBannersGuestMWEB();
        nilPagePW.checkImageBlocksCollectionWidePageNilGuestMWEB();
        nilPagePW.checkImageBlockCollectionTvChannelWidePageNilGuestMWEB();
        nilPagePW.checkImageBlocksCincMWEB();
        nilPagePW.checkImageFooterWidePageGuestMWEB();
    }
}
