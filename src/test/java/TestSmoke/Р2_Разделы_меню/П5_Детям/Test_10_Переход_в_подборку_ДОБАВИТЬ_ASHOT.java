package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_10_Переход_в_подборку_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переход в подборку")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCollection() {
        headerMenu.goToKidsPage();
        kidsPage.clickToAllButton();
        collectionPage.checkOpenCollectionPage();
    }
}
