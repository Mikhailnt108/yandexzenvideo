package TestSmoke.Р4_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.awt.*;
import java.io.IOException;

public class Test_07_FAQ_Ashot_FRESH_от_29_04_21 extends TestBase {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value ="FAQ")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void checkFooter() throws IOException, AWTException {
        headerMenu.goToNilPage();
//        nilPage.checkImageDifferFooter();
        footer.clickToLinkFromDevices();
        footer.clickToLinkFromSupport();
        footer.clickToLinkFromSocialNetworks();
        footer.clickToLinkFromDownloadApp();
        footer.clickToLinkDocsAndRules();
    }
}
