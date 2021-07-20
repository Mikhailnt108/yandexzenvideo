package TestSmoke.старые_кейсы.разделы_меню.новое_и_лучшее;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class old_01_Внешний_вид_раздела_ASHOT_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceSectionNilPage() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkImageDifferCherdakAndBanners();
        nilPage.checkImageDifferBlocksCollection();
        nilPage.checkImageDifferFooter();
        nilPage.checkImageDifferNilPageScroll();
    }
}