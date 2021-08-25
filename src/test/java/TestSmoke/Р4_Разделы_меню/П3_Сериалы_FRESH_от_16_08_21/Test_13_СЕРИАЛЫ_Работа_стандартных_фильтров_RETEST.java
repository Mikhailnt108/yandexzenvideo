package TestSmoke.Р4_Разделы_меню.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#1")
public class Test_13_СЕРИАЛЫ_Работа_стандартных_фильтров_RETEST extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value = "13. Работа стандартных фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void standardFilters() throws Exception {
        headerMenu.goToSerialsPage();
        serialsPage.checkElementsSerialsPage();
        serialsPage.chooseOneGenre();
        serialsPage.checkCatalogViewSerialsPage();
        serialsPage.checkRequestResultOneGenre();
        serialsPage.chooseTwoGenre();
        serialsPage.checkRequestResultTwoGenre();
        serialsPage.chooseOneCountry();
        serialsPage.checkRequestResultOneCountryAndTwoGenre();
    }
}
