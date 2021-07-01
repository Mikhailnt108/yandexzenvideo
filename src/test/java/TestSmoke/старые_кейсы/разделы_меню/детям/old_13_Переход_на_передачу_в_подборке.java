package TestSmoke.старые_кейсы.разделы_меню.детям;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class old_13_Переход_на_передачу_в_подборке extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переход на передачу в подборке")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToTvProgramFromCollection() {
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
    }
}
