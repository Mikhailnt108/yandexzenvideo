package TestSmoke.Р4_Разделы_меню.П5_Детям;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_01_Внешний_вид_раздела_ASHOT_FRESH_от_02_06_21_D extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id = "68")
    public void appearanceSectioтKidsPage() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.checkImageDifferCherdakAndBanners();
        kidsPage.checkImageDifferBlocksCollection();
        kidsPage.checkImageDifferFooter();
        kidsPage.checkImageDifferKidsPageScroll();
    }
}
