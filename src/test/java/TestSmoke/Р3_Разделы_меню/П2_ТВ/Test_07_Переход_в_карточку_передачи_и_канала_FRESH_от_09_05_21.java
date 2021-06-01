package TestSmoke.Р3_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_07_Переход_в_карточку_передачи_и_канала_FRESH_от_09_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Переход в карточку передачи и канала")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void tvProgramInAir() throws InterruptedException {
        headerMenu.goToTvPage();
        tvPage.checkOpenTvPageTabScheduleTv();
        tvPage.clickToLinkTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
        headerMenu.goToBack();
        tvPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        headerMenu.goToBack();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.clickToTailTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
}
}
