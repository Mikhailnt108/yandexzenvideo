package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_13_Фильтр_по_странам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Фильтр по странам")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void filterByCountry() {
        headerMenu.goToFilmsPage();
        filmsPage.clickOnCountryInput();
        filmsPage.checkCheckboxesInCountry();
        filmsPage.chooseOneCountry();
        filmsPage.checkRequestResultOneCountry();
        filmsPage.chooseTwoCountry();
        filmsPage.checkRequestResultTwoCountry();
    }
}
