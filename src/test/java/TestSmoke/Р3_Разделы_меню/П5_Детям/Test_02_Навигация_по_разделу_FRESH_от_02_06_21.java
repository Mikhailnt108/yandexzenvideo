package TestSmoke.Р3_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_02_Навигация_по_разделу_FRESH_от_02_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Навигация по разделу")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void navigatingSection() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkAutoScrollBanners();
        kidsPage.checkScrollBannersToLeft();
        kidsPage.checkScrollBannersToRight();
        kidsPage.scrollСollectionToRightAndLeft();
    }
}
