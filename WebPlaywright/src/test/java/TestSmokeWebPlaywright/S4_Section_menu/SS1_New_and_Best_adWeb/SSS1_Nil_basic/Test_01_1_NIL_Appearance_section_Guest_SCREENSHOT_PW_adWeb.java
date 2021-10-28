package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS1_Nil_basic;

import base.TestBasePlaywright;
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
@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_1_NIL_Appearance_section_Guest_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "1.1 NIL_Appearance_section_Guest_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_Appearance_section_Guest_SCREENSHOT() throws IOException, InterruptedException {
        // Guest:
        headerMenuPW.goToNilPage();
        nilPagePW.checkImageNilPageScrollGuest();
        nilPagePW.checkImageCherdakAndBannersGuest();
        nilPagePW.checkImageBlocksCollectionWidePageNilGuest();
        nilPagePW.checkImageBlockCollectionTvChannelWidePageNilGuest();
//        nilPagePW.checkImageBlocksCollectionWithoutHeader();
        nilPagePW.checkImageFooterWidePageGuest();
    }
}
