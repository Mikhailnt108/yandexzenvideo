package TestSmokeWeb.Р4_Разделы_меню.П7_Подборки;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#2")
public class Test_02_1_Действия_с_подборками_FRESH_Баг_нет_детского_фона_страницы_детской_коллекции extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "8. Подборки")
    @DisplayName(value ="2.1 Действия с подборками")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void actionsWithCollections() throws InterruptedException {
        headerMenu.goToAllCollectionsPage();
        allCollectionsPage.clickToTailCollection();
        collectionsPage.clickToTailContentOnPageCollect();
        allCollectionsPage.selectCollectionForKids();
        kidsPage.checkBackgroundPageCollectionForKids();
        collectionsPage.clickToTailContentOnPageCollect();
        kidsPage.checkBackgroundCardContentForKids();
    }
}
