package Smoke.Р2_Разделы_меню.П3_Фильмы;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К11_Фильтр_по_годам extends TestBase {
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
