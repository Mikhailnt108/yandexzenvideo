package TestSmoke.старые_кейсы.разделы_меню.новое_и_лучшее;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;


public class OldAshot_07_Скриншот_НиЛ_и_Футер extends TestBaseWebDriver {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value ="ASHOT Скриншот НиЛ и Футер")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void screenshotNilAndFooter() throws AWTException, IOException, InterruptedException {
        headerMenu.goToNilPage();
        //nilPage.createScreenShot();
        //nilPage.imageDifferPageHeader();
        nilPage.checkImageDifferNilPageScroll();
        nilPage.checkImageDifferCherdakAndBanners();
        nilPage.checkImageDifferBlocksCollection();
        nilPage.checkImageDifferFooter();
    }
}
