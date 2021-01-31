package TestSmoke.Р2_Разделы_меню.П4_Сериалы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_1_Переключение_сезонов extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Переключение сезонов")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void switchingSeasons() throws Exception {
        headerMenu.goToSerialsPage();
        serialsPage.chooseSeasonsMoreOneSeason();
        cardSerial.checkOpenCardSerial();
        cardSerial.chooseOtherSeason();
    }
}
