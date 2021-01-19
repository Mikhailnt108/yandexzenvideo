package Smoke.Р2_Разделы_меню.П5_Детям;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К6_Переход_из_баннера_в_карточку_Смешанного_Пакета extends TestBase {
    @Test
    public void SwitchingFromBannerToCardPackage() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardPackage();
    }
}
