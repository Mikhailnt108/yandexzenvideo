package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_1_Переключение_сезонов extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Переключение сезонов")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void switchingSeasons() throws Exception {
        headerMenu.goToSerialsPage();
        serialsPage.chooseSeasonsMoreOneSeason();
        cardSerial.checkOpenCardSerial();
        cardSerial.chooseOtherSeason();
    }
}
