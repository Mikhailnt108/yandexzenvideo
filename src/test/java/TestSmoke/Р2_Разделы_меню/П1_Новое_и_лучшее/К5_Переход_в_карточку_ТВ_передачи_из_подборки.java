package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К5_Переход_в_карточку_ТВ_передачи_из_подборки extends TestBase {
    @Test
    public void goToCardTvChannelFromCollection() {
        headerMenu.goToNilPage();
        tvPage.clickToTailCardTvProgram();
        cardTvChannel.checkOpenCardTvProgram();
    }
}
