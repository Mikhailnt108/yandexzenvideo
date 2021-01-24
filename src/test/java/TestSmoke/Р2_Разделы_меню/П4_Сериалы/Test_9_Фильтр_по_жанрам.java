package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_9_Фильтр_по_жанрам extends TestBase {
    @Test
    public void filterByGenre() {
        headerMenu.goToSerialsPage();
        serialsPage.clickOnGenreInput();
        serialsPage.checkCheckboxes();
        serialsPage.chooseOneGenre();
        serialsPage.checkRequestResultOneGenre();
        serialsPage.chooseTwoGenre();
        serialsPage.checkRequestResultTwoGenre();
    }
}
