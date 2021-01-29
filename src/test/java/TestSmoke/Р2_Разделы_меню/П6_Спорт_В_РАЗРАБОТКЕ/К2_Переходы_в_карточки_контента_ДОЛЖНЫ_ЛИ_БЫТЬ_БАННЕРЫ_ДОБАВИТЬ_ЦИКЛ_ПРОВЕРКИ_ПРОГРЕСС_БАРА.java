package TestSmoke.Р2_Разделы_меню.П6_Спорт_В_РАЗРАБОТКЕ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class К2_Переходы_в_карточки_контента_ДОЛЖНЫ_ЛИ_БЫТЬ_БАННЕРЫ_ДОБАВИТЬ_ЦИКЛ_ПРОВЕРКИ_ПРОГРЕСС_БАРА extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Переходы в карточки контента")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToContentCards() {
        headerMenu.goToSportPage();
        sportPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        headerMenu.goToSportPage();
        sportPage.clickToTailTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
    }
}