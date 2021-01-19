package Smoke.Р2_Разделы_меню.П5_Детям;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class
К4_Переход_из_баннера_в_карточку_Передачи extends TestBase {
    @Test
    public void SwitchingFromBannerToCardTvProgram() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardTvProgram();
    }



}
