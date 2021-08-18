package TestSmoke.Р0_Разделы_меню_ТВ.П1_ТВ_FRESH;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_01_1_Программа_передач_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value = "Программа передач")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void historyViewing() throws Exception {
        headerMenu.goToTvPage();
        tvPage.checkElementsTvPage();
        headerMenu.goToTvPage();
        tvPage.scrollTvPageTabTvProgram();

    }
}
