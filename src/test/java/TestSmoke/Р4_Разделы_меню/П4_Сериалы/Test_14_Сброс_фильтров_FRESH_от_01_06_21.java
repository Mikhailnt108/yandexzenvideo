package TestSmoke.Р4_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_14_Сброс_фильтров_FRESH_от_01_06_21 extends TestBase {
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
