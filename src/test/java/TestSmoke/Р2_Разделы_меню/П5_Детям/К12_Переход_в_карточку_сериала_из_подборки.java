package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К12_Переход_в_карточку_сериала_из_подборки extends TestBase {
    @Test
    public void goToSeriesFromCollection() {
        headerMenu.goToKidsPage();
        kidsPage.clickToTailCardSerial();
        kidsPage.checkOpenCardSerial();
    }
}
