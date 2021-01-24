package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_12_Переход_в_карточку_сериала extends TestBase {
    @Test
    public void GoToCardSerial() {
        headerMenu.goToSerialsPage();
        serialsPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
    }
}
