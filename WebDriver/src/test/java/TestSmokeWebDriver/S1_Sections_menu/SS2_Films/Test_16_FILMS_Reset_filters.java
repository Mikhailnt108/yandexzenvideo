package TestSmokeWebDriver.S1_Sections_menu.SS2_Films;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_16_FILMS_Reset_filters extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "3. Films")
    @DisplayName(value ="Reset_filters")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("31542048")
    @Test
    @Tag("SuiteWD#1")
    public void resetAllFilters() throws InterruptedException {
        headerMenu.goToFilmsPage();
        filmsPage.chooseOneQuickFilter();
        filmsPage.chooseOneCountry();
        filmsPage.choosePeriodOfYears();
        filmsPage.checkCatalogViewFilmsPage();
        filmsPage.clickOnResetFiltersButton();
        filmsPage.checkResetAllFilters();
        filmsPage.checkCollectionsViewFilmsPage();
    }
}
