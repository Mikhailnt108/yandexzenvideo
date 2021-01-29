package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_10_Переход_в_подборку_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "10. Переход в подборку")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCollection() {
        headerMenu.goToKidsPage();
        kidsPage.clickToAllButton();
        collectionPage.checkOpenCollectionPage();
    }
}
