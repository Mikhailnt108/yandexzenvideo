package TestSmokeWebDriver.S1_Sections_menu.SS3_Serials;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_14_SERIALS_Reset_filters extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "4. Serials")
    @DisplayName(value ="Reset_filters")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31542062")
    @Test
    @Tag("SuiteWD#2")
    public void resetAllFilters() throws InterruptedException {
        headerMenu.goToFilmsPage();
        serialsPage.chooseOneQuickFilter();
        serialsPage.chooseOneCountry();
        serialsPage.choosePeriodOfYears();
        serialsPage.checkCatalogViewSerialsPage();
        serialsPage.clickOnResetFiltersButton();
        serialsPage.checkResetAllFilters();
        serialsPage.checkCollectionsViewSerialsPage();
    }
}
