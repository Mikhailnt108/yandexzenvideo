package TestSmokeWeb.Р4_Разделы_меню.П4_Детям_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_Навигация_по_разделу_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Навигация по разделу")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#2Exp")
    public void navigatingSection() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkAutoScrollBanners();
        kidsPage.checkScrollBannersToLeft();
        kidsPage.checkScrollBannersToRight();
        kidsPage.scrollСollectionToRightAndLeft();
    }
}
