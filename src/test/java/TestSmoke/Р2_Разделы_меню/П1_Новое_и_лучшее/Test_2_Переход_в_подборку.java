package TestSmoke.Р2_Разделы_меню.П1_Новое_и_лучшее;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_2_Переход_в_подборку extends TestBase {

    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "1. Новое и лучшее")
    @DisplayName(value ="Переход в подборку")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCollectionPage() {
        headerMenu.goToNilPage();
        headerMenu.clickToLinkAll();
        collectionPage.checkOpenCollectionPage();
   }
}
