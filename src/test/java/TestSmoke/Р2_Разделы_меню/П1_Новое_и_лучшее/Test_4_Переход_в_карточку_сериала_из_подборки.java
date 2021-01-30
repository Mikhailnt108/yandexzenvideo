package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

public class Test_4_Переход_в_карточку_сериала_из_подборки extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Переход в карточку сериала из подборки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
        public void goToCardSerialFromCollection() {
        headerMenu.goToNilPage();
        nilPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
    }

}
