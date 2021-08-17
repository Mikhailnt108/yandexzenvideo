package TestSmoke.Р4_Разделы_меню.П4_Сериалы_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_02_Переход_в_карточку_сериала_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Переход в карточку сериала")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void GoToCardSerial() {
        headerMenu.goToSerialsPage();
        serialsPage.switchingFromBannerToCardSerial();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToSerialsPage();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToSerialsPage();
        serialsPage.clickToLinkAllOnCollectionBlock();
        serialsPage.clickToFirstTailCardSerial();
        cardSerial.checkOpenCardSerial();
    }
}
