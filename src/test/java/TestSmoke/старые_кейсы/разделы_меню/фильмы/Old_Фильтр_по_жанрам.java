package TestSmoke.старые_кейсы.разделы_меню.фильмы;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Old_Фильтр_по_жанрам extends TestBaseWebDriver {
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
