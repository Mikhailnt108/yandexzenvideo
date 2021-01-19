package Smoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К1_Пролистывание_подборки extends TestBase {
    @Test
    public void scrollCollection() throws Exception {
        headerMenu.goToNilPage();
        nilPage.scrollСollectionToRight();
        nilPage.scrollСollectionToLeft();
    }

}
