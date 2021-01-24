package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_12_Фильтр_по_жанрам extends TestBase {
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
