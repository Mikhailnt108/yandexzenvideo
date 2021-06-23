package TestSmoke.Р4_Разделы_меню.П1_Новое_и_Лучшее_FRESH_от_23_06_21;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Навигация_по_разделу_FRESH extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value = "Навигация по разделу")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TestRailCase(id = "17")
    public void navigatingSection() throws Exception {
        headerMenu.goToNilPage();
        nilPage.checkAutoScrollBanners();
        nilPage.checkScrollBannersToLeft();
        nilPage.checkScrollBannersToRight();
        nilPage.scrollСollectionToRightAndLeft();
    }
}