package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_15_Работа_стандартных_фильтров_FRESH_от_26_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Работа стандартных фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void standardFilters() throws Exception {
        headerMenu.goToFilmsPage();
        filmsPage.checkElementsFilmsPage();
        filmsPage.chooseOneGenre();
        filmsPage.checkCatalogViewFilmsPage();
        filmsPage.checkRequestResultOneGenre();
        filmsPage.chooseTwoGenre();
        filmsPage.checkRequestResultTwoGenre();
        filmsPage.chooseOneCountry();
        filmsPage.checkRequestResultOneCountryAndTwoGenre();
    }
}
