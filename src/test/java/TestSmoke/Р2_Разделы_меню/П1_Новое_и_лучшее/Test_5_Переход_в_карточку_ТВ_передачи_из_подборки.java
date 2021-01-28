package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_5_Переход_в_карточку_ТВ_передачи_из_подборки extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "5. Переход в карточку ТВ передачи из подборки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCardTvChannelFromCollection() {
        headerMenu.goToNilPage();
        tvPage.clickToTailCardTvProgram();
        cardTvChannel.checkOpenCardTvProgram();
    }
}
