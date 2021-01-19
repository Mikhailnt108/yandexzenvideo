package Smoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К3_Переход_в_карточку_фильма_из_подборки extends TestBase {
    @Test
    public void goToCardFilmFromCollection(){
        headerMenu.goToNilPage();
        nilPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
    }
}
