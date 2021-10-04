package TestSmokeWebDriver.P4_Sections_menu.П2_Фильмы_FRESH_от_17_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_16_Сброс_фильтров_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Сброс фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
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
