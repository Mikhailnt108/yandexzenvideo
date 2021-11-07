package TestSmokeWebPlaywright.S1_Section_menu.SS5_For_children;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuitePW#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_CHILDS_Appearance_section_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "5. For_children")
    @DisplayName(value ="02_CHILDS_Appearance_section_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePW#4")
    public void CHILDS_Appearance_section_SCREENSHOT() throws Exception {
        // пользователь НЕ авторизован:
        kidsPagePW.checkImageKidsPageScrollForGuest();
        kidsPagePW.checkImageCherdakAndBannersForGuest();
        kidsPagePW.checkImageBlocksCollectionWithHeaderFofGuest();
        kidsPagePW.checkImageBlocksCollectionWithoutHeaderForGuest();
        kidsPagePW.checkImageFooterForGuest();
//        kidsPagePW.checkBackgroundKidsPage();
    }
}
