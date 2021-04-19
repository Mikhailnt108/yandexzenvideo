package TestSmoke.Р3_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_12_Фильтр_по_жанрам extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Фильтр по жанрам")
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
