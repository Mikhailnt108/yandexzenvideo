package Smoke.Р2_Разделы_меню.П3_Фильмы;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К14_Сброс_фильтров extends TestBase {
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
