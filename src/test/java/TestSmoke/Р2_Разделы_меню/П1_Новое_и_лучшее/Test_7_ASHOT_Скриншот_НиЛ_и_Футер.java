package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;


public class Test_7_ASHOT_Скриншот_НиЛ_и_Футер extends TestBase {
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
