package Smoke.Р2_Разделы_меню.П5_Детям;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К1_Отображение_баннерной_зоны_ДОБАВИТЬ_ASHOT extends TestBase {
    @Test
    public void displayingBannerZone() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkElementsBannersCarousel();
    }
}
