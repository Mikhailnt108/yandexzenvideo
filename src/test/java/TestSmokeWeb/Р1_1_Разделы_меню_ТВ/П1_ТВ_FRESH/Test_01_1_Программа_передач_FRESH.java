package TestSmokeWeb.Р1_1_Разделы_меню_ТВ.П1_ТВ_FRESH;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_1_Программа_передач_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value = "Программа передач")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1Exp")
    public void historyViewing() throws Exception {
        headerMenu.goToTvPage();
        tvPage.checkElementsTvPage();
        headerMenu.goToTvPage();
        tvPage.scrollTvPageTabTvProgram();
    }
}
