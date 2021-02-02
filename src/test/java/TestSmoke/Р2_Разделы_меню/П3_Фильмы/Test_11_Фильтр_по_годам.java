package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_11_Фильтр_по_годам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Фильтр по годам")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Disabled
    public void filterByYearFilms() {
        headerMenu.goToFilmsPage();
        filmsPage.clickOnYearInput();
        filmsPage.checkRadioButtons();
        filmsPage.chooseOneYearOnly();
        filmsPage.checkRequestResultOneYearOnly();
        filmsPage.choosePeriodOfYears();
        filmsPage.checkRequestResultPeriodOfYears();
    }
}
