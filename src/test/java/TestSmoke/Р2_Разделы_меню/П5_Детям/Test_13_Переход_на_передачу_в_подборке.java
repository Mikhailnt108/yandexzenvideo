package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_13_Переход_на_передачу_в_подборке extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "13. Переход на передачу в подборке")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToTvProgramFromCollection() {
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
    }
}
