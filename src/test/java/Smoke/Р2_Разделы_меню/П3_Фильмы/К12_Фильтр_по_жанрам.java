package Smoke.Р2_Разделы_меню.П3_Фильмы;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К12_Фильтр_по_жанрам extends TestBase {
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
