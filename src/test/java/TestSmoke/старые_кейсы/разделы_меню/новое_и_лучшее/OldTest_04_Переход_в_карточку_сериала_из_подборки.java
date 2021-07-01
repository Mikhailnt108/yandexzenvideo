package TestSmoke.старые_кейсы.разделы_меню.новое_и_лучшее;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OldTest_04_Переход_в_карточку_сериала_из_подборки extends TestBaseWebDriver {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value ="Переход в карточку сериала из подборки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
        public void goToCardSerialFromCollection() {
        headerMenu.goToNilPage();
        nilPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
    }

}
