package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_10_Переход_в_подборку_ДОБАВИТЬ_ASHOT extends TestBase {
    @Test
    public void goToCollection() {
        headerMenu.goToKidsPage();
        kidsPage.clickToAllButton();
        collectionPage.checkOpenCollectionPage();
    }
}
