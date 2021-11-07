package TestSmokeWebDriver.S1_Sections_menu.SS2_Films;

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
@ResourceLock(value = "SuiteWD#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_15_ФИЛЬМЫ_Работа_стандартных_фильтров_RETEST19 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="15. Работа стандартных фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#1")
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
