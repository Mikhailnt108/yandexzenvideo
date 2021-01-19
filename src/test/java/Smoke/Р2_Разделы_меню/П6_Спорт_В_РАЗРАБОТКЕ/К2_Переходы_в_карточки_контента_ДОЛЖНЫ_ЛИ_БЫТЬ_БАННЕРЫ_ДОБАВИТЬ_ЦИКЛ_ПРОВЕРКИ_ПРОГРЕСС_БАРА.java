package Smoke.Р2_Разделы_меню.П6_Спорт_В_РАЗРАБОТКЕ;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Переходы_в_карточки_контента_ДОЛЖНЫ_ЛИ_БЫТЬ_БАННЕРЫ_ДОБАВИТЬ_ЦИКЛ_ПРОВЕРКИ_ПРОГРЕСС_БАРА extends TestBase {
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