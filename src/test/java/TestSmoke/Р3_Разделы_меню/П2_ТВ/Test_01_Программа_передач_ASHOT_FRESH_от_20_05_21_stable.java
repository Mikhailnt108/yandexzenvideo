package TestSmoke.Р3_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_01_Программа_передач_ASHOT_FRESH_от_20_05_21_stable extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value = "Программа передач")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void historyViewing() throws Exception {
        headerMenu.goToTvPage();
        tvPage.checkImageDifferTvPageTabProgramTv();
        tvPage.checkElementsTvPage();
        headerMenu.goToTvPage();
        tvPage.scrollTvPageTabTvProgram();

    }
}
