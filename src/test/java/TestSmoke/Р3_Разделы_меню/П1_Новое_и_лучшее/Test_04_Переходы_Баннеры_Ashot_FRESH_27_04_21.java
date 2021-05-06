package TestSmoke.Р3_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_04_Переходы_Баннеры_Ashot_FRESH_27_04_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Переходы. Баннеры")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToBanner() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkElementsBanner();
        nilPage.checkImageDifferHeader();
        nilPage.switchingFromBannerToCardFilm();
        headerMenu.goToNilPage();
        nilPage.switchingFromBannerToCardSerial();

    }
}
