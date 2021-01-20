package SmokeTest.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К11_Сброс_фильтров extends TestBase {
    @Test
    public void ResetAllFilters() {
        headerMenu.goToSerialsPage();
        serialsPage.clickOnCountryInput();
        serialsPage.chooseOneCountry();
        serialsPage.clickOnGenreInput();
        serialsPage.chooseOneGenre();
        serialsPage.clickOnYearInput();
        serialsPage.chooseOneYearOnly();
        serialsPage.clickOnResetFiltersButton();
        serialsPage.checkResetAllFilters();
    }
}
