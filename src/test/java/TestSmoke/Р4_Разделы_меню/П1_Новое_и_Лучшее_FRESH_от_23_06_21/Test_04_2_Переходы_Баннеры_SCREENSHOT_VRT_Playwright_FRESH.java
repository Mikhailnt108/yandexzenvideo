package TestSmoke.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBasePlaywright;
import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_04_2_Переходы_Баннеры_SCREENSHOT_VRT_Playwright_FRESH extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Переходы. Баннеры (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test

    public void goToBanner() throws Exception {
        niLPagePW.checkImageCherdakAndBanners();
    }
}
