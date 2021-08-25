package TestSmoke.Р4_Разделы_меню.П2_Фильмы_FRESH_от_17_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#1")
public class Test_15_ФИЛЬМЫ_Работа_стандартных_фильтров_RETEST19 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="15. Работа стандартных фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
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
