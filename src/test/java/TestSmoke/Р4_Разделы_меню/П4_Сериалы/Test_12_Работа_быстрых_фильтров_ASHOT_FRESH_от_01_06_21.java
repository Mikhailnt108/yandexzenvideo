package TestSmoke.Р4_Разделы_меню.П4_Сериалы;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_12_Работа_быстрых_фильтров_ASHOT_FRESH_от_01_06_21 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value = "Работа быстрых фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void quickFilters() throws Exception {
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsSerialsPage();
//        serialsPage.checkImageDifferBreadcrumbsAndBlocksFilters();
//        serialsPage.checkImageDifferScrollQuickFilters();
        serialsPage.chooseOneQuickFilter();
        serialsPage.checkCatalogViewSerialsPage();
        serialsPage.checkRequestResultOneQuickFilter();
        serialsPage.chooseTwoQuickFilter();
        serialsPage.checkRequestResultTwoQuickFilter();
        serialsPage.checkUnplugQuickFilter();
    }
}
