package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;


public class Test_7_ASHOT_Скриншот_НиЛ_и_Футер extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Feature(value = "1. Новое и лучшее")
    @Story(value = "7. ASHOT Сравнение скриншотов: шапка НиЛ, блоки подборок, футер")
    @Severity(SeverityLevel.BLOCKER)
    @Test
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
