package TestSmoke.Р4_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_02_Переход_в_карточку_сериала_FRESH_от_27_05_21 extends TestBase {
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
        serialsPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
        headerMenu.goToSerialsPage();
        serialsPage.clickToLinkAllOnCollectionBlock();
        serialsPage.clickToTailCardSerial();
        cardSerial.checkOpenCardSerial();
    }
}
