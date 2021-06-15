package TestSmoke.Р4_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_04_Переходы_Баннеры_ASHOT_FRESH_27_04_21_D extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Переходы. Баннеры")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id = "19")
    public void goToBanner() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkElementsBanner();
        nilPage.checkImageDifferCherdakAndBanners();
        nilPage.switchingFromBannerToCardFilm();
        headerMenu.goToNilPage();
        nilPage.switchingFromBannerToCardSerial();

    }
}
