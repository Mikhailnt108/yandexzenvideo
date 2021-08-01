package TestSmoke.старые_кейсы.разделы_меню.детям;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class old_10_Переход_в_подборку_ДОБАВИТЬ_ASHOT extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "5. Детям")
    @DisplayName(value ="Переход в подборку")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCollection() {
        headerMenu.goToKidsPage();
        kidsPage.clickToAllButton();
        collectionsPage.checkOpenCollectionPageForKids();
    }
}
