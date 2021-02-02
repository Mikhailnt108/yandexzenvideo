package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_6_FAQ extends TestBase {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value ="FAQ")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    @Disabled
    public void checkFooter() {
        headerMenu.goToNilPage();
        footer.clickToLinkFromDevices();
        footer.clickToLinkFromSupport();
        footer.clickToLinkFromSocialNetworks();
        footer.clickToLinkFromDownloadApp();
        footer.clickToLinkDocsAndRules();
    }
}
