package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_5_Передачи_в_эфире extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "5. Передачи в эфире")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void tvProgramInAir() {
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.checkAllTvProgramInAir();
    }
}
