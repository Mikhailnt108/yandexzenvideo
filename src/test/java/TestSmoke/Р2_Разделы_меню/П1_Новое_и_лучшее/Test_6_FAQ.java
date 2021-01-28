package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_6_FAQ extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "6. FAQ")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    public void checkFooter() {
        headerMenu.goToNilPage();
        footer.clickToLinkFromDevices();
        footer.clickToLinkFromSupport();
        footer.clickToLinkFromSocialNetworks();
        footer.clickToLinkFromDownloadApp();
        footer.clickToLinkDocsAndRules();
    }
}
