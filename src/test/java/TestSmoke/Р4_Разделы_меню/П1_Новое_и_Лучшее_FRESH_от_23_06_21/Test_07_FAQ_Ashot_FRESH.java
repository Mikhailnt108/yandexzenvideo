package TestSmoke.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

public class Test_07_FAQ_Ashot_FRESH extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value ="FAQ")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "22")
    public void checkFooter() throws IOException, AWTException {
        headerMenu.goToNilPage();
        nilPage.checkImageDifferFooter();
        footer.clickToLinkFromDevices();
        footer.clickToLinkFromSupport();
        footer.clickToLinkFromSocialNetworks();
        footer.clickToLinkFromDownloadApp();
        footer.clickToLinkDocsAndRules();
    }
}
