package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_14_Сброс_фильтров extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "14. Сброс фильтров")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void resetAllFilters() {
        headerMenu.goToFilmsPage();
        filmsPage.clickOnCountryInput();
        filmsPage.chooseOneCountry();
        filmsPage.clickOnGenreInput();
        filmsPage.chooseOneGenre();
        filmsPage.clickOnYearInput();
        filmsPage.chooseOneYearOnly();
        filmsPage.clickOnResetFiltersButton();
        filmsPage.checkResetAllFilters();
    }
}
