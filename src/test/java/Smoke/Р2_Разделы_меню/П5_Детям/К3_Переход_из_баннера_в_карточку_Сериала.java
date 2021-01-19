package Smoke.Р2_Разделы_меню.П5_Детям;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К3_Переход_из_баннера_в_карточку_Сериала extends TestBase {
    @Test
    public void SwitchingFromBannerToCardSerial() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardSerial();
    }

}
