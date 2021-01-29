package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_11_Фильтр_по_годам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "11. Фильтр по годам")
    @Severity(SeverityLevel.BLOCKER)
    @Test
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
