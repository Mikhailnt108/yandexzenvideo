package SmokeTest.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Переход_из_баннера_в_карточку_Фильма extends TestBase {
    @Test
    public void SwitchingFromBannerToCardFilm() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardFilm();
    }
}
