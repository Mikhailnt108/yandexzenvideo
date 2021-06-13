package TestSmoke.Р4_Разделы_меню.П8_Подборки;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;

public class Test_02_Действия_с_подборками_ДОБАВИТЬ_ASHOT extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "8. Подборки")
    @DisplayName(value ="Действия с подборками")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void actionsWithCollections() throws IOException, InterruptedException {
        headerMenu.goToAllCollectionsPage();
        allCollectionsPage.clickToTailCollection();
//        collectionsPage.checkImageDifferPageBlockCollection();
        collectionsPage.clickToTailContentOnPageCollect();
        collectionsPage.selectCollectionForKids();
        collectionsPage.clickToTailContentOnPageCollect();
        kidsPage.checkBackgroundForKids();
    }
}
