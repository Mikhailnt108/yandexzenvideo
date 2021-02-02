package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;


public class Test_7_ASHOT_Скриншот_НиЛ_и_Футер extends TestBase {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value ="ASHOT Скриншот НиЛ и Футер")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Disabled
    public void screenshotNilAndFooter() throws AWTException, IOException {
        headerMenu.goToNilPage();
        //nilPage.createScreenShot();
        //nilPage.imageDifferPageHeader();
        //nilPage.imageDifferPageAll();
        nilPage.imageDifferHeader();
        nilPage.imageDifferCollections();
        nilPage.imageDifferFooter();
    }
}
