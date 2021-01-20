package SmokeTest.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Переход_в_подборку extends TestBase {
    @Test
    public void goToCollectionPage() {
        headerMenu.goToNilPage();
        headerMenu.clickToLinkAll();
        collectionPage.checkOpenCollectionPage();
   }
}
