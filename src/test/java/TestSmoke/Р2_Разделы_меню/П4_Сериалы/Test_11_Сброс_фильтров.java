package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_11_Сброс_фильтров extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "11. Сброс фильтров")
    @Severity(SeverityLevel.BLOCKER)
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
