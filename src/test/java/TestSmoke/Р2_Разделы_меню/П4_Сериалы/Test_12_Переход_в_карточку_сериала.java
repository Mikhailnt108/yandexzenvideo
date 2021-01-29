package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_12_Переход_в_карточку_сериала extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "12. Переход в карточку сериала")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void GoToCardSerial() {
        headerMenu.goToSerialsPage();
        serialsPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
    }
}
