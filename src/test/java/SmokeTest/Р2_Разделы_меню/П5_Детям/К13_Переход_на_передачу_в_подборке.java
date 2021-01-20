package SmokeTest.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К13_Переход_на_передачу_в_подборке extends TestBase {
    @Test
    public void goToTvProgramFromCollection() {
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
    }
}
