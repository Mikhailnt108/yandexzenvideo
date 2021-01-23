package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_4_Переход_в_карточку_сериала_из_подборки extends TestBase {
    @Test
        public void goToCardSerialFromCollection() {
        headerMenu.goToNilPage();
        nilPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
    }

}
