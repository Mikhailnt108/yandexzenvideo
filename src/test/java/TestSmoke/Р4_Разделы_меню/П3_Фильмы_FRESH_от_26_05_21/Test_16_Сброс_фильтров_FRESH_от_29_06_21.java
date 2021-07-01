package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_16_Сброс_фильтров_FRESH_от_29_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Сброс фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
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
