package TestSmokeWebDriver.Р4_Разделы_меню.П2_Фильмы_FRESH_от_17_08_21;

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
public class Test_14_1_Работа_быстрых_фильтров_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Работа быстрых фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void quickFilters() throws Exception {
        headerMenu.goToFilmsPage();
        filmsPage.checkElementsFilmsPage();
        headerMenu.goToFilmsPage();
        filmsPage.chooseOneQuickFilter();
        filmsPage.checkCatalogViewFilmsPage();
        filmsPage.checkRequestResultOneQuickFilter();
        filmsPage.chooseTwoQuickFilter();
        filmsPage.checkRequestResultTwoQuickFilter();
        filmsPage.checkUnplugQuickFilter();
    }
}
