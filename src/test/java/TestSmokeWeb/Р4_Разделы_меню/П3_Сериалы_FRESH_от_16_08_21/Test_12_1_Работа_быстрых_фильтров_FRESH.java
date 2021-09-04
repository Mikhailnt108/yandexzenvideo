package TestSmokeWeb.Р4_Разделы_меню.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_12_1_Работа_быстрых_фильтров_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value = "Работа быстрых фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#2Exp")
    public void quickFilters() throws Exception {
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsSerialsPage();
        serialsPage.chooseOneQuickFilter();
        serialsPage.checkCatalogViewSerialsPage();
        serialsPage.checkRequestResultOneQuickFilter();
        serialsPage.chooseTwoQuickFilter();
        serialsPage.checkRequestResultTwoQuickFilter();
        serialsPage.checkUnplugQuickFilter();
    }
}
