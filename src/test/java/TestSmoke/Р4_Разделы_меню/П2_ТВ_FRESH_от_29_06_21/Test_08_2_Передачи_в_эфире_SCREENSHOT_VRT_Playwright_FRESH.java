package TestSmoke.Р4_Разделы_меню.П2_ТВ_FRESH_от_29_06_21;

import base.TestBasePlaywright;
import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;

public class Test_08_2_Передачи_в_эфире_SCREENSHOT_VRT_Playwright_FRESH extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Передачи в эфире")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void tvProgramInAir() throws IOException, InterruptedException {
        tvPagePW.checkImageTabTvProgramInAir();

    }
}
