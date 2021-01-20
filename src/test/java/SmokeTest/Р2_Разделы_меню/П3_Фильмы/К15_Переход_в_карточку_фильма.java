package SmokeTest.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К15_Переход_в_карточку_фильма extends TestBase {
    @Test
    public void GoToCardFilm() {
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm1FromAll();
        cardFilm.checkOpenCardFilm();
    }
}
