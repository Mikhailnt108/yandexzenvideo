package TestSmoke.Р4_Разделы_меню.П5_Детям;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_03_Переходы_Баннеры_FRESH__от_03_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переходы.Баннеры")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id = "70")
    public void goToBanner() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkImageDifferCherdakAndBanners();
        kidsPage.checkElementsBannersCarousel();
        kidsPage.switchingFromBannerToCardFilm();
        kidsPage.switchingFromBannerToCardSerial();
        kidsPage.switchingFromBannerToCardTvChannel();
    }
}
