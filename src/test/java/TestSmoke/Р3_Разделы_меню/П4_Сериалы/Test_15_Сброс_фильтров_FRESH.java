package TestSmoke.Р3_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_15_Сброс_фильтров_FRESH extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Сброс фильтров")
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
