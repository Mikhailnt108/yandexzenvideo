package TestSmokeWeb.Р4_Разделы_меню.П4_Детям_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#2", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_1_ДЕТЯМ_Переходы_Баннеры_RETEST extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="3.1 Переходы.Баннеры")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#2Exp")
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
