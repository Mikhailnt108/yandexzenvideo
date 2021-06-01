package TestSmoke.Р3_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_14_Работа_стандартных_фильтров_FRESH_от_01_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value = "Работа стандартных фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
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
