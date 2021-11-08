package TestSmokeWebDriver.S1_Sections_menu.SS3_Serials;

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
public class Test_01_1_SERIALS_Внешний_вид_раздела_Guest_Bug extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="1.1 Внешний вид раздела Guest")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#2")
    public void appearanceSectionSerialsPage() throws Exception {
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsSerialsPage();
        serialsPage.checkElementsBannersCarousel();
        serialsPage.autoScrollBanners();
        serialsPage.scrollBannersToLeft();
        serialsPage.scrollBannersToRight();
        serialsPage.scrollСollectionToRightAndLeft();
    }
}
