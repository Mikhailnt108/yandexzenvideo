package TestSmoke.Р4_Разделы_меню.П2_ТВ_FRESH_от_29_06_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_01_1_Программа_передач_ASHOT_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value = "Программа передач")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void historyViewing() throws Exception {
        headerMenu.goToTvPage();
        tvPage.checkImageDifferTvPageTabProgramTv();
        tvPage.checkElementsTvPage();
        headerMenu.goToTvPage();
        tvPage.scrollTvPageTabTvProgram();

    }
}
