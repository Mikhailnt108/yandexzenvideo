package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_2_Переход_в_подборку extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Переход в подборку")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCollectionPage() {
        headerMenu.goToNilPage();
        headerMenu.clickToLinkAll();
        collectionPage.checkOpenCollectionPage();
   }
}
