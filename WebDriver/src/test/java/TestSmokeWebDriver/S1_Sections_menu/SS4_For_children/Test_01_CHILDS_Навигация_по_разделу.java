package TestSmokeWebDriver.S1_Sections_menu.SS4_For_children;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_CHILDS_Навигация_по_разделу extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Навигация по разделу")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#2")
    public void navigatingSection() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkAutoScrollBanners();
        kidsPage.checkScrollBannersToLeft();
        kidsPage.checkScrollBannersToRight();
        kidsPage.scrollСollectionToRightAndLeft();
    }
}
