package TestSmoke.Р3_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Навигация_по_разделу_FRESH_от_27_04_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Навигация по разделу")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void navigatingSection() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkAutoScrollBanners();
        nilPage.checkScrollBannersToLeft();
        nilPage.checkScrollBannersToRight();
        nilPage.scrollСollectionToRight();
        nilPage.scrollСollectionToLeft();
    }
}
