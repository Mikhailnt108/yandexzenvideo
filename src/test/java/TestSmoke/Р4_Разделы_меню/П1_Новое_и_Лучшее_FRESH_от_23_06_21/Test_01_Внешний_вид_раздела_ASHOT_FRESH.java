package TestSmoke.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Внешний_вид_раздела_ASHOT_FRESH extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и Лучшее")
    @DisplayName(value = "Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "16")
    public void appearanceSectionNilPage() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkImageDifferCherdakAndBanners();
        nilPage.checkImageDifferBlocksCollection();
        nilPage.checkImageDifferFooter();
        nilPage.checkImageDifferNilPageScroll();
    }
}