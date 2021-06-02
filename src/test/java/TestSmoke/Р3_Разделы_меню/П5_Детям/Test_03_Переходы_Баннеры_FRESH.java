package TestSmoke.Р3_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_03_Переходы_Баннеры_FRESH extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переходы Баннеры")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void goToBanner() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkImageDifferCherdakAndBanners();
        kidsPage.checkElementsBannersCarousel();
        kidsPage.switchingFromBannerToCardTvChannel();
        kidsPage.switchingFromBannerToCardFilm();
        kidsPage.switchingFromBannerToCardSerial();
    }
}
