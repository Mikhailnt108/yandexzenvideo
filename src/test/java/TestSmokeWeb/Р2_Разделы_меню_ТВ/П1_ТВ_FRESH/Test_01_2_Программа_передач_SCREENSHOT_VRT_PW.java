package TestSmokeWeb.Р2_Разделы_меню_ТВ.П1_ТВ_FRESH;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuitePW", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_2_Программа_передач_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value = "Программа передач (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void historyViewing() throws Exception {
        tvPagePW.checkImageTvPageTabProgramTvForGuest();
    }
}
