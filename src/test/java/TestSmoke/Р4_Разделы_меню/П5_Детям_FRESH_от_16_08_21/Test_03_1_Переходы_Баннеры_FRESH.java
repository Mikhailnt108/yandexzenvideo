package TestSmoke.Р4_Разделы_меню.П5_Детям_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_03_1_Переходы_Баннеры_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переходы.Баннеры")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void goToBanner() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkElementsBannersCarousel();
        kidsPage.switchingFromBannerToCardFilm();
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardSerial();
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardTvChannel();
    }
}
