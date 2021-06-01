package TestSmoke.Р3_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_04_Переходы_Баннеры_ASHOT_FRESH_27_04_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Переходы. Баннеры")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void goToBanner() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkElementsBanner();
//        nilPage.checkImageDifferCherdakAndBanners();
        nilPage.switchingFromBannerToCardFilm();
        headerMenu.goToNilPage();
        nilPage.switchingFromBannerToCardSerial();

    }
}
