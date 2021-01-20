package SmokeTest.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К9_Пролистывание_подборки extends TestBase {
    @Test
    public void scrollCollectionForChildren() throws Exception {
        headerMenu.goToKidsPage();
        kidsPage.scrollСollectionToRight();
        kidsPage.scrollСollectionToLeft();
    }
}
