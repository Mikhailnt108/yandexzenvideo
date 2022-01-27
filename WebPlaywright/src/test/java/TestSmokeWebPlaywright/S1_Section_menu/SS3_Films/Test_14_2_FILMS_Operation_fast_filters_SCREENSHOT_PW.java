package TestSmokeWebPlaywright.S1_Section_menu.SS3_Films;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuitePwNonAdWeb#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_14_2_FILMS_Operation_fast_filters_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "3. Films")
    @DisplayName(value ="14_2_FILMS_Operation_fast_filters_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
//    @TmsLink("36965365")
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void FILMS_Operation_fast_filters_SCREENSHOT_PW() throws Exception {
        headerMenuPW.goToFilmsPage();
        filmsPagePW.checkImageBlocksFiltersForUnauthorized();
        filmsPagePW.checkImageScrollQuickFiltersForUnauthorized();
    }
}
