package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_12_Фильтр_по_жанрам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "12. Фильтр по жанрам")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void filterByGenres() {
        headerMenu.goToFilmsPage();
        filmsPage.clickOnGenreInput();
        filmsPage.checkCheckboxes();
        filmsPage.chooseOneGenre();
        filmsPage.checkRequestResultOneGenre();
        filmsPage.chooseTwoGenre();
        filmsPage.checkRequestResultTwoGenre();


    }
}
