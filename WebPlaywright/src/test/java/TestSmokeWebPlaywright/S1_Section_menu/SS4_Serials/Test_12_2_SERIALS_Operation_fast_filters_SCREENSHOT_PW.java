package TestSmokeWebPlaywright.S1_Section_menu.SS4_Serials;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuitePW#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_12_2_SERIALS_Operation_fast_filters_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "4. Serials")
    @DisplayName(value = "12_2_SERIALS_Operation_fast_filters_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePW#4")
    public void SERIALS_Operation_fast_filters_SCREENSHOT() throws Exception {
        headerMenuPW.goToSerialsPage();
        serialsPagePW.checkImageBlocksFiltersForGuest();
        serialsPagePW.checkImageScrollQuickFiltersForUnauthorized();
    }
}
