package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_14_Работа_быстрых_фильтров_ASHOT_FRESH_от_29_06_21 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Работа быстрых фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void quickFilters() throws Exception {
        headerMenu.goToFilmsPage();
        filmsPage.checkElementsFilmsPage();
        filmsPage.checkImageDifferBreadcrumbsAndBlocksFiltersGuest();
        headerMenu.goToFilmsPage();
        filmsPage.checkImageDifferScrollQuickFilters();
        filmsPage.chooseOneQuickFilter();
        filmsPage.checkCatalogViewFilmsPage();
        filmsPage.checkRequestResultOneQuickFilter();
        filmsPage.chooseTwoQuickFilter();
        filmsPage.checkRequestResultTwoQuickFilter();
        filmsPage.checkUnplugQuickFilter();
    }
}
