package Smoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К4_Переход_в_карточку_сериала_из_подборки extends TestBase {
    @Test
        public void goToCardSerialFromCollection() {
        headerMenu.goToNilPage();
        nilPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
    }

}
