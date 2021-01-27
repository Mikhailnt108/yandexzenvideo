package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_5_Переход_из_баннера_в_карточку_Канала extends TestBase {
    @Test
    public void SwitchingFromBannerToCardTvChannel() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardTvChannel();
    }
}
