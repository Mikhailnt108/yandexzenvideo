package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class
Test_4_Переход_из_баннера_в_карточку_Передачи extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переход из баннера в карточку Передачи")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void SwitchingFromBannerToCardTvProgram() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.switchingFromBannerToCardTvProgram();
    }



}
