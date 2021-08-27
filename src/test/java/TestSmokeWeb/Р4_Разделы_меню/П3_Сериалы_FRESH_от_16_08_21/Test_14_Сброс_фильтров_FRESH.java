package TestSmokeWeb.Р4_Разделы_меню.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#1")
public class Test_14_Сброс_фильтров_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Сброс фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
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
