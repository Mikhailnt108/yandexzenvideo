package TestSmoke.Р4_Разделы_меню.П5_Детям;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_02_Навигация_по_разделу_FRESH_от_02_06_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Навигация по разделу")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id = "69")
    public void navigatingSection() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkAutoScrollBanners();
        kidsPage.checkScrollBannersToLeft();
        kidsPage.checkScrollBannersToRight();
        kidsPage.scrollСollectionToRightAndLeft();
    }
}
