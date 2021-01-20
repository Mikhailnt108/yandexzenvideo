package SmokeTest.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К8_Пролистывание_баннера extends TestBase {
    @Test
    public void SwitchingFromBannerToCardPackage() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.autoScrollBanners();
        kidsPage.scrollBannersToLeft();
        kidsPage.scrollBannersToRight();
    }
}
