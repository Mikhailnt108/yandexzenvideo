package TestSmoke.Р4_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_01_Внешний_вид_раздела_ASHOT_FRESH_от_19_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void appearanceSectionNilPage() throws Exception {
        headerMenu.goToNilPage();
//        nilPage.checkImageDifferCherdakAndBanners();
//        nilPage.checkImageDifferBlocksCollection();
//        nilPage.checkImageDifferFooter();
//        nilPage.checkImageDifferNilPageScroll();
    }
}
