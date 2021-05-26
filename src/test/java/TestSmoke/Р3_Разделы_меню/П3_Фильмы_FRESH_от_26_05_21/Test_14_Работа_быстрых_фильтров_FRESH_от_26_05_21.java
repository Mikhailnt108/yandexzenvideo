package TestSmoke.Р3_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_14_Работа_быстрых_фильтров_FRESH_от_26_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Работа быстрых фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void quickFilters() throws Exception {
        headerMenu.goToFilmsPage();
        filmsPage.checkElementsFilmsPage();
//        filmsPage.checkImageDifferBreadcrumbsAndBlocksFilters();
//        filmsPage.checkImageDifferScrollQuickFilters();
        filmsPage.chooseOneQuickFilter();
        filmsPage.checkCatalogViewFilmsPage();
        filmsPage.checkRequestResultOneQuickFilter();
        filmsPage.chooseTwoQuickFilter();
        filmsPage.checkRequestResultTwoQuickFilter();
        filmsPage.checkUnplugQuickFilter();
    }
}
