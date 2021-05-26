package TestSmoke.старые_кейсы.разделы_меню.фильмы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Old_Фильтр_по_годам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Фильтр по годам")
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
