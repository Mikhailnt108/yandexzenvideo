package Smoke.Р2_Разделы_меню.П5_Детям;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К11_Переход_в_карточку_фильма_из_подборки extends TestBase {
    @Test
    public void goToCardFilmFromCollection() {
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardFilm();
        kidsPage.checkOpenCardFilm();


    }
}
